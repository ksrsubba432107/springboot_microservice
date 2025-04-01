package com.example.rewards.repository;

import com.example.rewards.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RewardRepository  extends JpaRepository<Reward, Integer> {
    @Query("SELECT e FROM Reward e WHERE e.customerId = :customerId")
    Optional<Reward> findByCustomeId(String customerId);
}
