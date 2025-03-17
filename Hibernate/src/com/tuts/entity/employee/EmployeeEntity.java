package com.tuts.entity.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

	public EmployeeEntity(String name, Integer salary, String email) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.email = email;
	}
	public EmployeeEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer  id ;

	@Column(name = "name")
	String  name;

	@Column(name = "salary")
	Integer  salary;

	@Column(name = "email")
	String  email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", salary=" + salary + ", email=" + email + "]";
	}

	
}
