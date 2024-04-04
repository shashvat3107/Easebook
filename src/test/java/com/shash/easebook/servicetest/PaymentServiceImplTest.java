package com.shash.easebook.servicetest;

import com.shash.easebook.dto.PaymentDTO;
import com.shash.easebook.dto.PaymentResponseDTO;
import com.shash.easebook.entities.Payment;
import com.shash.easebook.repository.PaymentRepository;
import com.shash.easebook.service.impl.PaymentServiceImpl;

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

public class PaymentServiceImplTest {
	
	@Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePayment_Positive() {
        // Mock data
//        PaymentDTO paymentDTO = new PaymentDTO(/* initialize PaymentDTO object */);
    	Payment paymentDTO = new Payment(/* initialize PaymentDTO object */);
        Payment payment = new Payment(/* initialize Payment object */);
        when(paymentRepository.save(any())).thenReturn(payment);

        // Call service method
        Payment result = paymentService.createPayment(paymentDTO);

        // Verify result
        assertNotNull(result);
        // Add additional assertions if needed
    }

    @Test
    void testGetAllPayments_Positive() {
        // Mock data
        List<Payment> paymentList = new ArrayList<>();
        when(paymentRepository.findAll()).thenReturn(paymentList);

        // Call service method
        List<Payment> result = paymentService.getAllPayments();

        // Verify result
        assertNotNull(result);
        // Add additional assertions if needed
    }

    @Test
    void testGetPaymentById_Positive() {
        // Mock data
        Long paymentId = 1L;
        Payment payment = new Payment(/* initialize Payment object */);
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));

        // Call service method
        Payment result = paymentService.getPaymentById(paymentId);

        // Verify result
        assertNotNull(result);
        // Add additional assertions if needed
    }

    @Test
    void testGetPaymentById_Negative() {
        // Mock data
        Long paymentId = 1L;
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        // Call service method and verify exception
        assertNull(paymentService.getPaymentById(paymentId));
    }

    @Test
    void testGetPaymentsByUserId_Positive() {
        // Mock data
        Long userId = 1L;
        List<Payment> paymentList = new ArrayList<>();
        when(paymentRepository.findByUserId(userId)).thenReturn(paymentList);

        // Call service method
        List<Payment> result = paymentService.getPaymentsByUserId(userId);

        // Verify result
        assertNotNull(result);
        // Add additional assertions if needed
    }

    @Test
    void testGetPaymentsByAdId_Positive() {
        // Mock data
        Long adId = 1L;
        List<Payment> paymentList = new ArrayList<>();
        when(paymentRepository.findByAdId(adId)).thenReturn(paymentList);

        // Call service method
        List<Payment> result = paymentService.getPaymentsByAdId(adId);

        // Verify result
        assertNotNull(result);
        // Add additional assertions if needed
    }

    @Test
    void testDeletePayment_Positive() {
        // Mock data
        Long paymentId = 1L;

        // Call service method
        paymentService.deletePayment(paymentId);

        // Verify that paymentRepository.deleteById() is called
        verify(paymentRepository, times(1)).deleteById(paymentId);
    }
}
