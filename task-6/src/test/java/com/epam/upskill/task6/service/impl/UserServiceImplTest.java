package com.epam.upskill.task6.service.impl;

import com.epam.upskill.task6.model.Users;
import com.epam.upskill.task6.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @className: UserServiceImplTest  $
 * @description: TODO
 * @date: 07 November 2023 $
 * @time: 6:18 PM 15 $
 * @author: Qudratjon Komilov
 */
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUser() {
        Users user = new Users("1", "John Doe", "Actor");
        when(userRepository.save(any(Users.class))).thenReturn(user);

        Users savedUser = userService.saveUser(user);
        assertNotNull(savedUser);
        assertEquals("John Doe", savedUser.getName());
    }

    @Test
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(new Users("1", "John Doe", "Actor"), new Users("2", "Jane Doe", "Director")));

        List<Users> users = userService.getAllUsers();
        assertFalse(users.isEmpty());
        assertEquals(2, users.size());
    }

    @Test
    void getUserById() {
        Users user = new Users("1", "John Doe", "Actor");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        Optional<Users> foundUser = userService.getUserById("1");
        assertTrue(foundUser.isPresent());
        assertEquals("John Doe", foundUser.get().getName());
    }

    @Test
    void updateUser() {
        Users existingUser = new Users("1", "John Doe", "Actor");
        Users newUserDetails = new Users("1", "Johnny Doe", "Actor");
        when(userRepository.findById("1")).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(Users.class))).thenReturn(newUserDetails);

        Users updatedUser = userService.updateUser("1", newUserDetails);
        assertNotNull(updatedUser);
        assertEquals("Johnny Doe", updatedUser.getName());
    }

    @Test
    void deleteUser() {
        doNothing().when(userRepository).deleteById(anyString());
        userService.deleteUser("1");
        verify(userRepository, times(1)).deleteById("1");
    }

    @Test
    void findUsersByType() {
        when(userRepository.findByType("Actor")).thenReturn(Arrays.asList(new Users("1", "John Doe", "Actor")));

        List<Users> actors = userService.findUsersByType("Actor");
        assertFalse(actors.isEmpty());
        assertEquals(1, actors.size());
        assertEquals("Actor", actors.get(0).getType());
    }
}