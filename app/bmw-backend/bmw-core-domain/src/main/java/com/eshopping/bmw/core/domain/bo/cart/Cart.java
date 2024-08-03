package com.eshopping.bmw.core.domain.bo.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.eshopping.bmw.core.domain.bo.common.Product;
import com.eshopping.bmw.core.domain.bo.order.OrderItem;
import com.eshopping.bmw.core.domain.utils.IdUtils;

import lombok.Getter;

@Getter
public class Cart {

	private Long id;

	private Long customerId;

	private BigDecimal total = BigDecimal.ZERO;

	private List<OrderItem> orderItems = new ArrayList<>();

	public Cart(final Long customerId) {
		this.id = IdUtils.randomId();
		this.customerId = customerId;
	}

	public void addItem(final Product product, final int quantity) {

		OrderItem orderItem = orderItems.stream()
				.filter(item -> item.getProduct().equals(product))
				.findFirst()
				.orElse(null);

		if (null != orderItem) {
			orderItem.setQuantity(orderItem.getQuantity() + quantity);
		} else {
			orderItems.add(new OrderItem(product, quantity));
		}
		updateTotal();
	}

	public void removeItem(final Product product, final int quantity) {
		int index = orderItems.indexOf(new OrderItem(product));

		if (0 > index || 0 >= quantity ) {
			return;
		}

		OrderItem orderItem = orderItems.get(index);
		int newQuantity = orderItem.getQuantity() - quantity;
		orderItem.setQuantity(newQuantity);

		if (0 >= newQuantity) {
			orderItems.remove(index);
		}
		updateTotal();
	}

	private void updateTotal() {
		this.total = orderItems.stream()
				.map(item -> item.getProductPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
