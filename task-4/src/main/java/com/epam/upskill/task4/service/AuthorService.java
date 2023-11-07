package com.epam.upskill.task4.service;

import com.epam.upskill.task4.model.Author;

import java.util.List;

/**
 * @className: AuthorService  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:55 AM 24 $
 * @author: Qudratjon Komilov
 */
public interface AuthorService {
    Author saveAuthor(Author author);
    void deleteAuthor(Long id);
    Author updateAuthor(Long id, Author author);
    Author findAuthorById(Long id);
    List<Author> findAllAuthors();
}
