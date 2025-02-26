package com.atl23.productapp.service.impl;

import com.atl23.productapp.dao.ProductEntity;
import com.atl23.productapp.dao.ProductRepository;
import com.atl23.productapp.dto.ProductDto;
import com.atl23.productapp.exception.ProductNotFoundException;
import com.atl23.productapp.mapper.ProductMapper;
import com.atl23.productapp.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcutServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void createProduct(ProductDto productDto) {

        productRepository.save(productMapper.toEntity(productDto));
    }

    @Override
    public ProductDto findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException("product not found with id" + id));
    }

    @Override
    @Transactional
    public void updateProduct(Long id, ProductDto productDto) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product not found with id" + id));

        productEntity.setCount(productEntity.getCount());
        productEntity.setName(productEntity.getName());
        productEntity.setPrice(productEntity.getPrice());

        productRepository.save(productEntity);
    }

    @Override
    public void increaseCount(Long id, Integer count) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product not found with id" + id));

        productEntity.setCount(productEntity.getCount() + count);
        productRepository.save(productEntity);
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {

        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void decreaseCount(Long productId, Integer count) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("product not found with id" + productId));

        productEntity.setCount(productEntity.getCount() - count);
        productRepository.save(productEntity);
    }

}
