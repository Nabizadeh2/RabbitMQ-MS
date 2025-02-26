package com.atl23.productapp.mapper;

import com.atl23.productapp.dao.ProductEntity;
import com.atl23.productapp.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductDto toDto(ProductEntity productEntity);

    ProductEntity toEntity(ProductDto productDto);

}
