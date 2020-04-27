package com.guilherme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.domain.Department;
import com.guilherme.repository.DepartmentRepository;
import com.guilherme.service.exception.NotFoundException;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;

	@Autowired
	DepartmentRepository departmentRepository;

	public static Department findById(Integer id) {
		Optional<Department> department = repository.findById(id);
		return department.orElseThrow(() -> new NotFoundException("Department não encontrado"));
	}

	public List<Department> findAll() {
		return repository.findAll();
	}

	public Department save(Department department) {
		department.setId(null); 
		return repository.save(department);
	}

	public Department update(Department department) {
		Department oldData = findById(department.getId());
		return repository.save(updateData(oldData, department));
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private Department updateData(Department oldData, Department updated) {
		oldData.setId(updated.getId());
		oldData.setDepartmentName(updated.getDepartmentName());
		return oldData;
	}


}
