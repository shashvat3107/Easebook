package com.shash.easebook.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shash.easebook.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findById(Long id);

    List<Payment> findByUserId(Long userId);

    List<Payment> findByAdId(Long adId);

    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);

}
