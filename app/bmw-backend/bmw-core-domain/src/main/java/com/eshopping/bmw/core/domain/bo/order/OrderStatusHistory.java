package com.eshopping.bmw.core.domain.bo.order;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class OrderStatusHistory {

	private Long id;

	private final OrderStatus orderStatus;

	private LocalDate effectiveDate;

	public OrderStatusHistory(final OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
		this.effectiveDate = LocalDate.now();
	}
}
