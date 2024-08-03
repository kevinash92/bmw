package com.eshopping.bmw.core.domain.bo.order;

import lombok.Getter;

@Getter
public enum OrderStatus {

	ORDERED("ordered"),
	PROCESSED("processed"),
	DELIVERED("delivered"),
	REFUNDED("refunded"),
	CANCELED("canceled");

	private String value;

	private OrderStatus(final String status) {
		this.value = status;
	}
}
