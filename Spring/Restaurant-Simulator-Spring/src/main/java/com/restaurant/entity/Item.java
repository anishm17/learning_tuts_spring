package com.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	@Id
	@Column(name ="categoryId")
	private int categoryId;
	@Column(name ="categoryName")
	private String itemName;
	@Column(name ="timeRequired")
	private int timeRequired;
	@OneToOne(mappedBy = "categoryId")
	private Category  category;
}
