package com.guilherme.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.domain.Project;
import com.guilherme.domain.Task;
import com.guilherme.dto.TaskNewDTO;
import com.guilherme.service.ProjectService;
import com.guilherme.service.TaskService;

@RestController
@RequestMapping("/api/tasks/")
public class TaskRest {
	
	@Autowired
    TaskService service;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task findById(@PathVariable Integer id) {
        return service.findById(id);
        
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public ResponseEntity<Object> filterByDate(@RequestParam String initialDate, @RequestParam String finalDate) {
        return ResponseEntity.ok().body(service.filterByDate(initialDate, finalDate));
    }

    @RequestMapping(value = "/date-and-status", method = RequestMethod.GET)
    public ResponseEntity<Object> filterByDateAndStatus(@RequestParam String initialDate,
            @RequestParam String finalDate, @RequestParam Long status) {
        return ResponseEntity.ok().body(service.filterByDateAndStatus(initialDate, finalDate, status));
    }

    @RequestMapping(value = "/points", method = RequestMethod.GET)
    public ResponseEntity<Object> filterByDate(@RequestParam Long initialPoints, @RequestParam Long finalPoints) {
        return ResponseEntity.ok().body(service.filterByPoints(initialPoints, finalPoints));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Project> save(@Valid @RequestBody TaskNewDTO taskDTO) {
        Project task = service.fromDtoToProject(taskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(task));
    }

}
