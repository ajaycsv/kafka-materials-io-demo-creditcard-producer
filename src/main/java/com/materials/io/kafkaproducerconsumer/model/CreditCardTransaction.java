package com.materials.io.kafkaproducerconsumer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
public class CreditCardTransaction {
    private String transactionId; // possiblity of alpha numeric
    private BigInteger cardNumber; // TODO: unsure card number may contain alphanumeric
    private Double amount;
    private long timeStampInMillis; // millis is for timezone computations
    private String merchantId;
}
