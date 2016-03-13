from urllib.request import urlopen
from htmldom import htmldom
import datetime
import codecs
import os


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
    minutes = inner.find("span.minutes").text().strip()
    temp = inner.find("span.forecast-temp").text().strip()[:-2]
    wind_dir = inner.find("span.wind-direction").text().strip()
    wind_speed = inner.find("span.speed-value").text().strip()
    prec_value = inner.find("span.entry-precipitation-value").text().replace("%", "").strip()
    humidity = inner.find("div.entry-humidity").text().strip()[:-1]

    return "%s:%s;%s;%s;%s;%s;%s" % (hour, minutes, temp, wind_dir, wind_speed, prec_value, humidity)


def daterange(start_date, end_date):
    for n in range(int((end_date - start_date).days)):
        yield start_date + datetime.timedelta(n)


def main():
    weather_path = '../data/weather/'
    start_date = datetime.date(2013, 5, 1)
    end_date = datetime.datetime.date(datetime.datetime.now())
    for single_date in daterange(start_date, end_date):
        d = single_date.strftime("%d-%m-%Y")
        try:
            if not os.path.isfile(weather_path + d + '.csv') or \
                            datetime.datetime.fromtimestamp(os.path.getctime(weather_path + d + '.csv')).strftime(
                                "%d-%m-%Y") == d:
                print("Downloading " + d + "... ", end="")
                with codecs.open(weather_path + d + '.csv', 'w', 'utf-8') as csv:
                    dom = htmldom.HtmlDom().createDom(get_weather(d))
                    csv.write("Godzina[hh:mm];Temperatura[C];Wiatr[Kier];Wiatr[km/h];Zachmurzenie[%];Wilgotność[%]\n")
                    for node in dom.find('li.weather-entry'):
                        csv.write(parse_line(node) + '\n')
                print("done.")
        except:
            print("Could not download and parse -> " + d)
    print("Updated.")


if __name__ == "__main__":
    main()
