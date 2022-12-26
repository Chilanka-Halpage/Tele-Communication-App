package com.itfac.telecom.springboottelecommunication.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itfac.telecom.springboottelecommunication.model.PackageActivation;

@Repository
public interface PackageActivationRepository extends CrudRepository<PackageActivation, Long> {
	List<PackageActivation> findByCustomerAccNo(int accNo);
}
