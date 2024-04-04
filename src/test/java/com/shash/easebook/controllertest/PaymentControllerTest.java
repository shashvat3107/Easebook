package com.shash.easebook.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

import com.shash.easebook.controller.PaymentController;
import com.shash.easebook.dto.PaymentDTO;
import com.shash.easebook.dto.PaymentResponseDTO;
import com.shash.easebook.entities.Payment;
import com.shash.easebook.service.PaymentService;

class PaymentControllerTest {

	@Mock
	private PaymentService paymentService;

	@InjectMocks
	private PaymentController paymentController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testCreatePayment_Positive() {
		// Mock data
//        PaymentDTO paymentDTO = new PaymentDTO(/* initialize PaymentDTO object */);
//        PaymentResponseDTO createdPayment = new PaymentResponseDTO(/* initialize PaymentResponseDTO object */);
		Payment payment = new Payment(/* initialize PaymentDTO object */);
		Payment createdPayment = new Payment(/* initialize PaymentResponseDTO object */);
		when(paymentService.createPayment(payment)).thenReturn(createdPayment);

		// Call controller method
		ResponseEntity<Payment> responseEntity = paymentController.createPayment(payment);

		// Verify response status and body
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(createdPayment, responseEntity.getBody());
	}

	@Test
	void testCreatePayment_Negative() {
		// Mock data
		Payment payment = new Payment(/* initialize PaymentDTO object */);
		when(paymentService.createPayment(payment)).thenReturn(null);

		// Call controller method
		ResponseEntity<Payment> responseEntity = paymentController.createPayment(payment);

		// Verify response status
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}

	@Test
	void testGetAllPayments() {
		// Mock data
		List<Payment> paymentList = new ArrayList<>();
		when(paymentService.getAllPayments()).thenReturn(paymentList);

		// Call controller method
		ResponseEntity<List<Payment>> responseEntity = paymentController.getAllPayments();

		// Verify response status and body
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(paymentList, responseEntity.getBody());
	}

	@Test
	void testGetPaymentById_Positive() {
		// Mock data
		Long paymentId = 1L;
		Payment paymentResponse = new Payment(/* initialize PaymentResponseDTO object */);
		when(paymentService.getPaymentById(paymentId)).thenReturn(paymentResponse);

		// Call controller method
		ResponseEntity<Payment> responseEntity = paymentController.getPaymentById(paymentId);

		// Verify response status and body
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(paymentResponse, responseEntity.getBody());
	}

	@Test
	void testGetPaymentById_Negative() {
		// Mock data
		Long paymentId = 1L;
		when(paymentService.getPaymentById(paymentId)).thenReturn(null);

		// Call controller method
		ResponseEntity<Payment> responseEntity = paymentController.getPaymentById(paymentId);

		// Verify response status
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	void testGetPaymentsByUserId() {
		// Mock data
		Long userId = 1L;
		List<Payment> paymentList = new ArrayList<>();
		when(paymentService.getPaymentsByUserId(userId)).thenReturn(paymentList);

		// Call controller method
		ResponseEntity<List<Payment>> responseEntity = paymentController.getPaymentsByUserId(userId);

		// Verify response status and body
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(paymentList, responseEntity.getBody());
	}

	@Test
	void testGetPaymentsByAdId() {
		// Mock data
		Long adId = 1L;
		List<Payment> paymentList = new ArrayList<>();
		when(paymentService.getPaymentsByAdId(adId)).thenReturn(paymentList);

		// Call controller method
		ResponseEntity<List<Payment>> responseEntity = paymentController.getPaymentsByAdId(adId);

		// Verify response status and body
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(paymentList, responseEntity.getBody());
	}

	@Test
	void testDeletePayment() {
		// Mock data
		Long paymentId = 1L;

		// Call controller method
		ResponseEntity<Void> responseEntity = paymentController.deletePayment(paymentId);

		// Verify response status
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
		// Add additional assertions if needed
	}
}
