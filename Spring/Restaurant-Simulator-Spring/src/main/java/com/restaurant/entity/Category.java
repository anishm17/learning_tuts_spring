package com.restaurant.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {
	@Id
	@Column(name ="categoryId")
	private int categoryId;
	@Column(name ="categoryName")
	private String categoryName;
	@Column(name ="chefs")
	private int chefs;
	@OneToMany(fetch = FetchType.LAZY ,mappedBy = "categoryId")
	private List<Item> items;
}
