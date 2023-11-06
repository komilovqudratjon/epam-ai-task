package com.epam.upskil.repository;

import com.epam.upskil.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: PostRepository  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 10:56 PM 36 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Here you can define methods to retrieve posts by certain criteria if needed.
}
