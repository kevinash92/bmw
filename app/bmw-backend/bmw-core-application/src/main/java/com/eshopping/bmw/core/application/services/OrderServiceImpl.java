package com.eshopping.bmw.core.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshopping.bmw.core.application.dao.OrderDao;
import com.eshopping.bmw.core.application.usecase.OrderService;
import com.eshopping.bmw.core.domain.bo.order.Order;
import com.eshopping.bmw.core.domain.bo.order.OrderStatus;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderDao orderDao;

	@Override
	public Order retrieveOrderById(final Long orderId) {
		return orderDao.findOrderById(orderId);
	}

	@Override
	public List<Order> retrieveAllOrders() {
		return orderDao.findAllOrders();
	}

	@Override
	public void createOrder(final Order order) {
		orderDao.saveOrder(order);
	}

	@Override
	public void changeOrderStatus(final Long orderId, final OrderStatus status) {
		if (orderDao.isOrderExistsById(orderId)) {
			Order order = retrieveOrderById(orderId);
			switch (status) {
			case PROCESSED:
				order.process();
				break;
			case DELIVERED:
				order.deliver();
				break;
			case CANCELED:
				order.cancel();
				break;
			case REFUNDED:
				order.refund();
				break;
			default:
				throw new IllegalArgumentException("Unexpected status: " + status);
			}
		}
	}

}
