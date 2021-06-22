package com.codingdojo.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lookify.models.Lookify;
public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	// this method retrieves all the languages from the database
	 List<Lookify> findAll();
	 Optional<Lookify> findByTitle(String title);
	 

}
