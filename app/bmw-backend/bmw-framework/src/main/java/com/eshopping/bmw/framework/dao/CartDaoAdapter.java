package com.eshopping.bmw.framework.dao;

import org.springframework.stereotype.Repository;

import com.eshopping.bmw.core.application.dao.CartDao;
import com.eshopping.bmw.core.domain.bo.cart.Cart;

@Repository
public class CartDaoAdapter implements CartDao {

	@Override
	public void saveCart(final Cart cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cart findCartById(final Long cartId) {
		// TODO Auto-generated method stub
		return null;
	}

}
