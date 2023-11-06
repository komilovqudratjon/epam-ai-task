package com.epam.upskil.service;

import com.epam.upskil.model.User;

/**
 * @className: UserService  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 10:54 PM 41 $
 * @author: Qudratjon Komilov
 */
public interface UserService {
    User createUser(User user);
    void followUser(Long userId, Long userToFollowId);
    void likePost(Long userId, Long postId);
    // Add other necessary methods, e.g., getUserById, getUserByUsername, etc.
}