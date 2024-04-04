package com.shash.easebook.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shash.easebook.entities.Payment;
import com.shash.easebook.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	private final PaymentService paymentService;

//	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/create")
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		Payment createdPayment = paymentService.createPayment(payment);
		if (createdPayment != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Payment(null, null, null, null, null));
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Payment>> getAllPayments() {
		List<Payment> payments = paymentService.getAllPayments();
		return ResponseEntity.ok(payments);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
		Payment payment = paymentService.getPaymentById(id);
		if (payment != null) {
			return ResponseEntity.ok(payment);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Payment>> getPaymentsByUserId(@PathVariable Long userId) {
		List<Payment> payments = paymentService.getPaymentsByUserId(userId);
		return ResponseEntity.ok(payments);
	}

	@GetMapping("/ad/{adId}")
	public ResponseEntity<List<Payment>> getPaymentsByAdId(@PathVariable Long adId) {
		List<Payment> payments = paymentService.getPaymentsByAdId(adId);
		return ResponseEntity.ok(payments);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
		paymentService.deletePayment(id);
		return ResponseEntity.noContent().build();
	}
}