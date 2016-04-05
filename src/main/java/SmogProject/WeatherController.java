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

    private static final long MAX_POINTS = 30;

    @RequestMapping("/weather")
    public @ResponseBody List weather(@RequestParam(value="from", defaultValue="2015-01-01") String from,
                                      @RequestParam(value="to", defaultValue="2015-01-01") String to,
                                      @RequestParam(value="view", defaultValue="normal") String view) throws ParseException {

        if (Objects.equals(view, "normal")) {
            Date fromdate = new SimpleDateFormat("yyyy-MM-dd").parse(from);
            Date todate = new SimpleDateFormat("yyyy-MM-dd").parse(to);

            long diff = todate.getTime() - fromdate.getTime();
            long divhours = TimeUnit.MILLISECONDS.toHours(diff) / MAX_POINTS + 1;
            long divdays = TimeUnit.MILLISECONDS.toDays(diff) / MAX_POINTS + 1;

            String query = "select %s, " +
                           "avg(P.tempPowietrzaavg), " +
                           "avg(P.avgPredkoscWiatruavg), " +
                           "avg(P.opadavg), " +
                           "avg(P.wilgotnoscavg), " +
                           "avg(P.cisnienieavg) " +
                           "from PogodaEntity as P " +
                           String.format("where Data between '%s' and '%s' ", from, to) +
                           "%s " +
                           "order by Data, Godzina";

            if (divhours < 24) { // hours
                query = String.format(query, "P.godzina || ':00'",
                                             String.format("group by Data, Godzina / %d", divhours));
            } else if (divdays < 30) { // days
                query = String.format(query, "P.data",
                                    String.format("group by strftime('%%Y-%%m', Data), strftime('%%d', Data) / %d", divdays));
            } else { // month
                query = String.format(query, "P.data",
                                    String.format("group by strftime('%%Y', Data), strftime('%%d', Data) / %d", 1));
            }


            Session s = HibernateSession.getSessionFactory().openSession();
            Query q = s.createQuery(query);
            q.setResultTransformer(Transformers.aliasToBean(PogodaQueryResult.class));
            List result = q.list();
            System.out.println("List length: " + result.size());
            s.close();

            return result;
        } else if (Objects.equals(view, "daynight")) {

        }


        return null;
    }
}
