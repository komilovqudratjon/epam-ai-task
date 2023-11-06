package com.epam.upskil.service;

import com.epam.upskil.model.Post;

/**
 * @className: PostService  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 10:53 PM 05 $
 * @author: Qudratjon Komilov
 */
public interface PostService {
    Post createPost(Post post);
    Post getPostById(Long id);
    // Add methods if needed, e.g., getPostsByUser, getAllPosts, etc.
}
