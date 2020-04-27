package com.guilherme.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techzone.taskcontroller.domain.Object;
import com.techzone.taskcontroller.domain.Override;
import com.techzone.taskcontroller.domain.Person;


@Entity
public class Person implements Serializable{
	
	private static	final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@NotNull (message = "*")
	private String firstName;
	
	private String lastName;
	
	@NotNull
	private String email;
	
	@NotNull (message = "*")
	private String phoneNumber;
	
	
	private Date hireDate;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@SuppressWarnings("rawtypes")
	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	private List<Project> projects = new ArrayList<>();

	public Person() {
		// EMPTY CONSTRUCTOR
	}



	public Person(Integer id, String firstName, String lastName, String email,
		 String phoneNumber, Date hireDate, Department department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.department = department;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Date getHireDate() {
		return hireDate;
	}



	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@SuppressWarnings("rawtypes")
	public List<Project> getProjects() {
		return projects;
	}



	@SuppressWarnings("rawtypes")
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
