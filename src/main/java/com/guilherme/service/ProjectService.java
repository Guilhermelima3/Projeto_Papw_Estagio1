package com.guilherme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.guilherme.domain.Department;
import com.guilherme.domain.Person;
import com.guilherme.domain.Project;
import com.guilherme.dto.ProjectNewDTO;
import com.guilherme.dto.TaskNewDTO;

import com.guilherme.repository.ProjectRepository;
import com.guilherme.repository.TaskRepository;
import com.guilherme.service.exception.NotFoundException;

public class ProjectService {

	@Autowired
	ProjectRepository repository;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	PersonService personService;

	@Autowired
	TaskRepository taskRepository;

	private ProjectService taskService;

	public Project findById(Integer id) {
		Optional<Project> project = repository.findById(id);
		return project.orElseThrow(() -> new NotFoundException("Project não encontrado"));
	}

	public List<Project> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Project save(Project project) {
		project.setId(null); 
		project = repository.save(project);
		if(!project.getTask().isEmpty()){
			taskRepository.saveAll(project.getTask());
		}
		return project;
		
	}

	public Project update(Project project) {
		Project oldData = findById(project.getId());
		return repository.save(updateData(oldData, project));
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

	private Project updateData(Project oldData, Project updated) {	
		oldData.setId(updated.getId());
		oldData.setProjectTitle(updated.getProjectTitle());
		oldData.setManager(updated.getManager());		
		oldData.setMinSalary(updated.getMinSalary());		
		oldData.setMaxSalary(updated.getMaxSalary());	
		oldData.setStartDate(updated.getStartDate());
		oldData.setEndDate(updated.getEndDate());	
		oldData.setDepartment(updated.getDepartment());
		return oldData;
	}

	public Project fromDTO(ProjectNewDTO projectDTO) {

		Department department = departmentService.findById(projectDTO.getDepartment());

		Person person = personService.findById(projectDTO.getManager());

		Project project = new Project(
			null,
			projectDTO.getProjectTitle(),
			person,	
			projectDTO.getMinSalary(),		
			projectDTO.getMaxSalary(),	
			projectDTO.getStartDate(),
			projectDTO.getEndDate(),	
			department
		);

		for(TaskNewDTO t : projectDTO.getTask()){
			project.getTask().add(taskService.fromDTO(t));
		}
		
		return project;
	}

	private Object fromDTO(TaskNewDTO t) {
		// TODO Auto-generated method stub
		return null;
	}
}
