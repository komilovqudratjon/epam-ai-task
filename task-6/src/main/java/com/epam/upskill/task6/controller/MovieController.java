package com.epam.upskill.task6.controller;

import com.epam.upskill.task6.model.Movie;
import com.epam.upskill.task6.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @className: MovieController  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 6:16 PM 25 $
 * @author: Qudratjon Komilov
 */


@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.saveMovie(movie);
        return ResponseEntity.ok(savedMovie);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String id, @RequestBody Movie movie) {
        try {
            Movie updatedMovie = movieService.updateMovie(id, movie);
            return ResponseEntity.ok(updatedMovie);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
        try {
            movieService.deleteMovie(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Movie>> findMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.findMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/releaseDate/{releaseDate}/{releaseDate2}")
    public ResponseEntity<List<Movie>> findMoviesByReleaseDate(@PathVariable Date releaseDate, @PathVariable Date releaseDate2) {
        List<Movie> movies = movieService.findMoviesByReleaseDate(releaseDate, releaseDate2);
        return ResponseEntity.ok(movies);
    }
}

