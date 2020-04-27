package com.guilherme.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.guilherme.domain.Project;
import com.guilherme.domain.Task;


import com.guilherme.util.FormatDate;


public class ProjectDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer id;
	private String projectTitle;
	private Integer manager;	
	private Long minSalary;	
	private Long maxSalary;
	private Date startDate;	
	private Date endDate;
    private Integer department;

    private List<Task> task = new ArrayList<>();
    
    public ProjectDTO(){

    }

    public ProjectDTO(Project project){
        this.id = project.getId();
        this.projectTitle = project.getProjectTitle();
        this.manager = project.getManager().getId();	
        this.minSalary = project.getMinSalary();	
        this.maxSalary = project.getMaxSalary();
        this.startDate = project.getStartDate();	
        this.endDate = project.getEndDate();
        this.department = project.getDepartment().getId();

        this.task.addAll(project.getTask());
    }

    public ProjectDTO(Integer id, String projectTitle, Integer manager, Long minSalary, Long maxSalary, String startDate, String endDate, Integer department) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.manager = manager;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.startDate = FormatDate.parse(startDate, "dd/MM/yyyy");
        this.endDate = FormatDate.parse(endDate, "dd/MM/yyyy");
        this.department = department;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public Long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public Long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    

    
    
}
