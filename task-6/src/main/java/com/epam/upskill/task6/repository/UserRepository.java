package com.epam.upskill.task6.repository;

import com.epam.upskill.task6.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @className: ActorRepository  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 5:50 PM 05 $
 * @author: Qudratjon Komilov
 */
public interface UserRepository extends MongoRepository<Users, String> {
    List<Users> findByType(String type);
}