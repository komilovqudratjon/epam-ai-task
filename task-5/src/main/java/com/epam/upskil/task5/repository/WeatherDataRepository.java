package com.epam.upskil.task5.repository;

import com.epam.upskil.task5.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @className: WeatherDataRepository  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 3:18 AM 46 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    Optional<WeatherData> findByCity(String city);
    Optional<WeatherData> findByZipCode(String zipCode);
}

