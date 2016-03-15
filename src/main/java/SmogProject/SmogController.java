package SmogProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lukas on 15.03.2016.
 */
@RestController
public class SmogController {

    @RequestMapping("/smog")
    public @ResponseBody
    HashMap<String, List<String>> smog(@RequestParam(value = "date", defaultValue = "02-03-2014") String date,
                       @RequestParam(value = "station", defaultValue = "6") String station) throws ParseException {

        List<String> lines;
        HashMap<String, List<String>> data = new HashMap<>();
        try {
            lines = Files.readAllLines(Paths.get(String.format("data/smog/%s/csv/%s.csv", station, date)));
            List<String[]> separated = lines.stream().map(l -> l.split(";")).collect(Collectors.toList());

            String[] firstLine = separated.get(0);

            for (int i=0; i<firstLine.length; i++) {
                final int finalI = i;
                List<String> values = separated.stream().map(l -> l[finalI]).collect(Collectors.toList());
                data.put(firstLine[i], values.subList(1, values.size()));
            }
            return data;

        } catch (IOException e) {
            System.err.println("Probably no file was found.");
            e.printStackTrace();
        }
        return null;

    }
}