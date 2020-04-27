package com.guilherme.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.guilherme.domain.Project;

import com.guilherme.util.FormatDate;


public class ProjectNewDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
	private String projectTitle;
	private Integer manager;	
	private Long minSalary;	
	private Long maxSalary;
	private Date startDate;	
	private Date endDate;
    private Integer department;

    private List<TaskNewDTO> task = new ArrayList<>();
    
    public ProjectNewDTO(){

    }

    public ProjectNewDTO(Project project){
        this.id = project.getId();
        this.projectTitle = project.getProjectTitle();
        this.manager = project.getManager().getId();	
        this.minSalary = project.getMinSalary();	
        this.maxSalary = project.getMaxSalary();
        this.startDate = project.getStartDate();	
        this.endDate = project.getEndDate();
        this.department = project.getDepartment().getId();
    }

    public ProjectNewDTO(Integer id, String projectTitle, Integer manager, Long minSalary, Long maxSalary, String startDate, String endDate, Integer department) {
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

	public List<TaskNewDTO> getTask() {
		return task;
	}

	public void setTask(List<TaskNewDTO> task) {
		this.task = task;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public java.lang.Integer getManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public java.lang.Integer getDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	public java.lang.String getProjectTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public java.lang.Long getMinSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	public java.lang.Long getMaxSalary() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection getCvs() {
		// TODO Auto-generated method stub
		return null;
	}


}
