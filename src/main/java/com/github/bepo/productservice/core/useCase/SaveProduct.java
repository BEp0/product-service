package com.github.bepo.productservice.core.useCase;

import com.github.bepo.productservice.core.dto.ProductDTO;

public interface SaveProduct {
    void save(ProductDTO productDTO);
}
