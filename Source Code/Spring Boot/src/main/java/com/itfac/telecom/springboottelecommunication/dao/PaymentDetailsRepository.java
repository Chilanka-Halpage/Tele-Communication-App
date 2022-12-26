package com.itfac.telecom.springboottelecommunication.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itfac.telecom.springboottelecommunication.model.PaymentDetails;

@Repository
public interface PaymentDetailsRepository extends CrudRepository<PaymentDetails, Long> {

	List<PaymentDetails> findByCustomerAccNo(int accNo);
}
