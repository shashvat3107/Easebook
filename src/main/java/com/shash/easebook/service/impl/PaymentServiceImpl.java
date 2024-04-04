package com.shash.easebook.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shash.easebook.entities.Payment;
import com.shash.easebook.repository.PaymentRepository;
import com.shash.easebook.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	private final PaymentRepository paymentRepository;

//	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Payment createPayment(Payment payment) {
		Payment newPayment = new Payment();
		newPayment.setUserId(payment.getUserId());
		newPayment.setAdId(payment.getAdId());
		newPayment.setAmount(payment.getAmount());
		newPayment.setPaymentDate(payment.getPaymentDate());

		Payment savedPayment = paymentRepository.save(newPayment);
		return savedPayment;
	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
		return payments;
//		return payments.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public Payment getPaymentById(Long id) {
		Payment payment = paymentRepository.findById(id).orElse(null);
		return payment;
	}

	@Override
	public List<Payment> getPaymentsByUserId(Long userId) {
		List<Payment> payments = paymentRepository.findByUserId(userId);
		return payments;
//		return payments.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<Payment> getPaymentsByAdId(Long adId) {
		List<Payment> payments = paymentRepository.findByAdId(adId);
		return payments;
//		return payments.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}

//	private PaymentResponseDTO convertToDTO(Payment payment) {
//		if (payment == null) {
//			return null;
//		}
//		return new PaymentResponseDTO(payment.getId(), payment.getUserId(), payment.getAdId(), payment.getAmount(),
//				payment.getPaymentDate());
//	}
}
