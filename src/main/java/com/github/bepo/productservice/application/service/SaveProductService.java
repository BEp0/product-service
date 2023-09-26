package com.github.bepo.productservice.application.service;

import com.github.bepo.productservice.application.validations.ProductValidation;
import com.github.bepo.productservice.core.dto.ProductDTO;
import com.github.bepo.productservice.core.service.PersistProductService;
import com.github.bepo.productservice.core.useCase.SaveProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductService implements SaveProduct {

    private final PersistProductService persistProductService;

    @Override
    public void save(ProductDTO productDTO) {
        ProductValidation.fullValidationDTO(productDTO);
        persistProductService.persistProduct(productDTO);
    }
}
