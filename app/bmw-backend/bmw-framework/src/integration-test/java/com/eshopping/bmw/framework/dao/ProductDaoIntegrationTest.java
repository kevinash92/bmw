package com.eshopping.bmw.framework.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.eshopping.bmw.core.application.bo.PagedResponse;
import com.eshopping.bmw.core.application.dao.ProductDao;
import com.eshopping.bmw.core.domain.bo.common.Product;

@Sql("/sql/product.sql")
class ProductDaoIntegrationTest extends AbstractBmwIntegrationTest {

	@Autowired
	private ProductDao productDao;

	@Test
	void testFindProducts() {
		PagedResponse<Product> result = productDao.findProducts("Montre", 0, 20, 1, new String[] {});
		assertTrue(result.isLast(), "That should be the last page");
		assertEquals(1, result.getPage(), "That should be page 1");
		assertEquals(3, result.getContent().size(), "There should be 3 filtered products");
		assertEquals(3, result.getTotalElements(), "There should be 3 total products");
		assertEquals(1, result.getTotalPages(), "There should be 1 total pages");
	}
}
