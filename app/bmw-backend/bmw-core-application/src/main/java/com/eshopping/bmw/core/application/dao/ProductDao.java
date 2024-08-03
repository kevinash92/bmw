package com.eshopping.bmw.core.application.dao;

import java.util.List;

import com.eshopping.bmw.core.application.bo.PagedResponse;
import com.eshopping.bmw.core.domain.bo.common.Product;

public interface ProductDao {

	Product findProductById(Long productId);

	List<Product> findAllProducts();

	Boolean isProductExistsById(Long productId);

	Long createProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Long productId);

	PagedResponse<Product> findProducts(String searchTerm, int page, int size, int order, String[] properties);
}
