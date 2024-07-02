package com.paymentService.paymentGateway.services;

import com.paymentService.paymentGateway.models.PaymentStatus;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentGateway paymentGateway;

    public String createPaymentLink(String orderId){
        return paymentGateway.createLink(orderId, "Ghost", "9999999999", 1000);
    }

    public PaymentStatus getStatus(String orderId) throws RazorpayException {
        return this.paymentGateway.getStatus(orderId);
    }

}
