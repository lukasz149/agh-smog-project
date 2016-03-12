package SmogProject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lukas on 12.03.2016.
 */
public class Weather {
    private final String time;
    private final String temperature;
    private final String cloudy;
    private final String humidity;

    Weather(String time, String temperature, String cloudy, String humidity) {
        this.time = time;
        this.temperature = temperature;
        this.cloudy = cloudy;
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public String getCloudy() {
        return cloudy;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemperature() {
        return temperature;
    }
}
