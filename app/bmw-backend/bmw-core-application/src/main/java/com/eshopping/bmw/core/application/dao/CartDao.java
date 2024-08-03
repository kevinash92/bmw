package com.eshopping.bmw.core.application.dao;

import com.eshopping.bmw.core.domain.bo.cart.Cart;

public interface CartDao {

	void saveCart(Cart cart);

	Cart findCartById(Long cartId);
}
