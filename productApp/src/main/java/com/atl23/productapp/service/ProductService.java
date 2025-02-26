package com.atl23.productapp.service;

import com.atl23.productapp.dto.ProductDto;

public interface ProductService {

    void createProduct(ProductDto productDto);

    ProductDto findById(Long id);

    void updateProduct(Long id, ProductDto productDto);

    void increaseCount(Long id, Integer count);

    void deleteProduct(long id);

    void decreaseCount(Long productId, Integer count);

}
