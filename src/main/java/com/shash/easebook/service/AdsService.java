package com.shash.easebook.service;

import java.util.List;

import com.shash.easebook.dto.AdsResponseDTO;
import com.shash.easebook.entities.Ads;

public interface AdsService {

//    List<Ads> getAllAds();
	List<AdsResponseDTO> getAllAds();

//    Optional<Ads> getAdById(Long id);
    Ads getAdById(Long id);
    

    Ads createAd(Ads ad);

    Ads updateAd(Long id, Ads ad);

    void deleteAd(Long id);

    List<AdsResponseDTO> getAdsByServiceProviderId(Long serviceProviderId);

    List<AdsResponseDTO> searchAdsByServiceProviderIdAndName(Long serviceProviderId, String keyword);

    List<AdsResponseDTO> searchAdsByName(String keyword);

    List<AdsResponseDTO> getAdsByPriceLessThan(double price);

    List<AdsResponseDTO> getAdsByPriceGreaterThan(double price);

    List<AdsResponseDTO> getAdsByPriceBetween(double minPrice, double maxPrice);
}



/*
 public interface AdsService {

    List<AdsResponseDTO> getAllAds();

    Optional<AdsResponseDTO> getAdById(Long id);
    

    AdsResponseDTO createAd(AdsDTO ad);

    AdsResponseDTO updateAd(Long id, AdsDTO ad);

    void deleteAd(Long id);

    List<AdsResponseDTO> getAdsByServiceProviderId(Long serviceProviderId);

    List<AdsResponseDTO> searchAdsByServiceProviderIdAndName(Long serviceProviderId, String keyword);

    List<AdsResponseDTO> searchAdsByName(String keyword);

    List<AdsResponseDTO> getAdsByPriceLessThan(double price);

    List<AdsResponseDTO> getAdsByPriceGreaterThan(double price);

    List<AdsResponseDTO> getAdsByPriceBetween(double minPrice, double maxPrice);
}

  
  */
 