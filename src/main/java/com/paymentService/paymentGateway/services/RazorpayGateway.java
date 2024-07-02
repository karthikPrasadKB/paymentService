package com.paymentService.paymentGateway.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class RazorpayGateway implements PaymentGateway{

    private RazorpayClient razorpayClient;

    @Autowired
    public RazorpayGateway(RazorpayClient razorpayClient){
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String createLink(String orderId, String customerName, String phoneNumber, float amount) {
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("expire_by",1691097057);
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for orderId : " + orderId);

        JSONObject customer = new JSONObject();
        customer.put("name",customerName);
        customer.put("contact","99999999");
        customer.put("email","exampler@example.com");
        paymentLinkRequest.put("customer",customer);

        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.wikipedia.org/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = null;
        try {
            payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            throw new RuntimeException("Unable to create a payment link");
        }
        return payment.get("short_url");
    }
}
