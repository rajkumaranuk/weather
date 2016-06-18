package com.mycompany.weather;

import com.mycompany.weather.entity.WeatherData;
import com.mycompany.weather.entity.WeatherDataSummary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Service
public class WeatherService {

    private static final Map<String, String> timezones = new HashMap<String, String>();

    static {
        timezones.put("London", "Europe/London");
        timezones.put("Hong Kong", "Asia/Hong_Kong");
    }

    private final String appKey= "c3177e2013296c47df2dde5985b8739c";
    private final String url = "http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s";
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final DateFormat dateFormat12 = new SimpleDateFormat("h:mm a");
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDataSummary getWeatherData(String city) {
        try {
            WeatherData weatherData = restTemplate.getForObject(String.format(url, city, appKey), WeatherData.class);
            double tempC = weatherData.getMain().getTemp() - 273.16;
            double tempF = tempC * 9/5 + 32;
            dateFormat12.setTimeZone(TimeZone.getTimeZone(timezones.get(city)));

            WeatherDataSummary weatherDataSummary = new WeatherDataSummary();
            weatherDataSummary.setDate(dateFormat.format(new Date()));
            weatherDataSummary.setCity(city);
            weatherDataSummary.setDescription(weatherData.getWeather().get(0).getDescription());
            weatherDataSummary.setTempC(String.format("%.2f", tempC));
            weatherDataSummary.setTempF(String.format("%.2f", tempF));
            weatherDataSummary.setSunrise(dateFormat12.format(Date.from( Instant.ofEpochSecond(weatherData.getSys().getSunrise()))));
            weatherDataSummary.setSunset(dateFormat12.format(Date.from( Instant.ofEpochSecond(weatherData.getSys().getSunset()))));
            return weatherDataSummary;
        } catch (Exception e) {
            return null;
        }
    }

    public List getCities() {
        List<String> cities = new ArrayList<String>();
        cities.add("London");
        cities.add("Hong Kong");
        return cities;
    }
}
