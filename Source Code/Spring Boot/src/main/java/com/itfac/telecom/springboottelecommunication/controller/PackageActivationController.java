package com.itfac.telecom.springboottelecommunication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itfac.telecom.springboottelecommunication.model.PackageActivation;
import com.itfac.telecom.springboottelecommunication.service.PackageActivationService;

@RestController
public class PackageActivationController {

	@Autowired
	private PackageActivationService packageActivationService;

	@PostMapping("/api/pkgactivations")
	public ResponseEntity<String> addPackageActivation(@RequestBody PackageActivation pkg) {
		System.out.println(pkg);
		packageActivationService.addPkgActivation(pkg);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Saved");
	}

	@GetMapping("/api/pkgactivations/{accNo}/all")
	public ResponseEntity<List<PackageActivation>> getAllpackages(@PathVariable int accNo) {
		List<PackageActivation> pkgActivations = packageActivationService.getAllPkgActivations(accNo);
		return ResponseEntity.status(HttpStatus.OK).body(pkgActivations);
	}

	@PutMapping("/api/pkgactivations/{refNo}")
	public ResponseEntity<String> deactivarePkgActivated(@PathVariable int refNo) {
		packageActivationService.updatePkgActivation(refNo);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Deactivated");
	}
}
