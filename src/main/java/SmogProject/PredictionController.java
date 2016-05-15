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
    @RequestMapping("/prediction")
    public @ResponseBody
    List<SmogEntity> prediction(@RequestParam(value="date", defaultValue="2016-04-06") String my_date,
                                @RequestParam(value = "station", defaultValue = "6") String station) throws ParseException {

            String query = "select " + "P.godzina || ':00'" + ", " +
                    "P.pylZawieszonyPm10, " +
                    "P.tlenekWegla, " +
                    "P.dwutlenekAzotu, " +
                    "P.tlenekAzotu, " +
                    "P.tlenkiAzotu, " +
                    "P.pylZawieszonyPm25, " +
                    "P.tlenekWegla8H, " +
                    "P.benzen, " +
                    "P.dwutlenekSiarki, " +
                    "P.ozon, " +
                    "P.ozon8H " +
                    "from SmogEntity as P " +
                    String.format("where Data = '%s' and Stacja = %s ", my_date, station) +
                    "order by Data, Godzina";


            Session s = HibernateSession.getSessionFactory().openSession();
            Query q = s.createQuery(query);
            q.setResultTransformer(Transformers.aliasToBean(SmogQueryResult.class));
            List result = q.list();
            s.close();

            return result;
    }
}