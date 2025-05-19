package com.example.auction.app.ver1.controller;

import com.example.auction.app.ver1.model.Payment;
import com.example.auction.app.ver1.service.PaymentService;
import com.example.auction.app.ver1.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentServiceImpl service;

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment p) {
        return ResponseEntity.ok(service.makePayment(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment p) {
        return ResponseEntity.ok(service.updatePayment(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable Long id) {
        return service.getPaymentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        return ResponseEntity.ok(service.getAllPayments());
    }
}
