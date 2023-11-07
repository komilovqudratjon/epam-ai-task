package com.epam.upskill.task4.repository;

import com.epam.upskill.task4.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: AuthorRepository  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:52 AM 23 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
