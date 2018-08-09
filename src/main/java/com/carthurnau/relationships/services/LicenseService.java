package com.carthurnau.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carthurnau.relationships.models.License;
import com.carthurnau.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {

	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> findAll() {
		return licenseRepository.findAll();
	}
	
	public License createLicense(License license) {
		
		// determine if this is the first license to be created
		Long number = licenseRepository.count();
		if (number < 1) {
			number = (long) 1;
		} else {
			number++;
		}
		
		license.setNumber(number);
		return licenseRepository.save(license);
	}

}
