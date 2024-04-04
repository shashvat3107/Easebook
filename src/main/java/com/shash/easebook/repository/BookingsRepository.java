package com.shash.easebook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shash.easebook.entities.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {

//	List<Bookings> findAllBookings();
    Optional<Bookings> findById(Long id);

    List<Bookings> findByUserId(Long userId);

    List<Bookings> findByAdId(Long adId);

    List<Bookings> findByStatus(String status);

}