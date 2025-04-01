package com.example.rewards.service;


import com.example.rewards.entity.Payment;
import com.example.rewards.entity.Reward;

import java.util.Optional;

public interface RewardsInterfaceService {
    Optional<Reward> fetchRewardBalance(String customerId);
    Reward saveRewardInformation(Reward reward);
    Payment fetchPaymentTransactionStatus(Payment payment);
}
