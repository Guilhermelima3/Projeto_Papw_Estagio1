package com.guilherme.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.domain.Project;
import com.guilherme.dto.ProjectDTO;
import com.guilherme.dto.ProjectNewDTO;
import com.guilherme.service.ProjectService;

@RestController
@RequestMapping("/api/projects/")
public class ProjectRest {

	  @Autowired
	    ProjectService service;

	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public ResponseEntity<Project> findById(@PathVariable Integer id){
	        return ResponseEntity.ok().body(service.findById(id));
	    }

	    @RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<ProjectDTO>> findAll(){
			List<Project> projectList = service.findAll();
			List<ProjectDTO> projectDTOs = projectList.stream().map((obj) -> new ProjectDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(projectDTOs);
	    }
	    
	    @RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Project> save(@Valid @RequestBody ProjectNewDTO projectDTO){
			Project project = service.fromDTO(projectDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(project));
		}
}
