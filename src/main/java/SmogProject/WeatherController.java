package SmogProject;

/**
 * Created by lukas on 12.03.2016.
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherController {
    @RequestMapping("/weather")
    public @ResponseBody List<Weather> weather(@RequestParam(value="date", defaultValue="01-01-2014") String date) throws ParseException {
        String time;
        String temperature;
        String cloudy;
        String humidity;
        List<Weather> weathers = new ArrayList<>();
        List<String> lines = null;

        try {
            lines = Files.readAllLines(Paths.get(String.format("data/weather/%s.csv", date)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String[]> separated = lines.stream().map(l -> l.split(";")).collect(Collectors.toList());

        for (String[] line : separated.subList(1, separated.size())) {
            time = !line[0].equals("") ? line[0] : "";
            temperature = !line[1].equals("") ? line[1] : "";
            cloudy = !line[3].equals("") ? line[3] : "";
            humidity = !line[4].equals("") ? line[4] : "";
            weathers.add(new Weather(time, temperature, cloudy, humidity));
        }
        return weathers;
    }
}
