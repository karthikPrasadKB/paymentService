package com.paymentService.paymentGateway.services;

import org.springframework.stereotype.Component;

@Component
public interface PaymentGateway {
    String createLink(String orderId, String customerName, String phoneNumber, float amount);
}
