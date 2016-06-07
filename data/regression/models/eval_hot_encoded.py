import pickle
import sqlite3
import pandas as pd
import numpy as np
from sklearn import linear_model

weather_dict = {
    'Godzina': 'hour',
    'AvgPredkoscWiatruavg': 'wind-speed',
    'AvgKierunekWiatruavg': 'wind-direction',
    'TempPowietrzaavg': 'temperature',
    'Cisnienieavg': 'pressure',
    'Wilgotnoscavg': 'humidity',
    'Opadavg': 'rain',
    'Gradavg': 'hail'
}

smog_dict = {
    # 'Stacja': 'station',
    'PylZawieszonyPM10': 'pm10',
    'TlenekWegla': 'co',
    'DwutlenekAzotu': 'no2',
    'TlenekAzotu': 'no',
    'TlenkiAzotu': 'nox',
    'PylZawieszonyPM25': 'pm2.5',
    'TlenekWegla8h': 'co-8h',
    'benzen': 'c6h6',
    'DwutlenekSiarki': 'so2',
    'Ozon': 'o3',
    # 'Ozon8h': 'o3-8h'
}

smog_save_list = smog_dict.values()
smog_dict_rev = {val: key for key, val in smog_dict.items()}
weather_dict_rev = {val: key for key, val in weather_dict.items()}

general_features = ['pm10', 'wind-direction', 'humidity', 'pressure', 'wind-speed', 'rain',
                    'temperature', 'hour', 'weekday', 'monthday', 'weekyear', 'dayyear', 'month']

features_to_encode = ['hour', 'weekday', 'monthday', 'weekyear', 'dayyear', 'month']
features_min_maxes = {
    'hour': (0, 23),
    'weekday': (0, 6),
    'monthday': (1, 31),
    'weekyear': (1, 53),
    'dayyear': (1, 366),
    'month': (1, 12),
}


def to_hot_encoding(data, column):
    temp = data[column]
    min_value, max_value = features_min_maxes[column]
    for i in range(min_value, max_value + 1):
        data['%s-%d' % (column, i)] = np.array(temp == i, dtype=np.int32)
    return data


def to_sin_cos_encoding(data, column):
    temp = data[column]
    min_value, max_value = features_min_maxes[column]
    data[column + '-sin'] = np.sin((temp - min_value) * np.pi * 2. / (max_value - min_value)) + min_value
    data[column + '-cos'] = np.cos((temp - min_value) * np.pi * 2. / (max_value - min_value)) + min_value
    return data


def split_date(date):
    from datetime import datetime
    dates = pd.to_datetime(datetime.strptime(date, '%Y-%m-%d'))
    return {
        'weekday': dates.dayofweek,
        'monthday': dates.day,
        'weekyear': dates.weekofyear,
        'dayyear': dates.dayofyear,
        'month': dates.month,
    }


def fetch_data_for_prediction(c, date):
    smog_list = smog_dict.keys()
    smog_data = []
    for row in c.execute(
                    "select %s from Smog where Stacja = 7 and Data = '%s' order by Godzina" % (', '.join(smog_list),
                                                                                               date)):
        smog_data.append(row)
    weather_list = weather_dict.keys()
    weather_data = []
    for row in c.execute("select %s from Pogoda where Data = date('%s', '+1 day') order by Godzina" %
                                 (', '.join(weather_list), date)):
        weather_data.append(row)

    batch = pd.DataFrame()
    d = split_date(date)
    for w, s in zip(weather_data, smog_data):
        for n, p in zip(weather_list, w):
            d[weather_dict[n]] = p if p is not None else 0.
        for n, p in zip(smog_list, s):
            d[smog_dict[n]] = p if p is not None else 0.
        batch = batch.append({v: d[v] for v in general_features}, ignore_index=True)

    for feature in features_to_encode:
        batch = to_hot_encoding(batch, feature)
        batch = to_sin_cos_encoding(batch, feature)

    return batch


def predict_smog(model, data):
    return model['model'].predict(data[model['features']])


def main():
    import sys
    if len(sys.argv) < 2:
        print('Date of prediction not found')
        print('Usage: [date]')
        return

    date = sys.argv[1]
    with open('smog-more-models.pickle', 'rb') as save:
        models = pickle.load(save)
    connection = sqlite3.connect('db')
    c = connection.cursor()
    batch = fetch_data_for_prediction(c, date)
    models_idx = {'hot_encoding': '1',
                  'sin_cos_encoding': '2',
                  'both': '3',
                  'prev_day': '4'}

    for name, model in models.items():
        predicted = predict_smog(model, batch)
        for i in range(len(batch)):
            c.execute(
                "insert into Prognozy (Data, Stacja, Godzina, Model, PylZawieszonyPM10) values ('%s', %s, %d, %s, %f)" %
                (date, '7', batch['hour'][i], models_idx[name], predicted[i]))
        connection.commit()
    print('Done.')


if __name__ == '__main__':
    main()
