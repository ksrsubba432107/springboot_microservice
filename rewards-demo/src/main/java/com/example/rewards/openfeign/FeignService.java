package com.example.rewards.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.rewards.entity.Payment;


@FeignClient(name = "payment-service", url="http://localhost:9091/payment")
public interface FeignService {
	
	@PostMapping(value = "/create", consumes = "application/json")
	public Payment savePayment(@RequestBody Payment payment);

	@GetMapping("/getStatus/{cardNumber}")
	public Payment fetchStatus(@PathVariable String cardNumber);

}
