import codecs
import sqlite3
import os


def value_or_null(x):
    return str(x) if x != '' else 'null'


def weather_migrate():
    temp_dir = '../'
    conn = sqlite3.connect(temp_dir + 'database/db')
    c = conn.cursor()

    for filename in os.listdir(temp_dir + 'weather/'):
        file, ext = os.path.splitext(filename)
        with codecs.open(temp_dir + 'weather/' + filename, 'r', 'utf-8') as csv:
            skip_first = True
            for line in csv:
                if skip_first:
                    skip_first = False
                    continue
                godz, temp, kier, pred, zach, wilg = map(lambda x: x.strip(), line.split(';'))
                # data, godz, temp, kier, pred, zach, wilg
                c.execute("insert or ignore into Pogoda values ('%s', %s, %s, '%s', %s, %s, %s)" % (
                    file, godz[:-3], value_or_null(temp), value_or_null(kier), value_or_null(pred),
                    value_or_null(zach), value_or_null(wilg)))
        conn.commit()


def smog_migrate():
    temp_dir = ''
    conn = sqlite3.connect('db')
    c = conn.cursor()

    tr = {
        'CZAS': 0,
        'Pył zawieszony PM10': 1,
        'Tlenek węgla': 2,
        'Dwutlenek azotu': 3,
        'Tlenek azotu': 4,
        'Tlenki azotu': 5,
        'Pył zawieszony PM2.5': 6,
        'Tlenek węgla 8h': 7,
        'Benzen': 8,
        'Dwutlenek siarki': 9,
        'Ozon': 10,
        'Ozon 8h': 11
    }

    def make_dict(d, s, x):
        l = []
        for b in x:
            l.append(tr[b])

        def result(y):
            p = y.split(';')
            p[0] = str(int(p[0][:-3]))
            t = ['null' for _ in range(12)]
            for i, a in enumerate(p):
                t[l[i]] = value_or_null(a)
            return [d] + [t[0]] + [s] + t[1:]

        return result

    for dirname in os.listdir(temp_dir + 'smog/'):
        path = temp_dir + 'smog/' + dirname + '/csv/'
        for filename in os.listdir(path):
            file, ext = os.path.splitext(filename)
            with codecs.open(path + filename, 'r', 'utf-8') as csv:
                lines = list(map(lambda x: x.strip(), csv.readlines()))
                if lines[0].endswith(';'):
                    lines[0] = lines[0][:-1]

                com = lines[0].split(';')
                if len(com) == 1:
                    continue

                parse = make_dict(file, dirname, com)

                for i in lines[1:]:
                    c.execute(
                        "insert or ignore into Smog values ('{}', {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {})".format(
                            *parse(i)))
                conn.commit()


if __name__ == "__main__":
    smog_migrate()
