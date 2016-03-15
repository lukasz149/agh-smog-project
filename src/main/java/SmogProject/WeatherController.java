package SmogProject;

/**
 * Created by lukas on 12.03.2016.
 */

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class WeatherController {
    @RequestMapping("/weather")
    public @ResponseBody List<PogodaEntity> weather(@RequestParam(value="date", defaultValue="01-01-2014") String date) throws ParseException {

        Session s = HibernateSession.getSessionFactory().openSession();
        Query q = s.createQuery("from PogodaEntity where Data = \'" + date + "\'");
        List<PogodaEntity> result = q.list();
        s.close();

        return result;
    }
}
