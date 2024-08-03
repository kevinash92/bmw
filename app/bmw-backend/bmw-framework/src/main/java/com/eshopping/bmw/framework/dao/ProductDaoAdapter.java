package com.eshopping.bmw.framework.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.eshopping.bmw.core.application.bo.PagedResponse;
import com.eshopping.bmw.core.application.dao.ProductDao;
import com.eshopping.bmw.core.application.exception.ProductNotFoundException;
import com.eshopping.bmw.core.domain.bo.common.Product;
import com.eshopping.bmw.framework.entity.ProductEntity;
import com.eshopping.bmw.framework.mapper.ProductMapper;
import com.eshopping.bmw.framework.repository.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductDaoAdapter implements ProductDao {

	private final ProductRepository productRepository;

	private final ProductMapper productMapper;

	private final EntityManager entityManager;

	@Override
	public Product findProductById(final Long productId) {
		ProductEntity product = productRepository.findById(productId).orElse(null);
		return productMapper.toProduct(product);
	}

	@Override
	public List<Product> findAllProducts() {
		List<ProductEntity> productEntities = productRepository.findAll();
		return productMapper.toProducts(productEntities);
	}

	@Override
	public Boolean isProductExistsById(final Long productId) {
		return productRepository.existsById(productId);
	}

	@Override
	public Long createProduct(final Product product) {
		ProductEntity productEntity = productMapper.toProductEntity(product);
		return productRepository.save(productEntity).getId();
	}

	@Override
	public void updateProduct(final Product product) {
		ProductEntity productEntity = productRepository.findById(product.getId())
				.orElseThrow(() -> new ProductNotFoundException(product.getId()));
		productMapper.updateEntityFromProduct(product, productEntity);
		productRepository.save(productEntity);
	}

	@Override
	public void deleteProduct(final Long productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public PagedResponse<Product> findProducts(final String searchTerm, final int page, final int size, final int order,
			final String[] properties) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
		Root<ProductEntity> productRoot = cq.from(ProductEntity.class);

		List<Predicate> predicates = buildSearchPredicates(cb, productRoot, searchTerm);

		cq.where(predicates.toArray(new Predicate[0]));

		// sort order
		if (properties == null || properties.length > 0) {
			List<Order> sortOrders = new ArrayList<>();

			for (String property : properties) {
				Order sortOrder = cb.asc(productRoot.get(property));
				if (order != -1) {
					sortOrder = cb.desc(productRoot.get(property));
				}
				sortOrders.add(sortOrder);
			}
			cq.orderBy(sortOrders);
		}

		// prepare paged response
		TypedQuery<ProductEntity> searchQuery = entityManager.createQuery(cq);
		long totalElements = searchQuery.getResultStream().count();
		List<ProductEntity> results = searchQuery //
				.setMaxResults(size) //
				.setFirstResult(page * size) //
				.getResultList();

		int totalPages = countPages(totalElements, size);
		boolean lastPage = isLast(page, totalPages);

		return new PagedResponse<>(productMapper.toProducts(results), //
				page + 1, //
				results.size(), //
				totalElements, //
				totalPages, //
				lastPage);
	}

	private List<Predicate> buildSearchPredicates(final CriteriaBuilder criteriaBuilder, final Root<ProductEntity> root,
			final String searchTerm) {

		List<Predicate> predicates = new ArrayList<>();

		// query filter by name and description
		if (StringUtils.isNotBlank(searchTerm)) {

			String normalizedSearchTerm = normalizeSearchTerm(searchTerm);

			Predicate likeNamePredicate = criteriaBuilder
					.like(normalizeExpression(criteriaBuilder, root, "productName"), normalizedSearchTerm);
			Predicate likeDescPredicate = criteriaBuilder
					.like(normalizeExpression(criteriaBuilder, root, "description"), normalizedSearchTerm);

			predicates.add(criteriaBuilder.or(likeNamePredicate, likeDescPredicate));
		}

		return predicates;
	}

	private static String normalizeSearchTerm(final String searchTerm) {

		return "%" + searchTerm.toLowerCase()//
				.replaceAll("[àáâãäå]", "a")//
				.replaceAll("[èéêë]", "e")//
				.replaceAll("[ìíîï]", "i")//
				.replaceAll("[òóôõö]", "o")//
				.replaceAll("[ùúûü]", "u")//
				.replaceAll("[ýÿ]", "y")//
				.replaceAll("[ç]", "c") + "%";
	}

	private static Expression<String> normalizeExpression(final CriteriaBuilder cb, final Root<ProductEntity> root,
			final String field) {
		return cb.function("unaccent", String.class, cb.lower(root.get(field)));
	}

	private int countPages(final long totalElements, final double size) {
		return (int) Math.ceil(totalElements / size);
	}

	private boolean isLast(final int page, final int totalPages) {
		return page + 1 >= totalPages;
	}
}
