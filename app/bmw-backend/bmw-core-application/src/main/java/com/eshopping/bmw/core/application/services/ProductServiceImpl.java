package com.eshopping.bmw.core.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshopping.bmw.core.application.bo.PagedResponse;
import com.eshopping.bmw.core.application.dao.ProductDao;
import com.eshopping.bmw.core.application.usecase.ProductService;
import com.eshopping.bmw.core.domain.bo.common.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	@Override
	public Product retrieveProductById(final Long productId) {
		return productDao.findProductById(productId);
	}

	@Override
	public List<Product> retrieveAllProducts() {
		return productDao.findAllProducts();
	}

	@Override
	public Long createProduct(final Product product) {
		return productDao.createProduct(product);
	}

	@Override
	public void updateProduct(final Long productId, final Product product) {
		product.setId(productId);
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(final Long productId) {
		productDao.deleteProduct(productId);
	}

	@Override
	public PagedResponse<Product> searchProducts(final String searchTerm, final int page, final int size,
			final int order, final String[] properties) {
		return productDao.findProducts(searchTerm, page, size, order, properties);
	}
}
