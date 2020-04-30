package com.guilherme.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilherme.domain.Project;
import com.guilherme.domain.Task;
import com.guilherme.domain.enums.TaskStatus;
import com.guilherme.dto.TaskNewDTO;
import com.guilherme.repository.ProjectRepository;
import com.guilherme.repository.TaskRepository;
import com.guilherme.service.exception.NotFoundException;
import com.guilherme.util.FormatDate;


@Service
public class TaskService<X> {

    @Autowired
    TaskRepository repository;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;

    public Task findById(Integer id) {
        Optional<Task> task = repository.findById(id);
        return task.orElseThrow(() -> new NotFoundException ("Task não encontrado"));
    }

    @Transactional
    public Project save(Project project) {
        repository.saveAll(project.getTask());
        project = projectRepository.save(project);

        return project;

    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public List<Task> filterByDateAndStatus(String initialDate, String finalDate, Long status) {

        return repository.findByStartDateBetweenAndStatus(FormatDate.parse(initialDate, "dd/MM/yyyy"),
                FormatDate.parse(finalDate, "dd/MM/yyyy"), status);
    }

    public List<Task> filterByDate(String initialDate, String finalDate) {

        return repository.findByStartDateBetween(FormatDate.parse(initialDate, "dd/MM/yyyy"),
                FormatDate.parse(finalDate, "dd/MM/yyyy"));
    }

    public List<Task> filterByPoints(Long initialPoints, Long finalPoints) {

        return repository.findByTaskPointsBetween(initialPoints, finalPoints);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

    public Task update(Task task) {
        Task oldData = findById(task.getId());
        return repository.save(updateData(oldData, task));
    }

    private Task updateData(Task oldData, Task updated) {
        oldData.setId(updated.getId());
        oldData.setTitle(updated.getTitle());
        oldData.setDescription(updated.getDescription());
        oldData.setTaskPoints(updated.getTaskPoints());
        oldData.setStatus(updated.getStatus());
        oldData.setStartDate(updated.getStartDate());
        oldData.setEndDate(updated.getEndDate());
        return oldData;
    }

    public Task fromDTO(TaskNewDTO taskDTO) {

        Task task = new Task(null, taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getTaskPoints(),
                TaskStatus.toEnum(taskDTO.getStatus()), taskDTO.getStartDate(), taskDTO.getEndDate());

        if (!taskDTO.getProjectId().equals(0)) {
            Project project = projectService.findById(taskDTO.getProjectId());
            task.getProjects().add(project);
        }
        return task;

    }

    public Project fromDtoToProject(TaskNewDTO taskDTO) {

        Task task = new Task(null, taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getTaskPoints(),
                TaskStatus.toEnum(taskDTO.getStatus()), taskDTO.getStartDate(), taskDTO.getEndDate());

        Project project = projectService.findById(taskDTO.getProjectId());
        project.getTask().add(task);
        task.getProjects().add(project);

        return project;
    }
}
