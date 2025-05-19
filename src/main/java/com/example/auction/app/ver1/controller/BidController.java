package com.example.auction.app.ver1.controller;

import com.example.auction.app.ver1.model.Bid;
import com.example.auction.app.ver1.service.BidService;
import com.example.auction.app.ver1.service.BidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {
    @Autowired
    private BidServiceImpl service;

    @PostMapping
    public ResponseEntity<Bid> create(@RequestBody Bid b) {
        return ResponseEntity.ok(service.placeBid(b));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bid> update(@PathVariable Long id, @RequestBody Bid b) {
        return ResponseEntity.ok(service.updateBid(id, b));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteBid(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bid> getById(@PathVariable Long id) {
        return service.getBidById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Bid>> getAll() {
        return ResponseEntity.ok(service.getAllBids());
    }
}

