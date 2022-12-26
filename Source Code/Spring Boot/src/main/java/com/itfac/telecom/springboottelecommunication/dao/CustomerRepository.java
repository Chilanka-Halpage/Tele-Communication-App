package com.itfac.telecom.springboottelecommunication.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itfac.telecom.springboottelecommunication.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
