package com.epam.upskill.task4.service;

import com.epam.upskill.task4.model.Genre;

import java.util.List;

/**
 * @className: GenreService  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:55 AM 45 $
 * @author: Qudratjon Komilov
 */
public interface GenreService {
    Genre saveGenre(Genre genre);
    void deleteGenre(Long id);
    Genre updateGenre(Long id, Genre genre);
    Genre findGenreById(Long id);
    List<Genre> findAllGenres();
}