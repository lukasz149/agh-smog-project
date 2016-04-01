package SmogProject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * Created by lukas on 15.03.2016.
 */
@RestController
public class SmogController {

    @RequestMapping("/smog")
    public @ResponseBody
    List<SmogEntity> smog(@RequestParam(value = "date", defaultValue = "2014-01-01") String date,
                       @RequestParam(value = "station", defaultValue = "6") String station) throws ParseException {

        Session s = HibernateSession.getSessionFactory().openSession();
        Query q = s.createQuery("from SmogEntity where Data = \'" + date + "\' and Stacja = " + station);
        List<SmogEntity> result = q.list();
        s.close();
        return result;

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

    }
}