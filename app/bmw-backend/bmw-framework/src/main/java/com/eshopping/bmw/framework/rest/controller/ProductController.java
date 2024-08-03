package com.eshopping.bmw.framework.rest.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eshopping.bmw.core.application.bo.PagedResponse;
import com.eshopping.bmw.core.application.exception.ProductNotFoundException;
import com.eshopping.bmw.core.application.usecase.ProductService;
import com.eshopping.bmw.core.domain.bo.common.Product;
import com.eshopping.bmw.framework.mapper.ProductMapper;
import com.eshopping.bmw.framework.rest.api.ProductRestApi;
import com.eshopping.bmw.framework.rest.dto.ProductDto;
import com.eshopping.bmw.framework.rest.helpers.RequestParamConstants;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Transactional
public class ProductController implements ProductRestApi {

	private final ProductService productService;

	private final ProductMapper productMapper;

	@GetMapping("/products/{productId}")
	@Override
	public ResponseEntity<ProductDto> getProductById(@NotNull final @PathVariable("productId") Long productId) {
		Product product = productService.retrieveProductById(productId);
		if (product == null) {
			throw new ProductNotFoundException(productId);
		}
		return ResponseEntity.ok().body(productMapper.toProductDto(product));
	}

	@GetMapping("/products")
	@Override
	public ResponseEntity<PagedResponse<ProductDto>> searchProducts(
			@RequestParam(value = "searchTerm", defaultValue = "") final String searchTerm,
			@RequestParam(value = "page", defaultValue = RequestParamConstants.DEFAULT_PAGE_NUMBER) final int page,
			@RequestParam(value = "size", defaultValue = RequestParamConstants.DEFAULT_PAGE_SIZE) final int size,
			@RequestParam(value = "sort", defaultValue = RequestParamConstants.DEFAULT_SORT_ORDER) final int order,
			@RequestParam(value = "properties", defaultValue = "") final String[] properties) {
		PagedResponse<Product> responses = productService.searchProducts(searchTerm, page - 1, size, order, properties);
		return ResponseEntity.ok().body(productMapper.toProductPagedResponseDto(responses));
	}

	@PostMapping(path = "/products")
	@Override
	public ResponseEntity<String> createProduct(@Valid @RequestBody final ProductDto productDto) {
		Product product = productMapper.toProduct(productDto);
		Long productId = productService.createProduct(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()//
				.path("/{productId}")//
				.buildAndExpand(productId).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/products/{productId}")
	@Override
	public ResponseEntity<Void> updateProduct(@NotNull final @PathVariable("productId") Long productId,
			@RequestBody final ProductDto productDto) {
		Product product = productMapper.toProduct(productDto);
		productService.updateProduct(productId, product);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(path = "/products/{productId}")
	@Override
	public ResponseEntity<Void> deleteProduct(final @PathVariable("productId") Long productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.ok().build();
	}

}
