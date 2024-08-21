package com.materials.io.controller;

import com.materials.io.model.CreditCardTransaction;
import com.materials.io.producer.CreditCardProducer;
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

    @GetMapping("/home/secured")
    public String message() {
        return "Secured end point";
    }
}
