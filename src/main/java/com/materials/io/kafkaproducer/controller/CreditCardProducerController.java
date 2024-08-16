package com.materials.io.kafkaproducer.controller;

import com.materials.io.kafkaproducerconsumer.model.CreditCardTransaction;
import com.materials.io.kafkaproducer.producer.CreditCardProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class CreditCardProducerController {

    @Autowired
    private CreditCardProducer creditCardProducer;

    @GetMapping("/publish/{amount}")
    public String postMessage(@PathVariable("amount") final Double amount){
        CreditCardTransaction creditCardTransaction = new CreditCardTransaction();
        creditCardTransaction.setTransactionId(UUID.randomUUID().toString());
        creditCardTransaction.setCardNumber(new BigInteger("12345667788533"));
        creditCardTransaction.setMerchantId("supermarket-NCR-17894");
        creditCardTransaction.setAmount(amount);
        creditCardProducer.processMessage(creditCardTransaction);
        return "Message Published Successfully";
    }

    @GetMapping("/msg")
    public String message() {
        return "Message Published Successfully";
    }
}
