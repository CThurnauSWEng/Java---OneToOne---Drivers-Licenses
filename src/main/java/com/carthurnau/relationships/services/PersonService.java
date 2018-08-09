package com.carthurnau.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carthurnau.relationships.models.Person;
import com.carthurnau.relationships.repositories.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person findById(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		
		if (optionalPerson.isPresent() ) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
}
