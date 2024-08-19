package com.materials.io.kafkaproducer.repository;

import com.materials.io.kafkaproducer.entity.CreditCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, String> {
}
