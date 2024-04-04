package com.shash.easebook.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shash.easebook.controller.ServiceProviderController;
import com.shash.easebook.entities.ServiceProvider;
import com.shash.easebook.service.ServiceProviderService;

public class ServiceProviderControllerTest {
	@Mock
    private ServiceProviderService serviceProviderService;

    @InjectMocks
    private ServiceProviderController serviceProviderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllServiceProviders() {
        // Mock data
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        when(serviceProviderService.getAllServiceProviders()).thenReturn(serviceProviderList);

        // Call controller method
        ResponseEntity<List<ServiceProvider>> responseEntity = serviceProviderController.getAllServiceProviders();

        // Verify response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(serviceProviderList, responseEntity.getBody());
    }

    @Test
    void testGetServiceProviderById() {
        // Mock data
        Long id = 1L;
        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
        when(serviceProviderService.getServiceProviderById(id)).thenReturn(Optional.of(serviceProvider));

        // Call controller method
        ResponseEntity<ServiceProvider> responseEntity = serviceProviderController.getServiceProviderById(id);

        // Verify response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(serviceProvider, responseEntity.getBody());
    }
    
    @Test
    void testCreateServiceProvider() {
        // Mock data
        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
        when(serviceProviderService.createServiceProvider(serviceProvider)).thenReturn(serviceProvider);

        // Call controller method
        ResponseEntity<ServiceProvider> responseEntity = serviceProviderController.createServiceProvider(serviceProvider);

        // Verify response
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(serviceProvider, responseEntity.getBody());
    }

    // Test cases for updateServiceProvider method
    @Test
    void testUpdateServiceProvider() {
        // Mock data
        Long id = 1L;
        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
        when(serviceProviderService.getServiceProviderById(id)).thenReturn(Optional.of(serviceProvider));
        when(serviceProviderService.updateServiceProvider(serviceProvider)).thenReturn(serviceProvider);

        // Call controller method
        ResponseEntity<ServiceProvider> responseEntity = serviceProviderController.updateServiceProvider(id, serviceProvider);

        // Verify response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(serviceProvider, responseEntity.getBody());
    }

    // Test cases for deleteServiceProvider method
    @Test
    void testDeleteServiceProvider() {
        // Mock data
        Long id = 1L;
        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
        when(serviceProviderService.getServiceProviderById(id)).thenReturn(Optional.of(serviceProvider));

        // Call controller method
        ResponseEntity<Void> responseEntity = serviceProviderController.deleteServiceProvider(id);

        // Verify response
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(serviceProviderService, times(1)).deleteServiceProvider(id);
    }

    // Test cases for searchServiceProvidersByName method
    @Test
    void testSearchServiceProvidersByName() {
        // Mock data
        String name = "TestName";
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        when(serviceProviderService.getServiceProvidersByName(name)).thenReturn(serviceProviderList);

        // Call controller method
        ResponseEntity<List<ServiceProvider>> responseEntity = serviceProviderController.searchServiceProvidersByName(name);

        // Verify response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(serviceProviderList, responseEntity.getBody());
    }

    // Test cases for getServiceProvidersByRole method
    @Test
    void testGetServiceProvidersByRole() {
        // Mock data
        String role = "TestRole";
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        when(serviceProviderService.getServiceProvidersByRole(role)).thenReturn(serviceProviderList);

        // Call controller method
        ResponseEntity<List<ServiceProvider>> responseEntity = serviceProviderController.getServiceProvidersByRole(role);

        // Verify response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(serviceProviderList, responseEntity.getBody());
    }

    // Test cases for searchServiceProvidersByRoleAndName method
    @Test
    void testSearchServiceProvidersByRoleAndName() {
        // Mock data
        String role = "TestRole";
        String keyword = "TestKeyword";
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        when(serviceProviderService.searchServiceProvidersByRoleAndName(role, keyword)).thenReturn(serviceProviderList);

        // Call controller method
        ResponseEntity<List<ServiceProvider>> responseEntity = serviceProviderController.searchServiceProvidersByRoleAndName(role, keyword);

        // Verify response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(serviceProviderList, responseEntity.getBody());
    }
}
