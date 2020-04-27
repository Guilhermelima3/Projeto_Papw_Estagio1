package com.guilherme.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.domain.Department;
import com.guilherme.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentRest {
	
	@Autowired
	DepartmentService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Department> findbyId(@PathVariable Integer id){
		Department department = service.findById(id);
		return ResponseEntity.ok().body(department);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Department>> findAll(){
		List<Department> departmentList = service.findAll();
		return ResponseEntity.ok().body(departmentList);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Department> save( @RequestBody Department department){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(department));
	}

}
