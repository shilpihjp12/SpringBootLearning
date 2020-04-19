package com.test.ec.exploreCalifornia.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.test.ec.exploreCalifornia.domain.TourPackage;

@Repository
@RepositoryRestResource(exported=false)
public interface TourPackageRepo extends CrudRepository<TourPackage, String> {


}
