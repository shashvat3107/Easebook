package com.shash.easebook.service;



import java.util.List;

import com.shash.easebook.entities.Payment;


public interface PaymentService {

    Payment createPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    List<Payment> getPaymentsByUserId(Long userId);

    List<Payment> getPaymentsByAdId(Long adId);

    void deletePayment(Long id);
}
