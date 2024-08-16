package com.materials.io.kafkaproducer.producer;

import com.materials.io.kafkaproducerconsumer.model.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditCardProducer {

    private static final String TOPIC = "creditcard-payment-topic-event";

    @Autowired
    private KafkaTemplate<String, CreditCardTransaction> kafkaTemplate;

    public void processMessage(CreditCardTransaction creditCardTransaction) {
        kafkaTemplate.send(TOPIC, creditCardTransaction);
    }


}
