package com.eshopping.bmw.framework.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eshopping.bmw.core.application.dao.OrderDao;
import com.eshopping.bmw.core.domain.bo.order.Order;

@Repository
public class OrderDaoAdapter implements OrderDao {

	@Override
	public Order findOrderById(final Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isOrderExistsById(final Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrder(final Order order) {
		// TODO Auto-generated method stub

	}

}
