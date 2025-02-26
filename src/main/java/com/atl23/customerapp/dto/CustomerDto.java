package com.atl23.customerapp.dto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CustomerDto {

    private Long id;
    private String fullName;
    private Integer age;
    private String pin;
    private BigDecimal balance;

}
