package com.epam.upskill.task4.service.impl;
import com.epam.upskill.task4.model.Book;
import com.epam.upskill.task4.repository.BookRepository;
import com.epam.upskill.task4.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 * @className: BookServiceImpl  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:56 AM 09 $
 * @author: Qudratjon Komilov
 */
@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = findBookById(id);
        // Update properties of existingBook
        return bookRepository.save(existingBook);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    @Override
    public List<Book> findBooksByAuthor(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }

    @Override
    public List<Book> findBooksByGenre(String genreName) {
        return bookRepository.findByGenreName(genreName);
    }
}
