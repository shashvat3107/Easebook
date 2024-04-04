package com.shash.easebook.servicetest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shash.easebook.entities.User;
import com.shash.easebook.repository.UserRepository;
import com.shash.easebook.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	@Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUser() {
        // Mock data
        User user = new User(/* initialize User object */);
        when(userRepository.save(user)).thenReturn(user);

        // Call service method
        User result = userService.createUser(user);

        // Verify result
        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void testUpdateUser() {
        // Mock data
        User user = new User(/* initialize User object */);
        when(userRepository.save(user)).thenReturn(user);

        // Call service method
        User result = userService.updateUser(user);

        // Verify result
        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void testDeleteUser() {
        // Mock data
        Long userId = 1L;

        // Call service method
        assertDoesNotThrow(() -> userService.deleteUser(userId));
    }

    @Test
    void testGetUserById() {
        // Mock data
        Long userId = 1L;
        User user = new User(/* initialize User object */);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Call service method
        User result = userService.getUserById(userId);

        // Verify result
        assertNotNull(result);
        assertEquals(user, result);
    }

    @Test
    void testGetUserByEmail() {
        // Mock data
        String email = "test@example.com";
        User user = new User(/* initialize User object */);
        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        // Call service method
        User result = userService.getUserByEmail(email);

        // Verify result
        assertNotNull(result);
        assertEquals(user, result);
    }
    
    
    
    @Test
    void testDeleteUser_Negative() {
        // Mock data
        Long userId = 1L;
        doThrow(IllegalArgumentException.class).when(userRepository).deleteById(userId);

        // Call service method and expect an exception
        assertThrows(IllegalArgumentException.class, () -> userService.deleteUser(userId));
    }

//    @Test
//    void testGetUserById_Negative() {
//        // Mock data
//        Long userId = 1L;
//        when(userRepository.findById(userId)).thenReturn(Optional.empty());
//
//        // Call service method and expect an exception
//        assertThrows(RuntimeException.class, () -> userService.getUserById(userId));
//    }

    @Test
    void testGetUserByEmail_Negative() {
        // Mock data
        String email = "test@example.com";
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Call service method and expect an exception
        assertThrows(RuntimeException.class, () -> userService.getUserByEmail(email));
    }
}
