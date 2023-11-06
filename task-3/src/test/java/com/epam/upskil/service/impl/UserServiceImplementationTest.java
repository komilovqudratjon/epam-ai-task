package com.epam.upskil.service.impl;

import com.epam.upskil.model.Post;
import com.epam.upskil.model.User;
import com.epam.upskil.repository.PostRepository;
import com.epam.upskil.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @className: UserServiceImplementationTest  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 11:09 PM 12 $
 * @author: Qudratjon Komilov
 */
class UserServiceImplementationTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private UserServiceImplementation userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() {
        // Arrange
        User user = new User();
        user.setUsername("testUser");
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User createdUser = userService.createUser(user);

        // Assert
        assertNotNull(createdUser);
        assertEquals("testUser", createdUser.getUsername());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void followUser() {
        // Arrange
        User user = new User();
        user.setId(1L);
        User userToFollow = new User();
        userToFollow.setId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.findById(2L)).thenReturn(Optional.of(userToFollow));

        // Act
        userService.followUser(1L, 2L);

        // Assert
        assertTrue(user.getFollowing().contains(userToFollow));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void likePost() {
        // Arrange
        User user = new User();
        user.setId(1L);
        Post post = new Post();
        post.setId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        // Act
        userService.likePost(1L, 1L);

        // Assert
        assertTrue(user.getLikedPosts().contains(post));
        verify(userRepository, times(1)).save(user);
    }

}