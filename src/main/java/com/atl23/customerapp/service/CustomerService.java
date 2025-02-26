package com.atl23.customerapp.service;

import com.atl23.customerapp.dto.CustomerBalanceDto;
import com.atl23.customerapp.dto.CustomerDto;

import java.math.BigDecimal;

public interface CustomerService {

    void createCustomer(CustomerDto customer);

    CustomerDto findById(Long id);

    void updateCustomer(Long id, CustomerDto customerDto);

    void deleteCustomer(Long id);

    void decreaseBalance(Long customerId, BigDecimal price);
    CustomerBalanceDto getbalance(CustomerBalanceDto dto);

}
