package com.epam.upskill.task6.service;

import com.epam.upskill.task6.model.Movie;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @className: MovieService  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 6:03 PM 22 $
 * @author: Qudratjon Komilov
 */


public interface MovieService {
    Movie saveMovie(Movie movie);

    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(String id);

    Movie updateMovie(String id, Movie movie);

    void deleteMovie(String id);

    List<Movie> findMoviesByTitle(String title);

    List<Movie> findMoviesByReleaseDate(Date releaseDate, Date releaseDate2);
}
