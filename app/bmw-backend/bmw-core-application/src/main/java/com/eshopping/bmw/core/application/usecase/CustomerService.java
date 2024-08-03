package com.eshopping.bmw.core.application.usecase;

import java.util.List;

import com.eshopping.bmw.core.domain.bo.customer.Customer;

public interface CustomerService {

	Customer retrieveCustomerById(Long customerId);

	List<Customer> retrieveAllCustomers();

	void createUser(Customer customer);

	void updateUser(Long customerId, Customer customer);

	void deleteUser(Long customerId);
}
