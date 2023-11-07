package com.epam.upskill.task4.repository;

import com.epam.upskill.task4.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className: BookRepository  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:51 AM 52 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);

    List<Book> findByAuthorName(String authorName);

    List<Book> findByGenreName(String genreName);
}
