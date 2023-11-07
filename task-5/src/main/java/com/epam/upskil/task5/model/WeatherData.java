package com.epam.upskil.task5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @className: WeatherData  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 3:16 AM 05 $
 * @author: Qudratjon Komilov
 */
@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String zipCode;
    private String temperature;
    private String description;
    private String clouds;
    private String wind;

}