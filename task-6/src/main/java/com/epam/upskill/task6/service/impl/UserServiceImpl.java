package com.epam.upskill.task6.service.impl;

import com.epam.upskill.task6.model.Users;
import com.epam.upskill.task6.repository.UserRepository;
import com.epam.upskill.task6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @className: UserServiceImpl  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 6:13 PM 52 $
 * @author: Qudratjon Komilov
 */


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Users updateUser(String id, Users userDetails) {
        Users user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setType(userDetails.getType());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Users> findUsersByType(String type) {
        return userRepository.findByType(type);
    }
}

