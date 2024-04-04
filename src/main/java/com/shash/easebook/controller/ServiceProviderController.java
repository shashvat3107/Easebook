package com.shash.easebook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shash.easebook.entities.ServiceProvider;
import com.shash.easebook.service.ServiceProviderService;

@RestController
@RequestMapping("/api/service-providers")
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

//    @Autowired
    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ServiceProvider>> getAllServiceProviders() {
        List<ServiceProvider> serviceProviders = serviceProviderService.getAllServiceProviders();
        return ResponseEntity.ok(serviceProviders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProvider> getServiceProviderById(@PathVariable Long id) {
        Optional<ServiceProvider> serviceProvider = serviceProviderService.getServiceProviderById(id);
        return serviceProvider.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create-provider")
    public ResponseEntity<ServiceProvider> createServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        ServiceProvider createdServiceProvider = serviceProviderService.createServiceProvider(serviceProvider);
        return new ResponseEntity<>(createdServiceProvider, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProvider> updateServiceProvider(
            @PathVariable Long id, @RequestBody ServiceProvider serviceProvider) {
        Optional<ServiceProvider> existingServiceProvider = serviceProviderService.getServiceProviderById(id);
        if (existingServiceProvider.isPresent()) {
            serviceProvider.setId(id);
            ServiceProvider updatedServiceProvider = serviceProviderService.updateServiceProvider(serviceProvider);
            return ResponseEntity.ok(updatedServiceProvider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable Long id) {
        Optional<ServiceProvider> serviceProvider = serviceProviderService.getServiceProviderById(id);
        if (serviceProvider.isPresent()) {
            serviceProviderService.deleteServiceProvider(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Search service providers by name
    @GetMapping("/search")
    public ResponseEntity<List<ServiceProvider>> searchServiceProvidersByName(
            @RequestParam String name) {
        List<ServiceProvider> serviceProviders = serviceProviderService.getServiceProvidersByName(name);
        return ResponseEntity.ok(serviceProviders);
    }

    // Search service providers by role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<ServiceProvider>> getServiceProvidersByRole(
            @PathVariable String role) {
        List<ServiceProvider> serviceProviders = serviceProviderService.getServiceProvidersByRole(role);
        return ResponseEntity.ok(serviceProviders);
    }

    // Search service providers by role and name
    @GetMapping("/search/{role}")
    public ResponseEntity<List<ServiceProvider>> searchServiceProvidersByRoleAndName(
            @PathVariable String role, @RequestParam String keyword) {
        List<ServiceProvider> serviceProviders = serviceProviderService.searchServiceProvidersByRoleAndName(role, keyword);
        return ResponseEntity.ok(serviceProviders);
    }
}
