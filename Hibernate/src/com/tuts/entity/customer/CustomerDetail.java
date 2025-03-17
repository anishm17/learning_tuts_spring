package com.tuts.entity.customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_detail")
public class CustomerDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer  id;
	
	@Column(name = "ambition")
	private String ambition;
	
	@Column(name = "hobby")
	private String hobby;
	
	@OneToOne(mappedBy = "customerDetailId",cascade = CascadeType.ALL)
	private  Customer  customer;
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAmbition() {
		return ambition;
	}

	public void setAmbition(String ambition) {
		this.ambition = ambition;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public CustomerDetail(String ambition, String hobby) {
		this.ambition = ambition;
		this.hobby = hobby;
	}
	
	
	public CustomerDetail() {
		
	}

	@Override
	public String toString() {
		return "CustomerDetail [id=" + id + ", ambition=" + ambition + ", hobby=" + hobby + "]";
	}
	
	
}
