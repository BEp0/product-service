package com.github.bepo.productservice.core.service;

import com.github.bepo.productservice.core.domain.Product;
import com.github.bepo.productservice.core.domain.ProductAttribute;
import com.github.bepo.productservice.core.dto.ProductDTO;
import com.github.bepo.productservice.core.repository.ProductAttributeRepository;
import com.github.bepo.productservice.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PersistProductService {

    private final ProductRepository productRepository;
    private final ProductAttributeRepository productAttributeRepository;

    @Transactional
    public void persistProduct(ProductDTO productDTO) {
        var product = getProduct(productDTO);
        var attribute = getAttribute(productDTO, product);

        product.setAttributes(attribute);

        productRepository.save(product);
        productAttributeRepository.save(attribute);
    }

    private Product getProduct(ProductDTO productDTO) {
        if (productRepository.existsBySku(productDTO.sku()))
            return productRepository.findProductBySku(productDTO.sku());
        return new Product(null, productDTO.sku(), null);
    }

    private ProductAttribute getAttribute(ProductDTO productDTO, Product product) {
        if (productAttributeRepository.existsByStoreAndProduct_Sku(productDTO.store(), productDTO.sku())) {
            var attribute = productAttributeRepository.findProductAttributeByStoreAndSku(productDTO.store(), productDTO.sku());
            attribute.setPrice(productDTO.price());
            attribute.setQuantity(productDTO.quantity());
            attribute.setAvailable(productDTO.available());
            return attribute;
        }
        return new ProductAttribute(null,
                product,
                productDTO.price(),
                productDTO.store(),
                productDTO.quantity(),
                productDTO.available()
        );
    }
}
