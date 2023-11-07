package com.epam.upskil.task5.cron;

import com.epam.upskil.task5.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @className: WeatherScheduler  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 3:23 AM 50 $
 * @author: Qudratjon Komilov
 */
@EnableScheduling
@Service
@AllArgsConstructor
public class WeatherScheduler {

    private final WeatherService weatherService;

    @Scheduled(fixedRate = 100000)
    public void refreshWeatherData() {
        // You might want to refresh weather data for all cities/zip codes stored in the database
        // Iterate over them and call the third-party API for updates
    }
}
