package com.eshopping.bmw.core.application.usecase;

import com.eshopping.bmw.core.domain.bo.cart.Cart;
import com.eshopping.bmw.core.domain.bo.common.Product;

public interface CartService {

	/**
	 * Add or remove product in cart depending on the quantity.
	 * if quantity < 0 then we remove products
	 * if quantity > 0 then we add  products
	 * if quantity = 0 do nothing
	 * @param cart
	 * @param product
	 * @param quantity
	 */
	void updateProductInCart(Cart cart, Product product, int quantity);

	Cart retrieveCartById(Long cartId);
}
