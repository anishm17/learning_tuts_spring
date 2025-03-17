package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.Category;

@Repository
public interface RestaurantRepository extends  JpaRepository<Category, Integer> {

}
