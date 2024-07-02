package com.paymentService.paymentGateway.controllers;

import com.paymentService.paymentGateway.models.PaymentStatus;
import com.paymentService.paymentGateway.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/createLink")
    public String createPaymentLink(@RequestParam String orderId){
        return this.paymentService.createPaymentLink(orderId);
    }

    @GetMapping("/payment/paymentStatus")
    public PaymentStatus getStatus(String orderId) throws RazorpayException {
        return this.paymentService.getStatus(orderId);
    }

}
