package com.eshopping.bmw.core.domain.bo.customer;

import lombok.Getter;

@Getter
public enum CustomerGender {
	M("male"),
	F("female");

	private String value;

	private CustomerGender(final String value) {
		this.value = value;
	}

}
