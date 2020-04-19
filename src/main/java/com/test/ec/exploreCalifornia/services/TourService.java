package com.test.ec.exploreCalifornia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ec.exploreCalifornia.Repo.TourPackageRepo;
import com.test.ec.exploreCalifornia.Repo.TourRepo;
import com.test.ec.exploreCalifornia.domain.Difficulty;
import com.test.ec.exploreCalifornia.domain.Region;
import com.test.ec.exploreCalifornia.domain.Tour;
import com.test.ec.exploreCalifornia.domain.TourPackage;

@Service
public class TourService {
	private TourRepo tourRepo;
	private TourPackageRepo tourRepoService;
	
	@Autowired
	public TourService(TourRepo tourRepo, TourPackageRepo tourRepoService) {
		super();
		this.tourRepo = tourRepo;
		this.tourRepoService = tourRepoService;
	}
	
	public Tour createTour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, String tourPackageCode, String difficulty, String region) {
		Tour tour = null;
		Optional<TourPackage> tourPackge = tourRepoService.findById(tourPackageCode);
		if(tourPackge!=null) {
			TourPackage tourPack = tourPackge.get();
			tour = new Tour(title, description, blurb, price, duration, bullets, keywords, tourPack.getCode(), difficulty, region);
		} else {
		  
		}
		return tour;
	}
	
	public Tour addTour(Tour tour, String packageCode) {
		tourRepo.save(tour);
		return tour;
	}
	public Iterable<Tour> tours() {
		return tourRepo.findAll();
	}
	
	public long totaltTours() {
		return tourRepo.count();
	}

	public Tour tour(int tourId) {
		// TODO Auto-generated method stub
		return tourRepo.findById(tourId).get();
	}
	
}
