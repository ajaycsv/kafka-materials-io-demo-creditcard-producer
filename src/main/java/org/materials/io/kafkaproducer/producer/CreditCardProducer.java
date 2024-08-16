package org.materials.io.kafkaproducer.producer;

import org.materials.io.kafkaproducerconsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditCardProducer {

    private static final String TOPIC = "creditcard-payment-topic-event";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void processMessage(User user) {
        kafkaTemplate.send(TOPIC, user);
    }


}
