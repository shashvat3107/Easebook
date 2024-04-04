package com.shash.easebook.controllertest;

import com.shash.easebook.controller.UserController;
import com.shash.easebook.entities.User;
import com.shash.easebook.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Mock data
        List<User> userList = new ArrayList<>();
        when(userService.getAllUsers()).thenReturn(userList);

        // Call controller method
        List<User> result = userController.getAllUsers();

        // Verify result
        assertEquals(userList, result);
    }

    @Test
    void testGetUserById() {
        // Mock data
        Long userId = 1L;
        User user = new User(/* initialize User object */);
        when(userService.getUserById(userId)).thenReturn(user);

        // Call controller method
        User result = userController.getUserById(userId);

        // Verify result
        assertEquals(user, result);
    }

    @Test
    void testCreateUser() {
        // Mock data
        User user = new User(/* initialize User object */);
        when(userService.createUser(user)).thenReturn(user);

        // Call controller method
        User result = userController.createUser(user);

        // Verify result
        assertEquals(user, result);
    }

    @Test
    void testUpdateUser() {
        // Mock data
        Long userId = 1L;
        User user = new User(/* initialize User object */);
        when(userService.updateUser(user)).thenReturn(user);

        // Call controller method
        User result = userController.updateUser(userId, user);

        // Verify result
        assertEquals(user, result);
    }

    @Test
    void testDeleteUser() {
        // Call controller method
        Long userId = 1L;
        userController.deleteUser(userId);

        // Verify that userService.deleteUser() is called
        verify(userService, times(1)).deleteUser(userId);
    }
}
