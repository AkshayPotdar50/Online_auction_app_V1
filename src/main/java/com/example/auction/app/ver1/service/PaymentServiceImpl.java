package com.example.auction.app.ver1.service;

import com.example.auction.app.ver1.model.Payment;
import com.example.auction.app.ver1.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository repository;

    @Override
    public Payment makePayment(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        payment.setId(id);
        return repository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
       repository.deleteById(id);
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return repository.findAll();
    }
}
