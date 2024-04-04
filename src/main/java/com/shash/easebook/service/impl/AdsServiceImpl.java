package com.shash.easebook.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shash.easebook.dto.AdsResponseDTO;
import com.shash.easebook.entities.Ads;
import com.shash.easebook.entities.ServiceProvider;
import com.shash.easebook.repository.AdsRepository;
import com.shash.easebook.repository.ServiceProviderRepository;
import com.shash.easebook.service.AdsService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdsServiceImpl implements AdsService {

    private final AdsRepository adsRepository;
    private final ServiceProviderRepository serviceProviderRepository;

    @Autowired
    public AdsServiceImpl(AdsRepository adsRepository, ServiceProviderRepository serviceProviderRepository) {
        this.adsRepository = adsRepository;
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @Override
    public List<AdsResponseDTO> getAllAds() {
        List<Ads> ads = adsRepository.findAll();
        return ads.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Ads getAdById(Long id) {
//        Ads ad = adsRepository.findById(id);
//        return ad.map(this::mapEntityToDto)
//                .orElse(null);
    	return adsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }
    
    @Override
    public Ads createAd(Ads ad) {
        Optional<ServiceProvider> service = serviceProviderRepository.findById(ad.getServiceProvider().getId());
        Ads res = new Ads();
        if (service.isPresent()) {
            Ads ads = Ads.builder()
                .adName(ad.getAdName())
                .description(ad.getDescription())
                .photo(ad.getPhoto())
                .price(ad.getPrice())
                .serviceProvider(service.get())
                .build();
            res = adsRepository.save(ads);
            // return mapEntityToDto(res);
        } 
        return res;
    }


//    @Override
//    public Ads createAd(Ads ad) {
//        Optional<ServiceProvider> service = serviceProviderRepository.findById(ad.getServiceProvider().getId());
//        Ads ads = Ads.builder()
//                .adName(ad.getAdName())
//                .description(ad.getDescription())
//                .photo(ad.getPhoto())
//                .price(ad.getPrice())
//                .serviceProvider(service.get())
//                .build();
//        Ads res = adsRepository.save(ads);
////        return mapEntityToDto(res);
//        return res;
//    }

    @Override
    public Ads updateAd(Long id, Ads ad) {
        Optional<Ads> existingAdOptional = adsRepository.findById(id);
        Ads existingAd = existingAdOptional.orElseThrow(() -> new IllegalArgumentException("Ad not found with id: " + id));

        existingAd.setAdName(ad.getAdName());
        existingAd.setDescription(ad.getDescription());
        existingAd.setPhoto(ad.getPhoto());
        existingAd.setPrice(ad.getPrice());

        Optional<ServiceProvider> serviceProvider = serviceProviderRepository.findById(ad.getServiceProvider().getId());
        
        serviceProvider.ifPresent(existingAd::setServiceProvider);

        Ads updatedAdEntity = adsRepository.save(existingAd);
//        return mapEntityToDto(updatedAdEntity);
        return updatedAdEntity;
    }

    @Override
    public void deleteAd(Long id) {
        adsRepository.deleteById(id);
    }

    @Override
    public List<AdsResponseDTO> getAdsByServiceProviderId(Long serviceProviderId) {
        List<Ads> ads = adsRepository.findByServiceProviderId(serviceProviderId);
        return ads.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdsResponseDTO> searchAdsByServiceProviderIdAndName(Long serviceProviderId, String keyword) {
        List<Ads> ads = adsRepository.findByServiceProviderIdAndAdNameContainingIgnoreCase(serviceProviderId, keyword);
        return ads.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdsResponseDTO> searchAdsByName(String keyword) {
        List<Ads> ads = adsRepository.findByAdNameContainingIgnoreCase(keyword);
        return ads.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdsResponseDTO> getAdsByPriceLessThan(double price) {
        List<Ads> ads = adsRepository.findByPriceLessThan(price);
        return ads.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdsResponseDTO> getAdsByPriceGreaterThan(double price) {
        List<Ads> ads = adsRepository.findByPriceGreaterThan(price);
        return ads.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdsResponseDTO> getAdsByPriceBetween(double minPrice, double maxPrice) {
        List<Ads> ads = adsRepository.findByPriceBetween(minPrice, maxPrice);
        return ads.stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    private AdsResponseDTO mapEntityToDto(Ads ad) {
        return new AdsResponseDTO(
                ad.getId(),
                ad.getPhoto(),
                ad.getAdName(),
                ad.getPrice(),
                ad.getDescription(),
                ad.getServiceProvider().getId()
        );
    }
}