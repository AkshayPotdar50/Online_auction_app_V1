package com.example.auction.app.ver1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private LocalDateTime bidTime;

    @ManyToOne
    @JoinColumn(name = "bidder_id")
    private User bidder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
