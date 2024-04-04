package com.shash.easebook.controller;

import java.util.List;

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

import com.shash.easebook.dto.AdsResponseDTO;
import com.shash.easebook.entities.Ads;
import com.shash.easebook.service.AdsService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/ads")
public class AdsController {

    private final AdsService adsService;

//    @Autowired
    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AdsResponseDTO>> getAllAds() {
    	log.info("Getting all ads");
        List<AdsResponseDTO> ads = adsService.getAllAds();
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ads> getAdById(@PathVariable Long id) {
    	log.info("Getting ad by ID: {}", id);
        Ads ad = adsService.getAdById(id);
        if (ad != null) {
            return ResponseEntity.ok(ad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Ads> createAd(@RequestBody Ads ad) {
    	log.info("Creating ad");
        Ads createdAd = adsService.createAd(ad);
        return new ResponseEntity<>(createdAd, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ads> updateAd(@PathVariable Long id, @RequestBody Ads ad) {
    	log.info("Updating ad with ID: {}", id);
    	Ads updatedAd = adsService.updateAd(id, ad);
        return ResponseEntity.ok(updatedAd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAd(@PathVariable Long id) {
    	log.info("Deleting ad with ID: {}", id);
        adsService.deleteAd(id);
        return ResponseEntity.ok("Ad deleted successfully!");
    }

    @GetMapping("/search/provider")
    public ResponseEntity<List<AdsResponseDTO>> searchAdsByServiceProviderId(
            @RequestParam Long serviceProviderId) {
    	log.info("Searching ads by service provider ID: {}", serviceProviderId);
        List<AdsResponseDTO> ads = adsService.getAdsByServiceProviderId(serviceProviderId);
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/search/provider/{providerId}")
    public ResponseEntity<List<AdsResponseDTO>> searchAdsByServiceProviderIdAndName(
            @PathVariable Long providerId, @RequestParam String keyword) {
    	log.info("Searching ads by service provider ID ({}) and name ({})", providerId, keyword);
        List<AdsResponseDTO> ads = adsService.searchAdsByServiceProviderIdAndName(providerId, keyword);
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<AdsResponseDTO>> searchAdsByName(@RequestParam String keyword) {
    	log.info("Searching ads by name: {}", keyword);
        List<AdsResponseDTO> ads = adsService.searchAdsByName(keyword);
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/price/lessthan")
    public ResponseEntity<List<AdsResponseDTO>> getAdsByPriceLessThan(@RequestParam double price) {
    	log.info("Getting ads by price less than: {}", price);
        List<AdsResponseDTO> ads = adsService.getAdsByPriceLessThan(price);
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/price/greaterthan")
    public ResponseEntity<List<AdsResponseDTO>> getAdsByPriceGreaterThan(@RequestParam double price) {
    	log.info("Getting ads by price greater than: {}", price);
        List<AdsResponseDTO> ads = adsService.getAdsByPriceGreaterThan(price);
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/price/between")
    public ResponseEntity<List<AdsResponseDTO>> getAdsByPriceBetween(
            @RequestParam double minPrice, @RequestParam double maxPrice) {
    	log.info("Getting ads by price between: minPrice: {}, maxPrice: {}", minPrice, maxPrice);
        List<AdsResponseDTO> ads = adsService.getAdsByPriceBetween(minPrice, maxPrice);
        return ResponseEntity.ok(ads);
    }
}
