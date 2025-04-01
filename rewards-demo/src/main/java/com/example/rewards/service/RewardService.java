package com.example.rewards.service;

import com.example.rewards.entity.Payment;
import com.example.rewards.entity.Reward;
import com.example.rewards.openfeign.FeignService;
import com.example.rewards.repository.RewardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RewardService implements RewardsInterfaceService{
    @Autowired
    private RewardRepository rewardRepository;
    
    @Autowired
    private FeignService feignService;

    @Override
    public Optional<Reward> fetchRewardBalance(String customerId) {
        log.info("entered RewardService - fetchRewardBalance");
    	//Optional<Reward> rwd = rewardRepository.findByCustomeId(customerId);
    	//rwd.m
        return rewardRepository.findByCustomeId(customerId);

    }

	@Override
	public Reward saveRewardInformation(Reward reward) {
		
		return rewardRepository.save(reward);
	}
	
	@Override
	public Payment fetchPaymentTransactionStatus(Payment payment) {
		Payment result = new Payment();
		try {
		result =  feignService.fetchStatus(payment.getCardNumber());
		log.info("payment fetchStatus:{} ", result);
		}
		catch(Exception e) {
			log.error(e.getMessage());
		}
		return result;
	}
}
