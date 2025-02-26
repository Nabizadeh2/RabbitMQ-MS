package com.atl23.orderapp.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "customer-client", url = "http://localhost:8081/customer-app/api/v1/customers")
public interface CustomerFeign {

    @PostMapping("/{customerId}")
    void decreaseBalance(@PathVariable Long customerId, @RequestParam BigDecimal price);

    //  @GetMapping("/{id}")
    //  CustomerDto getCustomer(@PathVariable Long id);

}
