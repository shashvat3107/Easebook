package com.shash.easebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shash.easebook.entities.Ads;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {

    // Custom method to find ads by their adName
    Ads findByAdName(String adName);
    
//    Ads findById(Long id);

    // Custom method to find ads by their price
    List<Ads> findByPrice(double price);

    // Custom method to find ads by their serviceProviderId
    List<Ads> findByServiceProviderId(Long serviceProviderId);

    // Custom method to find ads by their serviceProviderId and adName containing a keyword
    List<Ads> findByServiceProviderIdAndAdNameContainingIgnoreCase(Long serviceProviderId, String keyword);

    // Custom method to find ads by adName containing a keyword
    List<Ads> findByAdNameContainingIgnoreCase(String keyword);

    // Custom method to find ads by price less than a certain value
    List<Ads> findByPriceLessThan(double price);

    // Custom method to find ads by price greater than a certain value
    List<Ads> findByPriceGreaterThan(double price);

    // Custom method to find ads by price between a range of values
    List<Ads> findByPriceBetween(double minPrice, double maxPrice);
}
