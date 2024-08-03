package com.eshopping.bmw.framework.rest.api;

import org.springframework.http.ResponseEntity;

import com.eshopping.bmw.core.application.bo.PagedResponse;
import com.eshopping.bmw.core.domain.bo.common.Product;
import com.eshopping.bmw.framework.rest.dto.ApiResponseDto;
import com.eshopping.bmw.framework.rest.dto.ProductDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Tag(name = "Product API", description = "Product display and management resource")
public interface ProductRestApi {

	@Operation(operationId = "getProductById", summary = "Get a product by id", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
			@ApiResponse(responseCode = "404", description = "No product found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDto.class)) }) })
	ResponseEntity<ProductDto> getProductById(@NotNull Long productId);

	@Operation(operationId = "searchProducts", summary = "Search products", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PagedResponse.class)) }),
			@ApiResponse(responseCode = "404", description = "No products found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDto.class)) }) })
	ResponseEntity<PagedResponse<ProductDto>> searchProducts(String searchTerm, @Min(1) int page, @Min(1) int size,
			int order, String[] properties);

	@Operation(operationId = "createProduct", summary = "Create product", responses = {
			@ApiResponse(responseCode = "201", description = "Created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }) })
	ResponseEntity<String> createProduct(@Valid ProductDto productDto);

	@Operation(operationId = "updateProduct", summary = "Update product", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)) }) })
	ResponseEntity<Void> updateProduct(@NotNull Long productId, ProductDto productDto);

	@Operation(operationId = "deleteProduct", summary = "Delete product", responses = {
			@ApiResponse(responseCode = "200", description = "OK", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)) }) })
	ResponseEntity<Void> deleteProduct(Long productId);
}
