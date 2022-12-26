package com.itfac.telecom.springboottelecommunication.service;

import java.util.List;

import com.itfac.telecom.springboottelecommunication.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);

	void updateCustomer(int accNo, Customer customer);

	Customer getCustomer(int accNo);

	List<Customer> getAllCustomers();

	void deleteCustomer(int accNo);
}
