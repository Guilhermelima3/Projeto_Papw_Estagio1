package com.guilherme.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilherme.domain.enums.TaskStatus;
import com.guilherme.util.FormatDate;
/**
 * Guilherme de Lima Marinho
 */

@Entity
public class Task<TaskStatus> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private Long taskPoints;
	private Long status;
	private Date startDate;
	private Date endDate;

	@JsonIgnore
	@ManyToMany(mappedBy = "task")
	private List <Project> projects = new ArrayList<>();

	private Long TaskPoints;

	public Task() {
		// EMPTY CONSTRUCTOR
	}

	public Task(Integer id, String title, String description, Long TaskPoints, TaskStatus status, Date date,
			Date date2) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.TaskPoints = TaskPoints;
		this.status = ((com.guilherme.domain.enums.TaskStatus) status).getCod();
		this.startDate = FormatDate.parse(date, "dd/MM/yyyy");
		this.endDate = FormatDate.parse(date2, "dd/MM/yyyy");
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTaskPoints(Long taskPoints) {
		this.taskPoints = taskPoints;
	}

	public void setStatus(Object object) {
		this.status = (Long) object;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", description='" + getDescription()
				+ "'" + ", taskPoints='" + getTaskPoints() + "'" + ", status='" + getStatus() + "'" + ", startDate='"
				+ getStartDate() + "'" + ", endDate='" + getEndDate() + "'" + ", projects='" + getProjects() + "'"
				+ "}";
	}
	

	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getTaskPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

		
 
}
