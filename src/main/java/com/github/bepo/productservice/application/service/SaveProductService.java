package com.github.bepo.productservice.application.service;

import com.github.bepo.productservice.core.dto.ProductDTO;
import com.github.bepo.productservice.core.repository.ProductAttributeRepository;
import com.github.bepo.productservice.core.repository.ProductRepository;
import com.github.bepo.productservice.core.useCase.SaveProduct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductService implements SaveProduct {

    private final ProductRepository productRepository;
    private final ProductAttributeRepository productAttributeRepository;

    @Override
    public void save(@Valid ProductDTO productDTO) {
        // create product and attribute product
        // save both
    }
}
