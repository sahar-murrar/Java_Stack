package com.codingdojo.diverslicense.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.diverslicense.models.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
	Optional<Person> findById(Long id);
	

}
