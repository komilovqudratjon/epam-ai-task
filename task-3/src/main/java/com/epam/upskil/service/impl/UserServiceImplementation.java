package com.epam.upskil.service.impl;

import com.epam.upskil.model.Post;
import com.epam.upskil.model.User;
import com.epam.upskil.repository.PostRepository;
import com.epam.upskil.repository.UserRepository;
import com.epam.upskil.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @className: UserServiceImplementation  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 10:52 PM 48 $
 * @author: Qudratjon Komilov
 */
@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void followUser(Long userId, Long userToFollowId) {
        User user = userRepository.findById(userId).orElseThrow();
        User userToFollow = userRepository.findById(userToFollowId).orElseThrow();
        user.getFollowing().add(userToFollow);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void likePost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();
        user.getLikedPosts().add(post);
        userRepository.save(user);
    }

    // Implement other methods as necessary.
}
