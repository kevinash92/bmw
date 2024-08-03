package com.eshopping.bmw.core.application.usecase;

import java.util.List;

import com.eshopping.bmw.core.domain.bo.order.Order;
import com.eshopping.bmw.core.domain.bo.order.OrderStatus;

public interface OrderService {

	Order retrieveOrderById(Long orderId);

	List<Order> retrieveAllOrders();

	void createOrder(Order order);

	void changeOrderStatus(Long orderId, OrderStatus status);
}
