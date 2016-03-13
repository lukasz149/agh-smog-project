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
    public @ResponseBody List<Weather> weather(@RequestParam(value="date", defaultValue="02-03-2014") String date) throws ParseException {
        String time;
        String temperature;
        String cloudy;
        String humidity;
        List<Weather> weathers = new ArrayList<>();
        List<String> lines = null;

        try {
            lines = Files.readAllLines(Paths.get(String.format("data/weather/%s.csv", date)));
            List<String[]> separated = lines.stream().map(l -> l.split(";")).collect(Collectors.toList());

            for (String[] line : separated.subList(1, separated.size())) {
                time = line[0];
                temperature = line[1];
                // Kierunek wiatru -> 2, Predkosc wiatru -> 3
                // wind_dir = line[2];
                // wind_speed = line[3];
                cloudy = line[4];
                humidity = line[5];
                weathers.add(new Weather(time, temperature, cloudy, humidity));
            }
            return weathers;
        } catch (IOException e) {
            System.err.println("Probably no file was found.");
            e.printStackTrace();
        }
        return null;
    }
}
