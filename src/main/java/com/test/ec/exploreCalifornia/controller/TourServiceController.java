package com.test.ec.exploreCalifornia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.ec.exploreCalifornia.Repo.TourRatingRepo;
import com.test.ec.exploreCalifornia.Repo.TourRepo;
import com.test.ec.exploreCalifornia.domain.Tour;
import com.test.ec.exploreCalifornia.domain.TourPackage;
import com.test.ec.exploreCalifornia.domain.TourRating;
import com.test.ec.exploreCalifornia.services.TourPackageService;
import com.test.ec.exploreCalifornia.services.TourService;

@RestController
@RequestMapping(value="/api")
public class TourServiceController {
	
	public static final Logger logger= LoggerFactory.getLogger(TourServiceController.class);

	@Autowired
	TourService tourService;
	
	@Autowired
	TourPackageService tourPackageService;
	
	TourRatingRepo tourRatingRepo;
	
	@Autowired
	public TourServiceController(TourRatingRepo tourRatingRepo) {
		this.tourRatingRepo = tourRatingRepo;
	}
	
	@GetMapping("/getTourPackages")
	@ResponseStatus(HttpStatus.FOUND)
	public Iterable<TourPackage> getTourPackage() {
		return tourPackageService.tourPackages();
	}
	
	@GetMapping("/getTourPackagesById")
	@ResponseStatus(HttpStatus.FOUND)
	public TourPackage getTourPackageById(@RequestParam(name="code")String code) {
		return tourPackageService.tourPackagesById(code);
	}
	
	@PostMapping("/addTour")
	@ResponseStatus(HttpStatus.CREATED)
	public Tour addTour(@RequestBody Tour tour,@RequestParam(value="tour_package_code")String tour_package_code) {
		logger.debug("add Tour");
		return tourService.addTour(tour, tour_package_code);
	}
	
	@GetMapping("/getTour")
	@ResponseStatus(HttpStatus.FOUND)
	public Iterable<Tour> getTour() {
		return tourService.tours();
	}
	
	@PostMapping("/createTourRating")
	@ResponseStatus(HttpStatus.CREATED)
	public Iterable<TourRating> createTourRating(@RequestBody TourRating rating){
		Tour tour = tourService.tour(rating.getTourId());
		if(tour!= null) {
			this.tourRatingRepo.save(rating);
		}
		else {
			
		}
		return null;
	}
	
	@PutMapping("/putTourRating")
	@ResponseStatus(HttpStatus.CREATED)
	public Iterable<TourRating> updateRatingWithPut(@RequestBody TourRating rating){
		Tour tour = tourService.tour(rating.getTourId());
		if(tour!= null) {
			this.tourRatingRepo.save(rating);
		}
		else {
			
		}
		return null;
	}
	
	@PatchMapping("/patchTourRating")
	@ResponseStatus(HttpStatus.CREATED)
	public TourRating patchRatingWithPut(@RequestBody TourRating rating){
		TourRating tourRating = tourRatingRepo.findByTourIdAndCustomerId(rating.getTourId(), rating.getCustomerId());
		
		if(tourRating.getDescription() == null) {
			tourRating.setDescription(rating.getDescription());
		}
		if(tourRating.getScore() ==  0) {
			tourRating.setScore(rating.getScore());
		}
		tourRatingRepo.save(tourRating);
		return tourRating;
	}
	
	
	@GetMapping("/getTourRating")
	@ResponseStatus(HttpStatus.FOUND)
	public Iterable<TourRating> getTourRationForId(@RequestParam(value="ratingId")int ratingId) {
		return tourRatingRepo.findByTourId(ratingId);
	}
	
	
//	@GetMapping("/getTourRatingForTour")
//	@ResponseStatus(HttpStatus.FOUND)
//	public Page<TourRating> getTourRationForTour(@RequestParam(value="tourId")int tourId, Pageable page) {
//		return new PageImpl<TourRating>(tourRatingRepo.findByTourId(tourId, page))  ;
//	}
//	
	
	@DeleteMapping("/deleteTourRating")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTourRation(@RequestParam(value="ratingId")int ratingId, @RequestParam(value="customerId")int customerId) {
		TourRating tourRating = tourRatingRepo.findByTourIdAndCustomerId(ratingId, customerId);
		tourRatingRepo.delete(tourRating);
	}
	
}
