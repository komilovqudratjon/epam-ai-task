package com.epam.upskil.task5.service;

import com.epam.upskil.task5.model.WeatherData;
import com.epam.upskil.task5.repository.WeatherDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @className: WeatherService  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 3:21 AM 12 $
 * @author: Qudratjon Komilov
 */
@Service
@AllArgsConstructor
public class WeatherService {
    private final WeatherDataRepository weatherDataRepository;

    public WeatherData getWeatherByCity(String city) {
        return null;
    }

    public WeatherData getWeatherByZipCode(String zipCode) {
        return null;
    }
}

