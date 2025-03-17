package com.tuts.entity.customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tuts.entity.project.Project;

@Entity
@Table(name = "customer")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer  id ;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "father_name")
	private String  fatherName;
	
	@Column(name = "email")
	private String  email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_detail_id")
	private CustomerDetail  customerDetailId;
	
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "customeId"  ,cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Project> projects ;

	public Customer(String name, String fatherName, String email) {
		this.name = name;
		this.fatherName = fatherName;
		this.email = email;
	}
	
	public Customer() {
		
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

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerDetail getCustomerDetailId() {
		return customerDetailId;
	}

	public void setCustomerDetailId(CustomerDetail customerDetailId) {
		this.customerDetailId = customerDetailId;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", email=" + email
				+ ", customerDetailId=" + customerDetailId + ", projects=" + projects + "]";
	}

	public void  add (Project  tempProject) {
       if(projects == null) {
    	   projects  =  new ArrayList<>();
       }
       
       projects.add(tempProject);
       
       tempProject.setCustomeId(this);
	}
	
	
	
	


}
