package com.epam.upskil.repository;

import com.epam.upskil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @className: UserRepository  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 10:56 PM 11 $
 * @author: Qudratjon Komilov
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You might add custom methods if needed, e.g., findByUsername, etc.
}
