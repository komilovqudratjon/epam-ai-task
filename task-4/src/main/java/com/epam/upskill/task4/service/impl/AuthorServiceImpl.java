package com.epam.upskill.task4.service.impl;

import com.epam.upskill.task4.model.Author;
import com.epam.upskill.task4.repository.AuthorRepository;
import com.epam.upskill.task4.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @className: AuthorServiceImpl  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:57 AM 32 $
 * @author: Qudratjon Komilov
 */
@Service
@Transactional
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        // Additional logic can be added to check for books related to the author
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = findAuthorById(id);
        if (existingAuthor != null) {
            existingAuthor.setName(author.getName());
            // Copy over other properties you wish to update
        }
        return authorRepository.save(existingAuthor);
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
}

