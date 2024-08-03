package com.eshopping.bmw.core.domain.bo.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.eshopping.bmw.core.domain.bo.common.Product;
import com.eshopping.bmw.core.domain.bo.order.OrderItem;
import com.eshopping.bmw.core.domain.utils.ReflectionUtils;

class CartTest {

	@Test
	void testAddItem() {
		// Given
		Cart cart = new Cart(1L);
		Product product = new Product();
		product.setId(1L);
		product.setName("Iphone 15 pro max");
		product.setPrice(new BigDecimal("999.99"));

		// When
		cart.addItem(product, 1);
		// Then
		assertEquals(new BigDecimal("999.99"), cart.getTotal(), "Total should be 999.99");
		assertEquals(1, cart.getOrderItems().size(), "Cart should have 1 item");
	}

	@Test
	void testRemoveItem() throws Exception {
		// Given
		Cart cart = new Cart(1L);
		Product iphoneProduct = new Product();
		iphoneProduct.setId(1L);
		iphoneProduct.setName("Iphone 15 pro max");
		iphoneProduct.setPrice(new BigDecimal("1000"));

		Product ps5Product = new Product();
		ps5Product.setId(2L);
		ps5Product.setName("Iphone 15 pro max");
		ps5Product.setPrice(new BigDecimal("500"));

		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(new OrderItem(ps5Product));
		orderItems.add(new OrderItem(iphoneProduct, 2));

		ReflectionUtils.setPrivateProperty(cart, "orderItems", orderItems);
		ReflectionUtils.setPrivateProperty(cart, "total", new BigDecimal("2500"));

		// When
		cart.removeItem(iphoneProduct, 2);
		// Then
		assertEquals(new BigDecimal("500"), cart.getTotal(), "Total should be 1500");
		assertEquals(1, cart.getOrderItems().size(), "Cart should have 1 item");
		assertEquals("Iphone 15 pro max", cart.getOrderItems().get(0).getProductName(), "The product name should be 'Iphone 15 pro max'");
	}

}
