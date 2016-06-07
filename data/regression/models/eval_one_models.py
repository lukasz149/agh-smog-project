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

features_order = ['pm10', 'nox', 'co', 'pm2.5', 'o3', 'co-8h', 'no', 'c6h6', 'no2', 'so2', 'wind-direction',
                  'humidity', 'pressure', 'wind-speed', 'rain', 'temperature', 'hour', 'weekday', 'monthday',
                  'weekyear', 'dayyear', 'month']
general_features = ['wind-direction', 'humidity', 'pressure', 'wind-speed', 'rain',
                    'temperature', 'hour', 'weekday', 'monthday', 'weekyear', 'dayyear', 'month']
general_features_order = [features_order.index(x) for x in general_features]


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


def fetch_data_for_prediction(c, mean, date):
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

    batch = []
    d = split_date(date)
    for w, s in zip(weather_data, smog_data):
        for n, p in zip(weather_list, w):
            d[weather_dict[n]] = p if p is not None else mean[weather_dict[n]]
        for n, p in zip(smog_list, s):
            d[smog_dict[n]] = p if p is not None else mean[smog_dict[n]]
        batch.append([d[v] for v in features_order])

    return np.array(batch)


def predict_smog(models, data):
    result = {}
    for subst in smog_dict.values():
        predictions = models[subst].predict(data[:, [features_order.index(subst)] + general_features_order])
        result[subst] = predictions
    return result


def main():
    import sys
    if len(sys.argv) < 2:
        print('Date of prediction not found')
        print('Usage: [date]')
        return

    date = sys.argv[1]
    with open('smog-one-models.pickle', 'rb') as save:
        models = pickle.load(save)
    with open('mean-values.pickle', 'rb') as save:
        means = pickle.load(save)
    connection = sqlite3.connect('db')
    c = connection.cursor()
    batch = fetch_data_for_prediction(c, means, date)
    predicted = predict_smog(models, batch)

    # 0 => model with only one parameter ans
    for hour in range(24):
        c.execute("insert into Prognozy (Data, Stacja, Godzina, Model, PylZawieszonyPM10) values ('%s', %s, %s, %s, %f)" % (
            date, '7', hour, '0', predicted['pm10'][hour]))
    connection.commit()
    print('Done.')


if __name__ == '__main__':
    main()
