package com.paymentService.paymentGateway.services;

import com.paymentService.paymentGateway.models.PaymentStatus;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Component;

@Component
public interface PaymentGateway {
    String createLink(String orderId, String customerName, String phoneNumber, float amount);
    PaymentStatus getStatus(String paymentId) throws RazorpayException;
}
