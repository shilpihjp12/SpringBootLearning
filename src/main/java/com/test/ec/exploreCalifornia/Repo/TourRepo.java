package com.test.ec.exploreCalifornia.Repo;

import org.springframework.stereotype.Repository;

import com.test.ec.exploreCalifornia.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@Repository
@RepositoryRestResource(exported=false)
public interface TourRepo extends CrudRepository<Tour, Integer> {
	
}
