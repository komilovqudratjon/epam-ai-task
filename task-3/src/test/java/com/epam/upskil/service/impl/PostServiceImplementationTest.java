package com.epam.upskil.service.impl;

import com.epam.upskil.exception.ResourceNotFoundException;
import com.epam.upskil.model.Post;
import com.epam.upskil.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @className: PostServiceImplementationTest  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 11:08 PM 56 $
 * @author: Qudratjon Komilov
 */
class PostServiceImplementationTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImplementation postService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPost() {
        // Arrange
        Post post = new Post();
        post.setTitle("Test Post");
        post.setBody("This is a test post body.");
        when(postRepository.save(any(Post.class))).thenReturn(post);

        // Act
        Post createdPost = postService.createPost(post);

        // Assert
        assertNotNull(createdPost);
        assertEquals("Test Post", createdPost.getTitle());
        assertEquals("This is a test post body.", createdPost.getBody());
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    void getPostById_found() {
        // Arrange
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Post");
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        // Act
        Post foundPost = postService.getPostById(1L);

        // Assert
        assertNotNull(foundPost);
        assertEquals("Test Post", foundPost.getTitle());
        verify(postRepository, times(1)).findById(1L);
    }

    @Test
    void getPostById_notFound() {
        // Arrange
        when(postRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> postService.getPostById(1L));
        verify(postRepository, times(1)).findById(1L);
    }
}