package com.materials.io.producer;

import com.materials.io.repository.CreditCardTransactionRepository;
import com.materials.io.model.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class CreditCardProducer {

    private static final String TOPIC = "creditcard-payment-topic-event";

    @Autowired
    private CreditCardTransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private KafkaTemplate<String, CreditCardTransaction> kafkaTemplate;

    public void processMessage(CreditCardTransaction creditCardTransaction) {
        creditCardTransaction.setState("INITIATED");
        com.materials.io.entity.CreditCardTransaction creditCardTx = modelMapper.map(creditCardTransaction, com.materials.io.entity.CreditCardTransaction.class);
        transactionRepository.save(creditCardTx);
        kafkaTemplate.send(TOPIC, creditCardTransaction);
    }


}
