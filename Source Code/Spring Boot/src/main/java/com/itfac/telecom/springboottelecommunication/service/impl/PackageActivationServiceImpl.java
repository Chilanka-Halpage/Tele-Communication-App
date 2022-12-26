package com.itfac.telecom.springboottelecommunication.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfac.telecom.springboottelecommunication.dao.PackageActivationRepository;
import com.itfac.telecom.springboottelecommunication.model.PackageActivation;
import com.itfac.telecom.springboottelecommunication.service.PackageActivationService;

@Service
public class PackageActivationServiceImpl implements PackageActivationService {

	@Autowired
	private PackageActivationRepository pkgeActivRepository;

	@Override
	public void addPkgActivation(PackageActivation pkg) {
		// Save the new package activated in the DB
		pkg.setActivatedOn(new Date());
		PackageActivation pkgActivated = pkgeActivRepository.save(pkg);

		// Throw an error unless saving process succeeded
		if (pkgActivated == null)
			throw new RuntimeException("Error occured while saving the new package activated");

	}

	@Override
	public PackageActivation getPkgActivation(long pkgRef) {
		// Checking the package is available for the given ref no.If not, throw an
		// error
		return pkgeActivRepository.findById(pkgRef)
				.orElseThrow(() -> new RuntimeException("package not found for ref No: " + pkgRef));
	}

	@Override
	public List<PackageActivation> getAllPkgActivations(int accNo) {
		// Retrieving all the package details for the given account
		return pkgeActivRepository.findByCustomerAccNo(accNo);
	}

	@Override
	public void updatePkgActivation(long pkgRef) {
		// Checking package is available for given ref no.
		PackageActivation pkg = getPkgActivation(pkgRef);
		
		//deactivate package
		pkg.setActive(false);
		pkg.setDeactivatedOn(new Date());
		
		// Deleting the package
		pkgeActivRepository.save(pkg);
	}

}
