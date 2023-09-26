package com.github.bepo.productservice.core.useCase.product;

import com.github.bepo.productservice.core.dto.ProductDTO;

public interface SaveProductUseCase {
    void save(ProductDTO productDTO);
}
