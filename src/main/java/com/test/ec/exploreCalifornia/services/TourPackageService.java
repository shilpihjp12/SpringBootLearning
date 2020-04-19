package com.test.ec.exploreCalifornia.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ec.exploreCalifornia.Repo.TourPackageRepo;
import com.test.ec.exploreCalifornia.domain.TourPackage;

@Service
public class TourPackageService {
	private TourPackageRepo tourPackageRepo;
	@Autowired
	public TourPackageService(TourPackageRepo tourPackageRepo) {
		this.tourPackageRepo = tourPackageRepo;
	}
	
	public TourPackage createTourPackage(String code, String name) {
		if(!tourPackageRepo.existsById(code)){
			tourPackageRepo.save(new TourPackage(code, name));
		}
		return null;
	}
	
	public Iterable<TourPackage> tourPackages() {
		return tourPackageRepo.findAll();
	}
	
	public TourPackage tourPackagesById(String code) {
		return tourPackageRepo.findById(code).get();
	}
	public long count() {
		return tourPackageRepo.count();
	}
}
