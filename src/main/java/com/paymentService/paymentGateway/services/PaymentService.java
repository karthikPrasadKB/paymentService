package com.paymentService.paymentGateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentGateway paymentGateway;

    public String createPaymentLink(String orderId){
        return paymentGateway.createLink(orderId, "Ghost", "9999999999", 1000);
    }

}
