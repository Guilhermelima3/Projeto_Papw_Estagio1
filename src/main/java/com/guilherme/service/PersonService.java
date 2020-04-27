package com.guilherme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.domain.Department;
import com.guilherme.domain.Person;
import com.guilherme.dto.PersonNewDTO;
import com.guilherme.repository.DepartmentRepository;
import com.guilherme.repository.PersonRepository;
import com.guilherme.service.exception.NotFoundException;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;

	@Autowired
	DepartmentService departmentRepository;

	public Person findById(Integer id) {
		Optional<Person> person = repository.findById(id);
		return person.orElseThrow(() -> new NotFoundException("Person não encontrado"));
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person save(Person person) {
		person.setId(null); // Limpando o id, caso venha no objeto
		return repository.save(person);
	}

	public Person update(Person person) {
		Person oldData = findById(person.getId());
		return repository.save(updateData(oldData, person));
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private Person updateData(Person oldData, Person updated) {
		oldData.setId(updated.getId());
		oldData.setFirstName(updated.getFirstName());
		oldData.setLastName(updated.getLastName());
		oldData.setEmail(updated.getEmail());
		oldData.setPhoneNumber(updated.getPhoneNumber());
		oldData.setHireDate(updated.getHireDate());
		return oldData;
	}

	public Person fromDTO(PersonNewDTO personDTO) {

		Department department = DepartmentService.findById(personDTO.getDepartment());

		return new Person(null, personDTO.getFirstName(), personDTO.getLastName(), personDTO.getEmail(),
				personDTO.getPhoneNumber(), personDTO.getHireDate(), department);
	}

}
