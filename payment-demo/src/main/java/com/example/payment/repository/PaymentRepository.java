package com.example.payment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.payment.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	
	@Query("SELECT e FROM Payment e WHERE e.cardNumber = :cardNumber")
    Optional<Payment> findByStatus(String cardNumber);

}
