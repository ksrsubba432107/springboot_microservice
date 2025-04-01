package com.example.payment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.entity.Payment;
import com.example.payment.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping(value = "/create", consumes = "application/json")
	public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
		try {
			Payment result = paymentService.savePayment(payment);
			log.info("payment accepted");
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			log.error("error occured while saving into db"+e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getStatus/{cardNumber}")
	public ResponseEntity<Payment> fetchStatus(@PathVariable String cardNumber) {
		Optional<Payment> payment = paymentService.getPaymentStatus(cardNumber);
		log.info("payment status checking ");
		return payment.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
