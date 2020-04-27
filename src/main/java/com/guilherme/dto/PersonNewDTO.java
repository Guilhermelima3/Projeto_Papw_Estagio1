package com.guilherme.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.guilherme.domain.Person;
import com.guilherme.util.FormatDate;

/**
 * Guilherme de Lima Marinho
 */

public class PersonNewDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "*")
	@Length(min = 2, max = 50, message = " 4 e 50 caracteres")
	private String firstName;
	
	private String lastName;
	
	@Email(message = "O email informado não é válido")
	private String email;
	
	@NotNull(message = "*")
	private String phoneNumber;
	
	@NotNull(message = "*")
	private Integer department;

	private Date hireDate;

	public PersonNewDTO() {

	}
	
	public PersonNewDTO(Person person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.email = person.getEmail();
		this.phoneNumber = person.getPhoneNumber();
	}

	public PersonNewDTO(String firstName, String lastName, String email, String phoneNumber,
			Integer department, String hireDate) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.department = department;
		this.hireDate = FormatDate.parse(hireDate, "dd/MM/yyyy");
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

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = FormatDate.parse(hireDate, "dd/MM/yyyy");
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
