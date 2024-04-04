package com.shash.easebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shash.easebook.entities.ServiceProvider;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    Optional<ServiceProvider> findByEmail(String email);

    Optional<ServiceProvider> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);

    // Custom method to find service providers by their name
    List<ServiceProvider> findByName(String name);

    // Custom method to find service providers by name containing a keyword
    List<ServiceProvider> findByNameContainingIgnoreCase(String keyword);

    // Custom method to find service providers by their service provider ID
    Optional<ServiceProvider> findById(Long id);

    // Custom method to find service providers by their role
    List<ServiceProvider> findByRole(String role);

    // Custom method to find service providers by their role and name containing a keyword
    List<ServiceProvider> findByRoleAndNameContainingIgnoreCase(String role, String keyword);

    // Custom method to find service providers by their role or name containing a keyword
    List<ServiceProvider> findByRoleOrNameContainingIgnoreCase(String role, String keyword);
}
