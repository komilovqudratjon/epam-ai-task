package com.epam.upskill.task6.service.impl;
import com.epam.upskill.task6.model.Movie;
import com.epam.upskill.task6.repository.MovieRepository;
import com.epam.upskill.task6.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
/**
 * @className: MovieServiceImpl  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 6:04 PM 01 $
 * @author: Qudratjon Komilov
 */


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie updateMovie(String id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setTitle(movieDetails.getTitle());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setRuntime(movieDetails.getRuntime());
        movie.setActors(movieDetails.getActors());
        movie.setDirectors(movieDetails.getDirectors());
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findMoviesByTitle(String title) {
        return movieRepository.findByTitleContaining(title);
    }

    @Override
    public List<Movie> findMoviesByReleaseDate(Date releaseDate, Date releaseDate2) {
        return movieRepository.findByReleaseDateBetween(releaseDate, releaseDate2);
    }
}

