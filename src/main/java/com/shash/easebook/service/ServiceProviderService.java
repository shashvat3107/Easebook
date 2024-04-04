package com.shash.easebook.service;

import java.util.List;
import java.util.Optional;

import com.shash.easebook.entities.ServiceProvider;

public interface ServiceProviderService {

    List<ServiceProvider> getAllServiceProviders();

    Optional<ServiceProvider> getServiceProviderById(Long id);

    Optional<ServiceProvider> getServiceProviderByEmail(String email);

    ServiceProvider createServiceProvider(ServiceProvider serviceProvider);

    ServiceProvider updateServiceProvider(ServiceProvider serviceProvider);

    void deleteServiceProvider(Long id);

    boolean isServiceProviderExistsByEmail(String email);

    List<ServiceProvider> getServiceProvidersByName(String name);

    List<ServiceProvider> getServiceProvidersByRole(String role);

    List<ServiceProvider> searchServiceProvidersByRoleAndName(String role, String keyword);
}
