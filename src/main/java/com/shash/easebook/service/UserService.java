package com.shash.easebook.service;

import java.util.List;

import com.shash.easebook.entities.User;

public interface UserService {
    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    List<User> getAllUsers();

    //User getUserById(Long userId);

	User getUserByEmail(String email);
	
	User getUserById(Long userId);
//	Optional<User> getUserById(Long userId);
}