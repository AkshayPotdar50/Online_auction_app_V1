package com.example.auction.app.ver1.service;

import com.example.auction.app.ver1.model.Bid;
import com.example.auction.app.ver1.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidService{

    @Autowired
    private BidRepository bidRepository;


    @Override
    public Bid placeBid(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public Bid updateBid(Long id, Bid bid) {
        bid.setId(id);
        return bidRepository.save(bid);
    }

    @Override
    public void deleteBid(Long id) {
       bidRepository.deleteById(id);
        System.out.println("bid deleted successfully");
    }

    @Override
    public Optional<Bid> getBidById(Long id) {
        return bidRepository.findById(id);
    }

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }
}
