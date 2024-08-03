package com.eshopping.bmw.core.domain.bo.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.eshopping.bmw.core.domain.utils.IdUtils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Order {

	private Long id;

	private Long customerId;

	private BigDecimal total;

	private String orderNo;

	private List<OrderItem> orderItems = new ArrayList<>();

	@Getter(value = AccessLevel.NONE)
	private List<OrderStatusHistory> statusHistory = new ArrayList<>();

	public Order(final Long customerId, final List<OrderItem> orderItems) {
		this.id = IdUtils.randomId();
		this.customerId = customerId;
		this.orderItems = orderItems;
		updateOrderTotal();
	}

	public void complete() {
		changeStatus(OrderStatus.ORDERED);
	}

	public void process() {
		changeStatus(OrderStatus.PROCESSED);
	}

	public void deliver() {
		changeStatus(OrderStatus.DELIVERED);
	}

	public void cancel() {
		changeStatus(OrderStatus.CANCELED);
	}

	public void refund() {
		changeStatus(OrderStatus.REFUNDED);
	}

	public List<OrderStatusHistory> getStatusHistory() {
		return Collections.unmodifiableList(statusHistory);
	}

	private void changeStatus(final OrderStatus status) {
		statusHistory.add(new OrderStatusHistory(status));
	}

	private void updateOrderTotal() {
		this.total = orderItems.stream()
				.map(item -> item.getProductPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
