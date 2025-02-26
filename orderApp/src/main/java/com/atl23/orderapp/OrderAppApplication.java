package com.atl23.orderapp;

import com.atl23.orderapp.feign.CustomerFeign;
import com.atl23.orderapp.feign.ProductFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {CustomerFeign.class, ProductFeign.class})
public class OrderAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderAppApplication.class, args);
    }

}
