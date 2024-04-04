package com.shash.easebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shash.easebook.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
    
    boolean existsByEmail(String email);

    // Custom method to find users by their role
    List<User> findByRole(String role);

    // Custom method to find users by name containing a keyword
    List<User> findByNameContainingIgnoreCase(String keyword);

    // Custom method to find users by role and name containing a keyword
    List<User> findByRoleAndNameContainingIgnoreCase(String role, String keyword);

    // Custom method to find users by role or name containing a keyword
    List<User> findByRoleOrNameContainingIgnoreCase(String role, String keyword);
}

