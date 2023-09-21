package com.github.bepo.productservice.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private Product product;

    private BigDecimal price;
    private Long store;
    private Long quantity;
    private boolean available;

}

