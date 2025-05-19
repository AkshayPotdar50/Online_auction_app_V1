package com.example.auction.app.ver1.service;

import com.example.auction.app.ver1.model.Auction;

import java.util.List;
import java.util.Optional;

public interface AuctionService {

    Auction createAuction(Auction auction);
    Auction updateAuction(Long id, Auction auction);
    void deleteAuction(Long id);
    Optional<Auction> getAuctionById(Long id);
    List<Auction> getAllAuctions();
}
