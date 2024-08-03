package com.eshopping.bmw.core.domain.bo.order;

import java.math.BigDecimal;

import com.eshopping.bmw.core.domain.bo.common.Product;
import com.eshopping.bmw.core.domain.utils.IdUtils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = {"product"})
public class OrderItem {

	private Long id;

	private Product product;

	private String productName;

	private BigDecimal productPrice;

	@Setter
	private Integer quantity;

	public OrderItem(final Product product) {
		this(product, 1);
	}

	public OrderItem(final Product product, final int quantity) {
		this.id = IdUtils.randomId();
		this.quantity = quantity;
		this.product = product;
		this.productName = product.getName();
		this.productPrice = product.getPrice();
	}
}
