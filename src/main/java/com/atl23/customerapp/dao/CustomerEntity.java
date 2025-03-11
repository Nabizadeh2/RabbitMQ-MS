package com.atl23.customerapp.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    private Integer age;

    @Column(name = "pin", unique = true)
    private String pin;
    @Min(0)
    private BigDecimal balance;
    @Column(name = "birthday")
    private LocalDate birthday;
}
