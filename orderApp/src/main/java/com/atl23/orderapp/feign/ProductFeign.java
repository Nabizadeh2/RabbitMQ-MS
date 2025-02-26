package com.atl23.orderapp.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-client", url = "http://localhost:8083/product-app/api/v1/products")
public interface ProductFeign {

    @PostMapping("/{productId}")
    void decreaseCount(@PathVariable Long productId, @RequestParam Integer count);
}
