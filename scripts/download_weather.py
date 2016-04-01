from urllib.request import urlopen
from htmldom import htmldom
import datetime
import codecs
import os
import sqlite3



# in date: formatted string %d-%m-%Y
def get_weather(d):
    url = "http://pogoda.interia.pl/archiwum-pogody-" + d + ",cId,4970"
    response = urlopen(url)
    if response.getheader('Content-Type') == 'text/html':
        htmlbytes = response.read()
        htmlstring = htmlbytes.decode('utf-8')
        return htmlstring
    else:
        raise 'Date: ' + d + ' -- FAILED'


def parse_line(node):
    inner = htmldom.HtmlDom().createDom(node.html())
    hour = inner.find("span.hour").text().strip()
    # minutes = inner.find("span.minutes").text().strip()
    temp = inner.find("span.forecast-temp").text().strip()[:-2]
    wind_dir = inner.find("span.wind-direction").text().strip()
    wind_speed = inner.find("span.speed-value").text().strip()
    prec_value = inner.find("span.entry-precipitation-value").text().replace("%", "").strip()
    humidity = inner.find("div.entry-humidity").text().strip()[:-1]

    return hour, temp, wind_dir, wind_speed, prec_value, humidity


def daterange(start_date, end_date):
    for n in range(int((end_date - start_date).days)):
        yield start_date + datetime.timedelta(n)



def value_or_null(x):
    return str(x) if x != '' else 'null'


def check_if_exist(conn, c, date):
    c.execute("select * from Pogoda where Data = \'%s\'" % date)
    if len(c.fetchall()):
        return True
    return False


def main():
    db_path = '../data/'

    conn = sqlite3.connect(db_path + 'database/db')
    c = conn.cursor()

    start_date = datetime.date(2013, 5, 1)
    end_date = datetime.datetime.date(datetime.datetime.now())
    for single_date in daterange(start_date, end_date):
        d = single_date.strftime("%d-%m-%Y")
        # -- zakladamy ze jesli nie pobrano danych z danego dnia to nie bedzie go w ogole w bazie
        try:
            if not check_if_exist(conn, c, d):
                print("Downloading " + d + "... ", end="")
                dom = htmldom.HtmlDom().createDom(get_weather(d))
                for node in dom.find('li.weather-entry'):
                    godz, temp, kier, pred, zach, wilg = parse_line(node)
                    # data, godz, temp, kier, pred, zach, wilg
                    c.execute("insert or ignore into Pogoda values ('%s', %s, %s, '%s', %s, %s, %s)" % (
                        d, godz, value_or_null(temp), value_or_null(kier), value_or_null(pred),
                        value_or_null(zach), value_or_null(wilg)))
                print("done.")
                conn.commit()
        except:
            print("Could not download and parse -> " + d)
    print("Updated.")


if __name__ == "__main__":
    main()
