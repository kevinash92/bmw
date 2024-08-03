package com.eshopping.bmw.core.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eshopping.bmw.core.application.dao.CustomerDao;
import com.eshopping.bmw.core.application.usecase.CustomerService;
import com.eshopping.bmw.core.domain.bo.customer.Customer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDao customerDao;

	@Override
	public Customer retrieveCustomerById(final Long customerId) {
		return customerDao.findCustomerById(customerId);
	}

	@Override
	public List<Customer> retrieveAllCustomers() {
		return customerDao.findAllCustomers();
	}

	@Override
	public void createUser(final Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public void updateUser(final Long customerId, final Customer customer) {
		if (customerDao.isCustomerExistsById(customerId)) {
			customer.setId(customerId);
			customerDao.saveCustomer(customer);
		}
	}

	@Override
	public void deleteUser(final Long customerId) {
		customerDao.deleteCustomer(customerId);
	}
}
