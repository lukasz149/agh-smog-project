import json
import requests
import datetime
from datetime import date, timedelta
import codecs


def daterange(start_date, end_date):
    for n in range(int((end_date - start_date).days)):
        yield start_date + timedelta(n)


def list_to_str(k):
    d = ""
    for x in k:
        d = str(d) + "-" + str(x)
    return d[1:]


# start_date = date(2007, 1, 1)
# end_date = date(2007, 1, 2)
# stations_data = {"6": [1711,44,46,202,43,42,45], "152": [1747],
#                  "153": [1752], "16": [144,149,146,148,242,143,145], "149": [1725,1723,1724,1726],
#                  "7": [49,54,61,57,211,53,50,55]}

if __name__ == "__main__":
    start_date = date(2016, 4, 6)
    end_date = date(2016, 4, 7)
    stations_data = {"6": [44, 46, 202, 43, 42, 45], "152": [1747],
                     "153": [1752], "16": [144, 149, 146, 148, 242, 143, 145], "149": [1725, 1723, 1724, 1726],
                     "7": [49, 54, 61, 57, 211, 53, 50, 55]}

    for stat_number, stat_param in stations_data.items():
        for single_date in daterange(start_date, end_date):
            ref = 'http://monitoring.krakow.pios.gov.pl/dane-pomiarowe/automatyczne/stacja/' + str(
                stat_number) + '/parametry/' + str(list_to_str(stat_param))
            response = requests.post(
                url='http://monitoring.krakow.pios.gov.pl/dane-pomiarowe/pobierz',
                data={
                    'query': json.dumps({
                        "measType": "Auto",
                        "viewType": "Station",
                        "dateRange": "Day",
                        "date": str(single_date.strftime("%d.%m.%Y")),
                        "viewTypeEntityId": str(stat_number),
                        "channels": stat_param
                    })
                },
                headers={
                    'Referer': ref,
                    'Cookie': 'start_selector_nth=0; start_selector_hide=yes',
                    'Origin': 'http://monitoring.krakow.pios.gov.pl',
                    'Accept': 'application/json, text/javascript, */*; q=0.01',
                    'Accept-Encoding': 'gzip, deflate, lzma',
                    'DNT': '1',
                    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 OPR/35.0.2066.92',
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
                    'Host': 'monitoring.krakow.pios.gov.pl',
                    'X-Requested-With': 'XMLHttpRequest',
                    'Connection': 'keep-alive',
                    'Accept-Language': 'pl-PL,pl;q=0.8,en-US;q=0.6,en;q=0.4'
                }
            )

            d = response.json()
            print(str(stat_number) + ' <> ' + str(single_date.strftime("%Y-%m-%d")), '-->', d['success'])
            json_file_name = 'smog/' + str(single_date.strftime("%Y-%m-%d")) + ".json"
            with codecs.open(json_file_name, "w", 'utf-8') as json_file:
                json.dump(d, json_file)

            file_name = 'smog/' + str(stat_number) + "-" + str(single_date.strftime("%Y-%m-%d")) + ".csv"


            def date_str(x):
                return datetime.datetime.fromtimestamp(int(x)).strftime('%H:%M')


            with codecs.open(file_name, "w", 'utf-8') as my_file:
                dane = {':'.join([str(x).zfill(2), '00']): {} for x in range(24)}
                print('CZAS', end="", file=my_file)
                comp = []
                for k in d['data']['series']:
                    compound_str = str(k['paramLabel'])
                    if compound_str == "Ozon":
                        compound_str = k['label'][:7]
                    if compound_str == "Tlenek węgla":
                        compound_str = k['label'][:15]

                    if k['data']:
                        comp.append(compound_str)

                    for t, v in k['data']:
                        ds = date_str(t)
                        if ds not in dane: continue
                        dane[ds][compound_str] = v

                print(';' + ';'.join(x for x in comp), file=my_file)

                for k in [':'.join([str(x).zfill(2), '00']) for x in range(24)]:
                    line = k
                    for c in comp:
                        line += ';'
                        line += "" if c not in dane[k] else str(dane[k][c])

                    print(line, file=my_file)
