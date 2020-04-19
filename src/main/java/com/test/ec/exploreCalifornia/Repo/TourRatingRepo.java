package com.test.ec.exploreCalifornia.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.ec.exploreCalifornia.domain.Tour;
import com.test.ec.exploreCalifornia.domain.TourRating;
import com.test.ec.exploreCalifornia.domain.TourRatingPK;

@RepositoryRestResource(exported=false)
public interface TourRatingRepo extends CrudRepository<TourRating, TourRatingPK>{

	Iterable<TourRating> findByTourId(int ratingId);

	TourRating findByTourIdAndCustomerId(int tourId, Integer customerId);
	
	//List<Tour> findBypkTourId(Integer tourId);
	
	//List<Tour> findBypkTourIdAndcustomerId(Integer tourId, Integer CustomeId);

}
