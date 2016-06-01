package SmogProject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class PredictionController {
    @RequestMapping("/prediction")
    public @ResponseBody
    List<SmogEntity> prediction(@RequestParam(value="date", defaultValue="2016-04-05") String my_date,
                                @RequestParam(value = "station", defaultValue = "7") String station,
                                @RequestParam(value = "model", defaultValue = "1") String model) throws ParseException {

            String query = "select " + "P.godzina || ':00'" + ", " +
                    "floor(P.pylZawieszonyPm10*100+0.5)/100.0, " +
                    "floor(P.tlenekWegla*100+0.5)/100.0, " +
                    "floor(P.dwutlenekAzotu*100+0.5)/100.0, " +
                    "floor(P.tlenekAzotu*100+0.5)/100.0, " +
                    "floor(P.tlenkiAzotu*100+0.5)/100.0, " +
                    "floor(P.pylZawieszonyPm25*100+0.5)/100.0, " +
                    "floor(P.tlenekWegla8H*100+0.5)/100.0, " +
                    "floor(P.benzen*100+0.5)/100.0, " +
                    "floor(P.dwutlenekSiarki*100+0.5)/100.0, " +
                    "floor(P.ozon*100+0.5)/100.0, " +
                    "floor(P.ozon8H*100+0.5)/100.0 " +
                    "from PrognozyEntity as P " +
                    String.format("where Data = '%s' and Stacja = %s and Model = %s ", my_date, station, model) +
                    "order by Data, Godzina";


            Session s = HibernateSession.getSessionFactory().openSession();
            Query q = s.createQuery(query);
            q.setResultTransformer(Transformers.aliasToBean(SmogQueryResult.class));
            List result = q.list();
            s.close();

            return result;
    }
}