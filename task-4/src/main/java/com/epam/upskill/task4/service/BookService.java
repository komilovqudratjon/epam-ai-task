package com.epam.upskill.task4.service;

import com.epam.upskill.task4.model.Book;

import java.util.List;

/**
 * @className: BookService  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:53 AM 33 $
 * @author: Qudratjon Komilov
 */
public interface BookService {
    Book saveBook(Book book);
    void deleteBook(Long id);
    Book updateBook(Long id, Book book);
    Book findBookById(Long id);
    List<Book> findAllBooks();
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(String authorName);
    List<Book> findBooksByGenre(String genreName);
}