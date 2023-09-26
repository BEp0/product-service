package com.github.bepo.productservice.core.gateway;

import com.github.bepo.productservice.core.domain.Product;

public interface DefaultGateway <T, I> {

    Product findById(I id);
    void save(T data);

}
