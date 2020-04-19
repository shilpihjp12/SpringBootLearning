package com.test.ec.exploreCalifornia.Repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.ec.exploreCalifornia.domain.User;

@RepositoryRestResource(exported=true)
public interface UserRepo extends CrudRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
