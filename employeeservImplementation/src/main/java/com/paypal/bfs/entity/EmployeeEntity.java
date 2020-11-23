package com.paypal.bfs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Constraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.paypal.bfs.validations.ValidateEmployeeDetails;

import lombok.Data;

/**
 * 
 * @author vasanthnanduri
 * Description: This is an entity class which directly correlates to the employee table. validations are applied to the columns which do not accept null values.
 *
 */

@Entity
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column
	@NotEmpty(message = "First name should not be blank.")
	@ValidateEmployeeDetails
	String firstName;
	
	@Column
	@NotEmpty(message = "Last name should not be blank.")
	@ValidateEmployeeDetails
	String lastName; 
	
	@Column
	@NotEmpty(message = "date of birth should not be blank.")
	@ValidateEmployeeDetails
	String dateOfBirth;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	AddressEntity address;

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + "]";
	}

}
