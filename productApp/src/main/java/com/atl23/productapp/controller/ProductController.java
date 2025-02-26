package com.atl23.productapp.controller;

import com.atl23.productapp.dto.ProductDto;
import com.atl23.productapp.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductDto customerDto) {
        productService.createProduct(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    // @GetMapping("/findAll")
    // public ResponseEntity<List<CustomerDto>>findAll(){
    //     return ResponseEntity.status(HttpStatus.OK).body(customerService.findAllCustomers());
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id,
                                              @Valid @RequestBody ProductDto customerDto) {
        productService.updateProduct(id, customerDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{productId}")
    public ResponseEntity<Void> decreaseCount(@PathVariable Long productId,
                                              @RequestParam Integer count){
        productService.decreaseCount(productId, count);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> increaseCount(@PathVariable Long id,
                                              @RequestParam Integer count) {
        productService.increaseCount(id, count);
        return ResponseEntity.ok().build();
    }

}
