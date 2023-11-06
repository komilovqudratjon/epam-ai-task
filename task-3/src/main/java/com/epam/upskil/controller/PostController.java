package com.epam.upskil.controller;

import com.epam.upskil.model.Post;
import com.epam.upskil.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * @className: PostController  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 11:00 PM 17 $
 * @author: Qudratjon Komilov
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.ok(createdPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    // Other endpoints as needed
}
