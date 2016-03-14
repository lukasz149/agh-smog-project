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
    private final String windSpeed;
    private final String windDirection;


    Weather(String time, String temperature, String cloudy, String humidity, String windSpeed, String windDirection) {
        this.time = time;
        this.temperature = temperature;
        this.cloudy = cloudy;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
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

    public String getWindSpeed() { return  windSpeed; }

    public String getWindDirection() { return windDirection; }
}
