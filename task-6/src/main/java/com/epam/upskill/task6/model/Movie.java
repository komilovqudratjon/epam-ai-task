package com.epam.upskill.task6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @className: Movie  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 5:46 PM 40 $
 * @author: Qudratjon Komilov
 */
@Document(collection = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String id;
    private String title;
    private Date releaseDate;
    private int runtime;
    private List<Users> actors;
    private List<Users> directors;

}