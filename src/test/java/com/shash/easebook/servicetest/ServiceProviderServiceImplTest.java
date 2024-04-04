package com.shash.easebook.servicetest;

import com.shash.easebook.entities.ServiceProvider;
import com.shash.easebook.repository.ServiceProviderRepository;
import com.shash.easebook.service.impl.ServiceProviderServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceProviderServiceImplTest {

    @Mock
    private ServiceProviderRepository serviceProviderRepository;

    @InjectMocks
    private ServiceProviderServiceImpl serviceProviderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllServiceProviders_Positive() {
        // Mock data
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        when(serviceProviderRepository.findAll()).thenReturn(serviceProviderList);

        // Call service method
        List<ServiceProvider> result = serviceProviderService.getAllServiceProviders();

        // Verify result
        assertNotNull(result);
        assertEquals(serviceProviderList, result);
    }

    @Test
    void testGetServiceProviderById_Positive() {
        // Mock data
        Long id = 1L;
        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
        when(serviceProviderRepository.findById(id)).thenReturn(Optional.of(serviceProvider));

        // Call service method
        Optional<ServiceProvider> result = serviceProviderService.getServiceProviderById(id);

        // Verify result
        assertTrue(result.isPresent());
        assertEquals(serviceProvider, result.get());
    }

    @Test
    void testGetServiceProviderByEmail_Positive() {
        // Mock data
        String email = "test@example.com";
        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
        when(serviceProviderRepository.findByEmail(email)).thenReturn(Optional.of(serviceProvider));

        // Call service method
        Optional<ServiceProvider> result = serviceProviderService.getServiceProviderByEmail(email);

        // Verify result
        assertTrue(result.isPresent());
        assertEquals(serviceProvider, result.get());
    }

    // Similarly, write positive tests for other methods

    @Test
    void testCreateServiceProvider_Positive() {
        // Mock data
        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
        when(serviceProviderRepository.save(serviceProvider)).thenReturn(serviceProvider);

        // Call service method
        ServiceProvider result = serviceProviderService.createServiceProvider(serviceProvider);

        // Verify result
        assertNotNull(result);
        assertEquals(serviceProvider, result);
    }

    @Test
    void testUpdateServiceProvider_Positive() {
        // Mock data
        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
        when(serviceProviderRepository.save(serviceProvider)).thenReturn(serviceProvider);

        // Call service method
        ServiceProvider result = serviceProviderService.updateServiceProvider(serviceProvider);

        // Verify result
        assertNotNull(result);
        assertEquals(serviceProvider, result);
    }

    @Test
    void testDeleteServiceProvider_Positive() {
        // Mock data
        Long id = 1L;

        // Call service method
        assertDoesNotThrow(() -> serviceProviderService.deleteServiceProvider(id));
    }

    // Negative Test Cases

    @Test
    void testGetAllServiceProviders_Negative() {
        // Mock service provider repository to return null
        when(serviceProviderRepository.findAll()).thenReturn(null);

        // Call service method
        List<ServiceProvider> result = serviceProviderService.getAllServiceProviders();

        // Verify result
        assertNull(result);
    }

    @Test
    void testGetServiceProviderById_Negative() {
        // Mock data
        Long id = 1L;

        // Call service method
        Optional<ServiceProvider> result = serviceProviderService.getServiceProviderById(id);

        // Verify result
        assertFalse(result.isPresent());
    }

    @Test
    void testGetServiceProviderByEmail_Negative() {
        // Mock data
        String email = "test@example.com";

        // Call service method
        Optional<ServiceProvider> result = serviceProviderService.getServiceProviderByEmail(email);

        // Verify result
        assertFalse(result.isPresent());
    }

    @Test
    void testIsServiceProviderExistsByEmail_Negative() {
        // Mock data
        String email = "test@example.com";
        when(serviceProviderRepository.existsByEmail(email)).thenReturn(false);

        // Call service method
        boolean result = serviceProviderService.isServiceProviderExistsByEmail(email);

        // Verify result
        assertFalse(result);
    }

    @Test
    void testGetServiceProvidersByName_Negative() {
        // Mock data
        String name = "TestName";
        when(serviceProviderRepository.findByNameContainingIgnoreCase(name)).thenReturn(null);

        // Call service method
        List<ServiceProvider> result = serviceProviderService.getServiceProvidersByName(name);

        // Verify result
        assertNull(result);
    }

    @Test
    void testGetServiceProvidersByRole_Negative() {
        // Mock data
        String role = "TestRole";
        when(serviceProviderRepository.findByRole(role)).thenReturn(null);

        // Call service method
        List<ServiceProvider> result = serviceProviderService.getServiceProvidersByRole(role);

        // Verify result
        assertNull(result);
    }

    @Test
    void testSearchServiceProvidersByRoleAndName_Negative() {
        // Mock data
        String role = "TestRole";
        String keyword = "TestKeyword";
        when(serviceProviderRepository.findByRoleAndNameContainingIgnoreCase(role, keyword)).thenReturn(null);

        // Call service method
        List<ServiceProvider> result = serviceProviderService.searchServiceProvidersByRoleAndName(role, keyword);

        // Verify result
        assertNull(result);
    }
}
