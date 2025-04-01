package com.example.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rewards.entity.Payment;
import com.example.rewards.entity.Reward;
import com.example.rewards.service.RewardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/reward")
@Slf4j
public class RewardsController {

	private final RewardService rewardService;

	@Autowired
	public RewardsController(RewardService rewardService) {
		this.rewardService = rewardService;
	}

	@GetMapping("/cust/{id}")
	public ResponseEntity<Reward> fetchBalance(@PathVariable String id) {
		log.info("entered in fetchBalance");
		return rewardService.fetchRewardBalance(id).map(ResponseEntity::ok)
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(value = "/create", consumes = "application/json")
	public ResponseEntity<Reward> createUser(@RequestBody Reward reward) {
		try {
			Reward response = rewardService.saveRewardInformation(reward);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/pay", consumes = "application/json")
	public ResponseEntity<Payment> payTransaction(@RequestBody Reward reward) {
		log.info("payTransaction calling");
		Payment payment = new Payment();
		payment.setCardNumber(reward.getCardNumber());
		try {
		Payment result =  rewardService.fetchPaymentTransactionStatus(payment);
		return new ResponseEntity<Payment>(result,HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
