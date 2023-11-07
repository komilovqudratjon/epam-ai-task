package com.epam.upskill.task6.service;

import com.epam.upskill.task6.model.Users;

import java.util.List;
import java.util.Optional;

/**
 * @className: UserService  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 6:10 PM 09 $
 * @author: Qudratjon Komilov
 */
public interface UserService {

    Users saveUser(Users user);

    List<Users> getAllUsers();

    Optional<Users> getUserById(String id);

    Users updateUser(String id, Users user);

    void deleteUser(String id);

    List<Users> findUsersByType(String type);


}
