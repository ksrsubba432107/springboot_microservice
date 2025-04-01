package com.example.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService implements PaymentInterface {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment savePayment(Payment payment) {
		Payment savePayment = paymentRepository.save(payment);
		log.info("payment saved into database");
		return savePayment;
	}

	@Override
	public Optional<Payment> getPaymentStatus(String cardNumber) {
		Optional<Payment> result = paymentRepository.findByStatus(cardNumber);
		log.info("payment status:"+result);
		return result;
	}

}
