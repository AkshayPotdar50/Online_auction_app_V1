package com.example.auction.app.ver1.service;

import com.example.auction.app.ver1.model.Bid;

import java.util.List;
import java.util.Optional;

public interface BidService {
    Bid placeBid(Bid bid);
    Bid updateBid(Long id, Bid bid);
    void deleteBid(Long id);
    Optional<Bid> getBidById(Long id);
    List<Bid> getAllBids();
}
