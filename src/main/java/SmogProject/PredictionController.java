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

@RestController
public class PredictionController {

    private static final long MAX_POINTS = 30;

    @RequestMapping("/prediction")
    public @ResponseBody
    List<SmogEntity> smog(@RequestParam(value="from", defaultValue="2016-04-06") String from,
                          @RequestParam(value="to", defaultValue="2016-04-06") String to,
                          @RequestParam(value="view", defaultValue="normal") String view,
                          @RequestParam(value = "station", defaultValue = "7") String station) throws ParseException {

        if (Objects.equals(view, "normal")) {
            Date fromdate = new SimpleDateFormat("yyyy-MM-dd").parse(from);
            Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(to);
            long diff = todate.getTime() - fromdate.getTime() + TimeUnit.DAYS.toMillis(1);
            long secs = TimeUnit.MILLISECONDS.toSeconds(diff) / MAX_POINTS;

            String query = "select " + "P.godzina || ':00'" + ", " +
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
                    String.format("where Data between '%s' and '%s' and Stacja = %s ", from, to, station)+
                    String.format("group by 3600 * Godzina) / %d", secs);


            Session s = HibernateSession.getSessionFactory().openSession();
            Query q = s.createQuery(query);
            q.setResultTransformer(Transformers.aliasToBean(SmogQueryResult.class));
            List result = q.list();
            s.close();

            return result;
        } else {
            //...
        }

        return null;
    }
}