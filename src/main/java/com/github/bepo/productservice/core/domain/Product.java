package com.github.bepo.productservice.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;

    @JoinColumn
    @OneToMany
    private List<ProductAttribute> attributes;

    public void setAttributes(ProductAttribute attribute) {
        if (isNull(attributes))
            attributes = new ArrayList<>();
        attributes.add(attribute);
    }

    public void setAttributes(List<ProductAttribute> attributes) {
        this.attributes = attributes;
    }
}
