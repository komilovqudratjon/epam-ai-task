package com.epam.upskill.task4.repository;

import com.epam.upskill.task4.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: GenreRepository  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 2:52 AM 50 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
