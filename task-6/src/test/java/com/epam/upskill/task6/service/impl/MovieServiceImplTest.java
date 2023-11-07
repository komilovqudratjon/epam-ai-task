package com.epam.upskill.task6.service.impl;

import com.epam.upskill.task6.model.Movie;
import com.epam.upskill.task6.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @className: MovieServiceImplTest  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 6:17 PM 53 $
 * @author: Qudratjon Komilov
 */


class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveMovie() {
        Movie movie = new Movie("1", "Inception", new Date(), 148, null, null);
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        Movie savedMovie = movieService.saveMovie(movie);
        assertNotNull(savedMovie);
        assertEquals("Inception", savedMovie.getTitle());
    }

    @Test
    void getAllMovies() {
        when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie("1", "Inception", new Date(), 148, null, null),
                new Movie("2", "Interstellar", new Date(), 169, null, null)
        ));

        List<Movie> movies = movieService.getAllMovies();
        assertFalse(movies.isEmpty());
        assertEquals(2, movies.size());
    }

    @Test
    void getMovieById() {
        Movie movie = new Movie("1", "Inception", new Date(), 148, null, null);
        when(movieRepository.findById("1")).thenReturn(Optional.of(movie));

        Optional<Movie> foundMovie = movieService.getMovieById("1");
        assertTrue(foundMovie.isPresent());
        assertEquals("Inception", foundMovie.get().getTitle());
    }

    @Test
    void updateMovie() {
        Movie existingMovie = new Movie("1", "Inception", new Date(), 148, null, null);
        Movie newMovieDetails = new Movie("1", "Inception Updated", new Date(), 150, null, null);
        when(movieRepository.findById("1")).thenReturn(Optional.of(existingMovie));
        when(movieRepository.save(any(Movie.class))).thenReturn(newMovieDetails);

        Movie updatedMovie = movieService.updateMovie("1", newMovieDetails);
        assertNotNull(updatedMovie);
        assertEquals("Inception Updated", updatedMovie.getTitle());
        assertEquals(150, updatedMovie.getRuntime());
    }
    @Test
    void deleteMovie() {
        String movieId = "1";
        doNothing().when(movieRepository).deleteById(movieId);

        movieService.deleteMovie(movieId);

        verify(movieRepository, times(1)).deleteById(movieId);
    }

    @Test
    void findMoviesByTitle() {
        String title = "Inception";
        Movie movie = new Movie("1", title, new Date(), 148, null, null);
        List<Movie> expectedMovies = Collections.singletonList(movie);

        when(movieRepository.findByTitleContaining(title)).thenReturn(expectedMovies);

        List<Movie> foundMovies = movieService.findMoviesByTitle(title);

        assertNotNull(foundMovies);
        assertFalse(foundMovies.isEmpty());
        assertEquals(title, foundMovies.get(0).getTitle());
        verify(movieRepository, times(1)).findByTitleContaining(title);
    }

    @Test
    void findMoviesByReleaseDate() {
        Date startDate = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
        Date endDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31).getTime();
        List<Movie> expectedMovies = Arrays.asList(
                new Movie("1", "Inception", startDate, 148, null, null),
                new Movie("2", "Interstellar", startDate, 169, null, null)
        );

        when(movieRepository.findByReleaseDateBetween(startDate, endDate)).thenReturn(expectedMovies);

        List<Movie> foundMovies = movieService.findMoviesByReleaseDate(startDate, endDate);

        assertNotNull(foundMovies);
        assertEquals(2, foundMovies.size());
        assertTrue(foundMovies.stream().allMatch(movie -> movie.getReleaseDate().after(startDate) && movie.getReleaseDate().before(endDate)));
        verify(movieRepository, times(1)).findByReleaseDateBetween(startDate, endDate);
    }

}
