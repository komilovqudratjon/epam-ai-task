package com.epam.upskill.task6.repository;

import com.epam.upskill.task6.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * @className: MovieRepository  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 5:49 PM 32 $
 * @author: Qudratjon Komilov
 */
public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByReleaseDateBetween(Date releaseDate, Date releaseDate2);
}