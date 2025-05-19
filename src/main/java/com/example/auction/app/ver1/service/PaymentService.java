package com.example.auction.app.ver1.service;

import com.example.auction.app.ver1.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment makePayment(Payment payment);
    Payment updatePayment(Long id, Payment payment);
    void deletePayment(Long id);
    Optional<Payment> getPaymentById(Long id);
    List<Payment> getAllPayments();
}
