package com.guilherme.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.guilherme.domain.Task;
import com.guilherme.domain.Project;
import com.guilherme.util.FormatDate;


/**
 * Guilherme de Lima Marinho
 */ 

public class TaskNewDTO {
	

    private Integer id;
    private String title;
    private String description;
    private Long status;
    private Date startDate;
    private Date endDate;
    private Integer projectId;
	private Long taskPoints;

    public TaskNewDTO(){
        this.projectId = 0;
    }

    public TaskNewDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.taskPoints = task.getTaskPoints();
        this.status = (Long) task.getStatus();
        this.startDate = task.getStartDate();
        this.endDate = task.getEndDate();
    }

    public TaskNewDTO(Integer id, String title, String description, Long taskPoints, Long status, String startDate,
    String endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskPoints = taskPoints;
        this.status = status;
        this.startDate = FormatDate.parse(startDate, "dd/MM/yyyy");
        this.endDate = FormatDate.parse(endDate, "dd/MM/yyyy");
        this.projectId = projectId;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Long getTaskPoints() {
		return taskPoints;
	}

	public void setTaskPoints(Long taskPoints) {
		this.taskPoints = taskPoints;
	}

    

}
