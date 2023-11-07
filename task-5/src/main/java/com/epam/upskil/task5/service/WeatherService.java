package com.epam.upskil.task5.service;

import com.epam.upskil.task5.model.WeatherData;
import com.epam.upskil.task5.repository.WeatherDataRepository;
import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.forecast.Forecast;
import com.github.prominence.openweathermap.api.model.forecast.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;


/**
 * @className: WeatherService  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 3:21 AM 12 $
 * @author: Qudratjon Komilov
 */
@Service
public class WeatherService {
    private final WeatherDataRepository weatherDataRepository;

    @Value("${openweathermap.apikey}")
    private String apiKey;

    @Autowired
    public WeatherService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    public WeatherData getWeatherByCity(String city) {
        Optional<WeatherData> byCity = weatherDataRepository.findByCity(city);
        if (byCity.isPresent()) {
            return byCity.get();
        } else {
            WeatherData currentWeather = getCurrentWeather(city, Language.ENGLISH);
            weatherDataRepository.save(currentWeather);
            return currentWeather;
        }
    }

    public void updateWeatherData() {
        weatherDataRepository.findAll().forEach(weatherData -> {
            WeatherData currentWeather = getCurrentWeather(weatherData.getCity(), Language.ENGLISH);
            currentWeather.setId(weatherData.getId());
            weatherDataRepository.save(currentWeather);
        });
    }

    public WeatherData getCurrentWeather(String city, Language language) {
        Forecast java = new OpenWeatherMapClient(apiKey).forecast5Day3HourStep()
                .byCityName(city)
                .language(language)
                .unitSystem(UnitSystem.IMPERIAL)
                .count(1)
                .retrieve()
                .asJava();
        return parseWeatherData(java);
    }

    private WeatherData parseWeatherData(Forecast forecast) {
        WeatherData weatherData = new WeatherData();
        WeatherForecast weatherForecast = forecast.getWeatherForecasts().get(0);
        weatherData.setCity(weatherData.getCity());
        weatherData.setZipCode(weatherData.getZipCode());
        weatherData.setTemperature(String.valueOf(weatherForecast.getTemperature()));
        weatherData.setDescription(weatherForecast.getWeatherState().getDescription());
        weatherData.setClouds(weatherForecast.getClouds().toString());
        weatherData.setWind(weatherFormat(weatherForecast.getWind().getSpeed() / 2.2237) + "m/s." + degreeToCompass(weatherForecast.getWind().getDegrees()));
        return weatherData;
    }

    private String weatherFormat(Double value) {
        DecimalFormat format = new DecimalFormat("#0.00");
        return format.format(value);
    }

    public String degreeToCompass(Double degree) {
        double v = (degree / 22.5) + 0.5;
        String[] arr = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
        return arr[(int) v % 16];
    }


}

