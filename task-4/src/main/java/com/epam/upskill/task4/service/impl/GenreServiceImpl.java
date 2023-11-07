package com.epam.upskill.task4.service.impl;
import com.epam.upskill.task4.model.Author;
import com.epam.upskill.task4.model.Genre;
import com.epam.upskill.task4.repository.AuthorRepository;
import com.epam.upskill.task4.repository.GenreRepository;
import com.epam.upskill.task4.service.AuthorService;
import com.epam.upskill.task4.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
/**
 * @className: GenreServiceImpl  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:58 AM 55 $
 * @author: Qudratjon Komilov
 */
@Service
@Transactional
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;



    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Long id) {
        // Additional logic can be added to check for books related to the genre
        genreRepository.deleteById(id);
    }

    @Override
    public Genre updateGenre(Long id, Genre genre) {
        Genre existingGenre = findGenreById(id);
        if (existingGenre != null) {
            existingGenre.setName(genre.getName());
            // Copy over other properties you wish to update
        }
        return genreRepository.save(existingGenre);
    }

    @Override
    public Genre findGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }
}

