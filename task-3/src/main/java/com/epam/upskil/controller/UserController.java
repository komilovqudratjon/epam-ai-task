package com.epam.upskil.controller;

import com.epam.upskil.model.User;
import com.epam.upskil.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * @className: UserController  $
 * @description: TODO
 * @date: 06 November 2023 $
 * @time: 10:59 PM 36 $
 * @author: Qudratjon Komilov
 */
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/{userId}/follow/{userToFollowId}")
    public ResponseEntity<?> followUser(
            @PathVariable Long userId,
            @PathVariable Long userToFollowId) {
        userService.followUser(userId, userToFollowId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}/like/{postId}")
    public ResponseEntity<?> likePost(
            @PathVariable Long userId,
            @PathVariable Long postId) {
        userService.likePost(userId, postId);
        return ResponseEntity.ok().build();
    }
}