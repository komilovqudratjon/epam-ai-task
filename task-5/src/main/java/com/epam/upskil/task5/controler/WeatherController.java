package com.epam.upskil.task5.controler;

import com.epam.upskil.task5.model.WeatherData;
import com.epam.upskil.task5.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: WeatherController  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 3:20 AM 12 $
 * @author: Qudratjon Komilov
 */
@RestController
@RequestMapping("/api/weather")
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/city/{city}")
    public ResponseEntity<WeatherData> getWeatherByCity(@PathVariable String city) {
        WeatherData weatherData = weatherService.getWeatherByCity(city);
        return new ResponseEntity<>(weatherData, HttpStatus.OK);
    }

}

