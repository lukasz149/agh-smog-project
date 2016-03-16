import codecs
import sqlite3
import os


def value_or_null(x):
    return str(x) if x != '' else 'null'


temp_dir = '../'


def main():
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


if __name__ == "__main__":
    main()
