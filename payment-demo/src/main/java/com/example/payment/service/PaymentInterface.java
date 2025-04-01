package com.example.payment.service;

import java.util.Optional;

import com.example.payment.entity.Payment;

public interface PaymentInterface {
	Payment savePayment(Payment payment);
	Optional<Payment> getPaymentStatus(String cardNumber);

}
