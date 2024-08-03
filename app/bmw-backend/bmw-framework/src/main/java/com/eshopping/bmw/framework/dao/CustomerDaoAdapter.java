package com.eshopping.bmw.framework.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eshopping.bmw.core.application.dao.CustomerDao;
import com.eshopping.bmw.core.domain.bo.customer.Customer;

@Repository
public class CustomerDaoAdapter implements CustomerDao {

	@Override
	public Customer findCustomerById(final Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isCustomerExistsById(final Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCustomer(final Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(final Long customerId) {
		// TODO Auto-generated method stub

	}

}
