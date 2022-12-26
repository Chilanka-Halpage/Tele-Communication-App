package com.itfac.telecom.springboottelecommunication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itfac.telecom.springboottelecommunication.model.Customer;
import com.itfac.telecom.springboottelecommunication.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("api/customers")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Saved");
	}

	@GetMapping("api/customers/{accNo}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int accNo) {
		Customer customer = customerService.getCustomer(accNo);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}

	@GetMapping("api/customers/all")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.status(HttpStatus.OK).body(customers);
	}

	@PutMapping("api/customers/{accNo}")
	public ResponseEntity<String> updateCustomer(@PathVariable int accNo, @RequestBody Customer customer) {
		customerService.updateCustomer(accNo, customer);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Modified");
	}

	@DeleteMapping("api/customers/{accNo}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int accNo) {
		customerService.deleteCustomer(accNo);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted");
	}
}
