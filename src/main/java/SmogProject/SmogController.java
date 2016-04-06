package SmogProject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by lukas on 15.03.2016.
 */
@RestController
public class SmogController {

    private static final long MAX_POINTS = 30;

    @RequestMapping("/smog")
    public @ResponseBody
    List<SmogEntity> smog(@RequestParam(value="from", defaultValue="2015-01-01") String from,
                          @RequestParam(value="to", defaultValue="2015-01-01") String to,
                          @RequestParam(value="view", defaultValue="normal") String view,
                          @RequestParam(value = "station", defaultValue = "6") String station) throws ParseException {

        if (Objects.equals(view, "normal")) {
            Date fromdate = new SimpleDateFormat("yyyy-MM-dd").parse(from);
            Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(to);

            long diff = todate.getTime() - fromdate.getTime() + TimeUnit.DAYS.toMillis(1);
            long secs = TimeUnit.MILLISECONDS.toSeconds(diff) / MAX_POINTS;
            long divhours = TimeUnit.MILLISECONDS.toHours(diff) / MAX_POINTS + 1;

            String label;
            if (divhours < 24) { // hours
                label = "P.godzina || ':00'";
            } else { // days, month
                label = "P.data";
            }

            String query = "select " + label + ", " +
                    "avg(P.pylZawieszonyPm10), " +
                    "avg(P.tlenekWegla), " +
                    "avg(P.dwutlenekAzotu), " +
                    "avg(P.tlenekAzotu), " +
                    "avg(P.tlenkiAzotu), " +
                    "avg(P.pylZawieszonyPm25), " +
                    "avg(P.tlenekWegla8H), " +
                    "avg(P.benzen), " +
                    "avg(P.dwutlenekSiarki), " +
                    "avg(P.ozon), " +
                    "avg(P.ozon8H) " +
                    "from SmogEntity as P " +
                    String.format("where Data between '%s' and '%s' and Stacja =  ", from, to, station) +
                    String.format("group by (strftime('%%s', Data) + 3600 * Godzina) / %d", secs) +
                    "order by Data, Godzina";

            Session s = HibernateSession.getSessionFactory().openSession();
            Query q = s.createQuery(query);
            q.setMaxResults(24);
            q.setResultTransformer(Transformers.aliasToBean(SmogQueryResult.class));
            List result = q.list();
            s.close();

            return result;
        } else {

        }

//        try {
//            lines = Files.readAllLines(Paths.get(String.format("data/smog/%s/csv/%s.csv", station, date)));
//            List<String[]> separated = lines.stream().map(l -> (l + ";X").split(";")).collect(Collectors.toList());
//
//            String[] firstLine = separated.get(0);
//
//            HashMap<String, List<String>> data = new HashMap<>();
//
//            for (int i=0; i<firstLine.length - 1; i++) {
//                final int finalI = i;
//                List<String> values = separated.stream().map(l -> l[finalI]).collect(Collectors.toList());
//                data.put(firstLine[i], values.subList(1, values.size()));
//            }
//            return data;
//
//        } catch (IOException e) {
//            System.err.println("Probably no file was found.");
//            //e.printStackTrace();
//        }
//        return null;

        return null;
    }
}