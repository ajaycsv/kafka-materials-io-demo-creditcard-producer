package com.materials.io.kafkaproducer.producer;

import com.materials.io.kafkaproducer.repository.CreditCardTransactionRepository;
import com.materials.io.kafkaproducerconsumer.model.CreditCardTransaction;
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
        com.materials.io.kafkaproducer.entity.CreditCardTransaction creditCardTx = modelMapper.map(creditCardTransaction, com.materials.io.kafkaproducer.entity.CreditCardTransaction.class);
        transactionRepository.save(creditCardTx);
        kafkaTemplate.send(TOPIC, creditCardTransaction);
    }


}
