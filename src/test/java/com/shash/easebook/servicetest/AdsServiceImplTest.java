package com.shash.easebook.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.shash.easebook.entities.Ads;
import com.shash.easebook.repository.AdsRepository;
import com.shash.easebook.repository.ServiceProviderRepository;
import com.shash.easebook.service.impl.AdsServiceImpl;

import jakarta.persistence.EntityNotFoundException;

class AdsServiceImplTest {

    @Mock
    private AdsRepository adsRepository;

    @Mock
    private ServiceProviderRepository serviceProviderRepository;

    @InjectMocks
    private AdsServiceImpl adsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testGetAllAds_Positive() {
//        // Mock data
//        List<Ads> adsList = new ArrayList<>();
//        adsList.add(new Ads(/* initialize Ads object */));
//        when(adsRepository.findAll()).thenReturn(adsList);
//
//        // Call service method
//        List<AdsResponseDTO> result = adsService.getAllAds();
//
//        // Verify result
//        assertNotNull(result);
//        assertEquals(adsList.size(), result.size());
//        // Add more assertions as needed
//    }

    @Test
    void testGetAdById_Positive() {
        // Mock data
        Long id = 1L;
        Ads ad = new Ads(/* initialize Ads object */);
        when(adsRepository.findById(id)).thenReturn(Optional.of(ad));

        // Call service method
        Ads result = adsService.getAdById(id);

        // Verify result
        assertNotNull(result);
        assertEquals(ad, result);
        // Add more assertions as needed
    }

    @Test
    void testGetAdById_Negative() {
        // Mock data
        Long id = 1L;
        when(adsRepository.findById(id)).thenReturn(Optional.empty());

        // Call service method and expect an exception
        assertThrows(EntityNotFoundException.class, () -> adsService.getAdById(id));
    }

//    @Test
//    void testCreateAd_Positive() {
//        // Mock data
//        Ads ad = new Ads(/* initialize Ads object */);
//        ServiceProvider serviceProvider = new ServiceProvider(/* initialize ServiceProvider object */);
//        when(serviceProviderRepository.findById(anyLong())).thenReturn(Optional.of(serviceProvider));
//        when(adsRepository.save(any())).thenReturn(ad);
//
//        // Call service method
//        Ads result = adsService.createAd(ad);
//
//        // Verify result
//        assertNotNull(result);
//        // Add more assertions as needed
//    }

//    @Test
//    void testCreateAd_Negative() {
//        // Mock data
//        Ads ad = new Ads(/* initialize Ads object */);
//        when(serviceProviderRepository.findById(anyLong())).thenReturn(Optional.empty());
//
//        // Call service method and expect an exception
//        assertThrows(IllegalArgumentException.class, () -> adsService.createAd(ad));
//    }

//    @Test
//    void testUpdateAd_Positive() {
//        // Mock data
//        Long id = 1L;
//        Ads existingAd = new Ads(/* initialize existing Ads object */);
//        Ads updatedAd = new Ads(/* initialize updated Ads object */);
//        when(adsRepository.findById(id)).thenReturn(Optional.of(existingAd));
//        when(adsRepository.save(any())).thenReturn(updatedAd);
//
//        // Call service method
//        Ads result = adsService.updateAd(id, updatedAd);
//
//        // Verify result
//        assertNotNull(result);
//        assertEquals(updatedAd, result);
//        // Add more assertions as needed
//    }

    @Test
    void testUpdateAd_Negative() {
        // Mock data
        Long id = 1L;
        Ads updatedAd = new Ads(/* initialize updated Ads object */);
        when(adsRepository.findById(id)).thenReturn(Optional.empty());

        // Call service method and expect an exception
        assertThrows(IllegalArgumentException.class, () -> adsService.updateAd(id, updatedAd));
    }

    @Test
    void testDeleteAd_Positive() {
        // Mock data
        Long id = 1L;

        // Call service method
        adsService.deleteAd(id);

        // Verify that adsRepository.deleteById() is called
        verify(adsRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteAd_Negative() {
        // Mock data
        Long id = 1L;
        doThrow(IllegalArgumentException.class).when(adsRepository).deleteById(id);

        // Call service method and expect an exception
        assertThrows(IllegalArgumentException.class, () -> adsService.deleteAd(id));
    }


}
