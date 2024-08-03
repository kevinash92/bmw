package com.eshopping.bmw.core.application.dao;

import java.util.List;

import com.eshopping.bmw.core.domain.bo.customer.Customer;

public interface CustomerDao {

	Customer findCustomerById(Long customerId);

	List<Customer> findAllCustomers();

	Boolean isCustomerExistsById(Long customerId);

	void saveCustomer(Customer customer);

	void deleteCustomer(Long customerId);
}
