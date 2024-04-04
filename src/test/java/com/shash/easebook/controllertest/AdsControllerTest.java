package com.shash.easebook.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shash.easebook.controller.AdsController;
import com.shash.easebook.dto.AdsResponseDTO;
import com.shash.easebook.entities.Ads;
import com.shash.easebook.service.AdsService;

class AdsControllerTest {

    @Mock
    private AdsService adsService;

    @InjectMocks
    private AdsController adsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllAds() {
        // Mock data
        List<AdsResponseDTO> adsList = new ArrayList<>();
        when(adsService.getAllAds()).thenReturn(adsList);

        // Call controller method
        ResponseEntity<List<AdsResponseDTO>> response = adsController.getAllAds();

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adsList, response.getBody());
    }

    @Test
    void testGetAdById() {
        // Mock data
        Long id = 1L;
        Ads ad = new Ads(/* initialize Ads object */);
        when(adsService.getAdById(id)).thenReturn(ad);

        // Call controller method
        ResponseEntity<Ads> response = adsController.getAdById(id);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ad, response.getBody());
    }

    @Test
    void testCreateAd() {
        // Mock data
        Ads ad = new Ads(/* initialize Ads object */);
        when(adsService.createAd(ad)).thenReturn(ad);

        // Call controller method
        ResponseEntity<Ads> response = adsController.createAd(ad);

        // Verify response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ad, response.getBody());
    }

    @Test
    void testUpdateAd() {
        // Mock data
        Long id = 1L;
        Ads ad = new Ads(/* initialize Ads object */);
        when(adsService.updateAd(id, ad)).thenReturn(ad);

        // Call controller method
        ResponseEntity<Ads> response = adsController.updateAd(id, ad);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ad, response.getBody());
    }

    @Test
    void testDeleteAd() {
        // Mock data
        Long id = 1L;

        // Call controller method
        ResponseEntity<String> response = adsController.deleteAd(id);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ad deleted successfully!", response.getBody());
    }

    @Test
    void testSearchAdsByServiceProviderId() {
        // Mock data
        Long serviceProviderId = 1L;
        List<AdsResponseDTO> adsList = new ArrayList<>();
        when(adsService.getAdsByServiceProviderId(serviceProviderId)).thenReturn(adsList);

        // Call controller method
        ResponseEntity<List<AdsResponseDTO>> response = adsController.searchAdsByServiceProviderId(serviceProviderId);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adsList, response.getBody());
    }

    @Test
    void testSearchAdsByName() {
        // Mock data
        String keyword = "keyword";
        List<AdsResponseDTO> adsList = new ArrayList<>();
        when(adsService.searchAdsByName(keyword)).thenReturn(adsList);

        // Call controller method
        ResponseEntity<List<AdsResponseDTO>> response = adsController.searchAdsByName(keyword);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adsList, response.getBody());
    }

    @Test
    void testGetAdsByPriceLessThan() {
        // Mock data
        double price = 100.0;
        List<AdsResponseDTO> adsList = new ArrayList<>();
        when(adsService.getAdsByPriceLessThan(price)).thenReturn(adsList);

        // Call controller method
        ResponseEntity<List<AdsResponseDTO>> response = adsController.getAdsByPriceLessThan(price);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adsList, response.getBody());
    }

    @Test
    void testGetAdsByPriceGreaterThan() {
        // Mock data
        double price = 100.0;
        List<AdsResponseDTO> adsList = new ArrayList<>();
        when(adsService.getAdsByPriceGreaterThan(price)).thenReturn(adsList);

        // Call controller method
        ResponseEntity<List<AdsResponseDTO>> response = adsController.getAdsByPriceGreaterThan(price);

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(adsList, response.getBody());
    }

}