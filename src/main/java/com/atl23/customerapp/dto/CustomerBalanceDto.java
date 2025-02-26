package com.atl23.customerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Component
public class CustomerBalanceDto {
    private BigDecimal balance;
}
