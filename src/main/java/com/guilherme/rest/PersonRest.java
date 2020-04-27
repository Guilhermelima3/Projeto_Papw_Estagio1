package com.guilherme.rest;

import java.awt.List;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.domain.Person;
import com.guilherme.dto.PersonDTO;
import com.guilherme.dto.PersonNewDTO;
import com.guilherme.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonRest {

	@Autowired
	PersonService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> findbyId(@PathVariable Integer id){
		Person person = service.findById(id);
		return ResponseEntity.ok().body(person);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<java.util.List<PersonDTO>> findAll(){
		List personList = (List) service.findAll();
		java.util.List<PersonDTO> personDTOs = ((Collection<Person>) personList).stream().map((obj) -> new PersonDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(personDTOs);
	}	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Person> save(@RequestBody PersonNewDTO personDTO){
		Person person = service.fromDTO(personDTO);
		return ResponseEntity.ok().body(service.save(person));
	}
	

}
