package SmogProject;

/**
 * Created by lukas on 12.03.2016.
 */

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
public class WeatherController {

    private static final long MAX_POINTS = 24;

    @RequestMapping("/weather")
    public @ResponseBody List weather(@RequestParam(value="from", defaultValue="2016-04-05") String from,
                                      @RequestParam(value="to", defaultValue="2016-04-05") String to,
                                      @RequestParam(value="view", defaultValue="normal") String view) throws ParseException {

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
                           "avg(P.tempPowietrzaavg), " +
                           "avg(P.avgPredkoscWiatruavg), " +
                           "avg(P.opadavg), " +
                           "avg(P.wilgotnoscavg), " +
                           "avg(P.cisnienieavg) " +
                           "from PogodaEntity as P " +
                           String.format("where Data between '%s' and '%s' ", from, to) +
                           String.format("group by (strftime('%%s', Data) + 3600 * Godzina) / %d", secs) +
                           "order by Data, Godzina";

            Session s = HibernateSession.getSessionFactory().openSession();
            Query q = s.createQuery(query);
            q.setMaxResults(24);
            q.setResultTransformer(Transformers.aliasToBean(PogodaQueryResult.class));
            List result = q.list();
            s.close();

            return result;
        } else if (Objects.equals(view, "daynight")) {

        }


        return null;
    }
}
