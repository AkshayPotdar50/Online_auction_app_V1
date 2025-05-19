package com.example.auction.app.ver1.controller;

import com.example.auction.app.ver1.model.Auction;
import com.example.auction.app.ver1.service.AuctionService;
import com.example.auction.app.ver1.service.AuctionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {
    @Autowired
    private AuctionServiceImpl service;

    @PostMapping
    public ResponseEntity<Auction> create(@RequestBody Auction a) {
        return ResponseEntity.ok(service.createAuction(a));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auction> update(@PathVariable Long id, @RequestBody Auction a) {
        return ResponseEntity.ok(service.updateAuction(id, a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAuction(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auction> getById(@PathVariable Long id) {
        return service.getAuctionById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Auction>> getAll() {
        return ResponseEntity.ok(service.getAllAuctions());
    }
}