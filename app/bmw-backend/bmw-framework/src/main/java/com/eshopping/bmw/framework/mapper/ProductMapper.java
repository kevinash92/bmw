package com.eshopping.bmw.framework.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.eshopping.bmw.core.application.bo.PagedResponse;
import com.eshopping.bmw.core.domain.bo.common.Product;
import com.eshopping.bmw.framework.entity.ProductEntity;
import com.eshopping.bmw.framework.rest.dto.ProductDto;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	@Mapping(target = "name", source = "productName")
	Product toProduct(ProductEntity productEntity);

	@Mapping(target = "productName", source = "name")
	ProductEntity toProductEntity(Product product);

	List<Product> toProducts(List<ProductEntity> productEntities);

	ProductDto toProductDto(Product product);

	Product toProduct(ProductDto productDto);

	@Mapping(target = "productName", source = "name")
	void updateEntityFromProduct(Product product, @MappingTarget ProductEntity productEntity);

	PagedResponse<ProductDto> toProductPagedResponseDto(PagedResponse<Product> responses);
}
