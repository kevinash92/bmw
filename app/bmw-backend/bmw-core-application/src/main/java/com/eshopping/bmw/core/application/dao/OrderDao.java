package com.eshopping.bmw.core.application.dao;

import java.util.List;

import com.eshopping.bmw.core.domain.bo.order.Order;

public interface OrderDao {

	Order findOrderById(Long orderId);

	List<Order> findAllOrders();

	Boolean isOrderExistsById(Long orderId);

	void saveOrder(Order order);
}
