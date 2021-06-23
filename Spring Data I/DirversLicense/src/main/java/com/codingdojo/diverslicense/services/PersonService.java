package com.codingdojo.diverslicense.services;
import org.springframework.stereotype.Service;

import com.codingdojo.diverslicense.models.Person;
import com.codingdojo.diverslicense.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person createPerson(Person p) {
		return personRepository.save(p);
	}

	public Person findPerson(Long id) {
//		Optional<Person> p = personRepository.findById(id);
		// or use: 
		return personRepository.findById(id).orElse(null); 
	}

}
