package com.example.auction.app.ver1;

import com.example.auction.app.ver1.model.Auction;
import com.example.auction.app.ver1.model.Product;
import com.example.auction.app.ver1.repository.AuctionRepository;
import com.example.auction.app.ver1.service.AuctionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuctionServiceImplTest {

    @Mock
    private AuctionRepository auctionRepository;

    @InjectMocks
    private AuctionServiceImpl auctionService;

    private Auction auction;
    private Product product;


    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setName("iPhone 14");
        product.setDescription("Latest Apple iPhone");
        product.setStartingPrice(new BigDecimal("900.00"));

        auction = new Auction(
                1L,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1),
                new BigDecimal("1000.00"),
                product
        );
    }

    @Test
    void testCreateAuction(){
        when(auctionRepository.save(any(Auction.class))).thenReturn(auction);

        Auction saved=auctionService.createAuction(auction);

        assertNotNull(saved);
        assertEquals(new BigDecimal("1000.00"), saved.getReservePrice());
        verify(auctionRepository, times(1)).save(auction);
    }



    @Test
    void testUpdateAuction(){
        when(auctionRepository.save(any(Auction.class))).thenReturn(auction);

        Auction updated=auctionService.updateAuction(1L, auction);

        assertNotNull(updated);
        assertEquals(1L, updated.getId());
        verify(auctionRepository, times(1)).save(auction);
    }




    @Test
    void testDeleteAuction(){
        doNothing().when(auctionRepository).deleteById(1L);

        auctionService.deleteAuction(1L);

        verify(auctionRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetAuctionById() {
        when(auctionRepository.findById(1L)).thenReturn(Optional.of(auction));

        Optional<Auction> found = auctionService.getAuctionById(1L);

        assertTrue(found.isPresent());
        assertEquals("iPhone 14", found.get().getProduct().getName());
        verify(auctionRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllAuctions() {
        Auction auction2 = new Auction(2L, LocalDateTime.now(), LocalDateTime.now().plusDays(1),
                new BigDecimal("2000.00"), product);

        when(auctionRepository.findAll()).thenReturn(Arrays.asList(auction, auction2));

        List<Auction> auctions = auctionService.getAllAuctions();

        assertEquals(2, auctions.size());
        verify(auctionRepository, times(1)).findAll();
    }
}
