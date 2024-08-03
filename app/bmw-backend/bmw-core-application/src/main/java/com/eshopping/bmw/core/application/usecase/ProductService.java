package com.eshopping.bmw.core.application.usecase;

import java.util.List;

import com.eshopping.bmw.core.application.bo.PagedResponse;
import com.eshopping.bmw.core.domain.bo.common.Product;

public interface ProductService {

	Product retrieveProductById(Long productId);

	List<Product> retrieveAllProducts();

	Long createProduct(Product product);

	void updateProduct(Long productId, Product product);

	void deleteProduct(Long productId);

	PagedResponse<Product> searchProducts(String searchTerm, int i, int size, int order, String[] properties);
}
