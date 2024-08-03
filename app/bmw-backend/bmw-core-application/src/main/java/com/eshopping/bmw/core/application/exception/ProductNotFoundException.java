package com.eshopping.bmw.core.application.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProductNotFoundException extends AbstractNotFoundException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(final Long productId) {
		super(String.format("Product[id=%d] not found", productId));
	}

}
