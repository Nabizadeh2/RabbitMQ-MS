package com.atl23.customerapp.mapper;

import com.atl23.customerapp.dao.CustomerEntity;
import com.atl23.customerapp.dto.CustomerBalanceDto;
import com.atl23.customerapp.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerDto toDto(CustomerEntity customerEntity);
    CustomerEntity toEntity(CustomerDto customerDto);
    CustomerEntity toEntity(CustomerBalanceDto customerBalanceDto);
    CustomerBalanceDto toDto1(CustomerEntity customerEntity);
}
