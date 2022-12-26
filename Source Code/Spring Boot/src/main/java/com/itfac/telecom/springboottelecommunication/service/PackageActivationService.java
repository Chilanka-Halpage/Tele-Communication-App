package com.itfac.telecom.springboottelecommunication.service;

import java.util.List;

import com.itfac.telecom.springboottelecommunication.model.PackageActivation;

public interface PackageActivationService {
	void addPkgActivation(PackageActivation pkg);

	PackageActivation getPkgActivation(long pkgRef);

	List<PackageActivation> getAllPkgActivations(int accNo);

	void updatePkgActivation(long pkgRef);
}
