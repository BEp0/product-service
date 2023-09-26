package com.github.bepo.productservice.core.useCase.product.impl;

import com.github.bepo.productservice.core.domain.Product;
import com.github.bepo.productservice.core.domain.ProductAttribute;
import com.github.bepo.productservice.core.dto.ProductDTO;
import com.github.bepo.productservice.core.gateway.product.ProductAttributeGateway;
import com.github.bepo.productservice.core.gateway.product.ProductGateway;
import com.github.bepo.productservice.core.useCase.product.SaveProductUseCase;
import com.github.bepo.productservice.core.useCase.product.validation.ProductValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveProductUseCaseImpl implements SaveProductUseCase {

    private final ProductGateway productGateway;
    private final ProductAttributeGateway productAttributeGateway;
    @Override
    @Transactional
    public void save(ProductDTO productDTO) {
        ProductValidation.fullValidationDTO(productDTO);
        var product = getProduct(productDTO);
        var attribute = getAttribute(productDTO, product);

        product.setAttributes(attribute);

        productGateway.save(product);
        productAttributeGateway.save(attribute);
    }

    private Product getProduct(ProductDTO productDTO) {
        if (productGateway.existsBySku(productDTO.sku()))
            return productGateway.findProductBySku(productDTO.sku());
        return new Product(null, productDTO.sku(), null);
    }

    private ProductAttribute getAttribute(ProductDTO productDTO, Product product) {
        if (productAttributeGateway.existsByStoreAndProductSku(productDTO.store(), productDTO.sku())) {
            var attribute = productAttributeGateway.findProductAttributeByStoreAndProductId(productDTO.store(), product.getId());
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
