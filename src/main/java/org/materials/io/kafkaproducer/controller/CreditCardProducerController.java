package org.materials.io.kafkaproducer.controller;

import org.materials.io.kafkaproducerconsumer.model.User;
import org.materials.io.kafkaproducer.producer.CreditCardProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CreditCardProducerController {

    @Autowired
    private CreditCardProducer creditCardProducer;

    @GetMapping("/publish/{name}")
    public String postMessage(@PathVariable("name") final String name){
        User user = new User();
        user.setName(name);
        user.setDepartment("Technology");
        user.setSalary(4000000L);
        creditCardProducer.processMessage(user);
        return "Message Published Successfully";
    }

    @GetMapping("/msg")
    public String message() {
        return "Message Published Successfully";
    }
}
