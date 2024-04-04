package com.shash.easebook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shash.easebook.entities.ServiceProvider;
import com.shash.easebook.repository.ServiceProviderRepository;
import com.shash.easebook.service.ServiceProviderService;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository serviceProviderRepository;

//    @Autowired
    public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll();
    }

    @Override
    public Optional<ServiceProvider> getServiceProviderById(Long id) {
        return serviceProviderRepository.findById(id);
    }

    @Override
    public Optional<ServiceProvider> getServiceProviderByEmail(String email) {
        return serviceProviderRepository.findByEmail(email);
    }

    @Override
    public ServiceProvider createServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public void deleteServiceProvider(Long id) {
        serviceProviderRepository.deleteById(id);
    }

    @Override
    public boolean isServiceProviderExistsByEmail(String email) {
        return serviceProviderRepository.existsByEmail(email);
    }

    @Override
    public List<ServiceProvider> getServiceProvidersByName(String name) {
        return serviceProviderRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<ServiceProvider> getServiceProvidersByRole(String role) {
        return serviceProviderRepository.findByRole(role);
    }

    @Override
    public List<ServiceProvider> searchServiceProvidersByRoleAndName(String role, String keyword) {
        return serviceProviderRepository.findByRoleAndNameContainingIgnoreCase(role, keyword);
    }
}
