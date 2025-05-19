package com.example.auction.app.ver1.service;

import com.example.auction.app.ver1.model.Auction;
import com.example.auction.app.ver1.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService{

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public Auction updateAuction(Long id, Auction auction) {
        auction.setId(id);
        return auctionRepository.save(auction);
    }

    @Override
    public void deleteAuction(Long id) {
      auctionRepository.deleteById(id);
        System.out.println("Auction deleted successfully");
    }

    @Override
    public Optional<Auction> getAuctionById(Long id) {
        return auctionRepository.findById(id);
    }

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }
}
