package com.tuts.entity.project;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tuts.entity.customer.Customer;

@Entity
@Table(name = "project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private  Integer  id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "customer_id")
	private  Customer customeId;
	
	public Project() {
		
	}

	public Project(String name) {
		this.name = name;
	}

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


	public Customer getCustomeId() {
		return customeId;
	}

	public void setCustomeId(Customer customeId) {
		this.customeId = customeId;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", customeId=" + customeId + "]";
	}


	

}
