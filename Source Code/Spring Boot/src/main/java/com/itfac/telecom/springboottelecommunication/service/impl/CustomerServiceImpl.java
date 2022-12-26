package com.itfac.telecom.springboottelecommunication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfac.telecom.springboottelecommunication.dao.CustomerRepository;
import com.itfac.telecom.springboottelecommunication.model.Customer;
import com.itfac.telecom.springboottelecommunication.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void addCustomer(Customer customer) {
		// Checking a customer is already available for given account no.
		if (!customerRepository.existsById(customer.getAccNo())) {
			// Save the new customer in the DB
			Customer cust = customerRepository.save(customer);

			// Throw an error unless saving process succeeded
			if (cust == null)
				throw new RuntimeException("Error occured while saving the customer");
		} else {
			// Throwing an error since a customer for given account no is already available
			throw new RuntimeException("Customer is already availabe for Account No " + customer.getAccNo());
		}

	}

	@Override
	public void updateCustomer(int accNo, Customer customer) {
		// Checking customer is available for given account no.
		if (customerRepository.existsById(accNo)) {
			// Update the customer with modified data
			Customer cust = customerRepository.save(customer);

			// Throw an error unless updating process succeeded
			if (cust == null)
				throw new RuntimeException("Error occured while updating the customer");
		} else {
			// Throwing an error since customer for given account no is not available
			throw new RuntimeException("Account NO " + accNo + " not found");
		}

	}

	@Override
	public Customer getCustomer(int accNo) {
		// Checking the customer is available for the given account no.If not, throw an
		// error
		return customerRepository.findById(accNo)
				.orElseThrow(() -> new RuntimeException("Account NO " + accNo + " not found"));
	}

	@Override
	public List<Customer> getAllCustomers() {
		// Retrieving all the customer available
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(int accNo) {
		// Checking customer is available for given account no.
		Customer customer = getCustomer(accNo);

		// Deleting the customer relevant to the given account No
		customerRepository.delete(customer);
	}

}
