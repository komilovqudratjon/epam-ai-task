package com.epam.upskil.service.impl;
import com.epam.upskil.exception.ResourceNotFoundException;
import com.epam.upskil.model.Post;
import com.epam.upskil.repository.PostRepository;
import com.epam.upskil.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @className: PostServiceImplementation  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 10:55 PM 26 $
 * @author: Qudratjon Komilov
 */
@Service
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImplementation(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post"+ "id: "+id));
    }

    // Implement other methods as necessary.
}