package com.eshopping.bmw.core.application.services;

import org.springframework.stereotype.Service;

import com.eshopping.bmw.core.application.dao.CartDao;
import com.eshopping.bmw.core.application.usecase.CartService;
import com.eshopping.bmw.core.domain.bo.cart.Cart;
import com.eshopping.bmw.core.domain.bo.common.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

	private final CartDao cartDao;

	@Override
	public void updateProductInCart(final Cart cart, final Product product, final int quantity) {

		if (quantity == 0) {
			return;
		}

		if (quantity > 0) {
			cart.addItem(product, quantity);
		} else {
			cart.removeItem(product, quantity);
		}
		cartDao.saveCart(cart);
	}

	@Override
	public Cart retrieveCartById(final Long cartId) {
		return cartDao.findCartById(cartId);
	}

}
