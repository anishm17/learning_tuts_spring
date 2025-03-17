package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.Category;
import com.restaurant.service.RestaurantService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/restaurant")
@Slf4j
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	/**
	 * startRestaurantEstimation  is  used to  calculate  the  order estimation
	 * @return requiredTime 
	 */
	@GetMapping("/requestOrder")
	public  Integer  startRestaurantEstimation() {
		log.info("-----Welcome  to  Restaurant  Simulator-----");
		List<Category>  categoryList=  restaurantService.getRestaurantEnityData();
		Integer  requiredTime = restaurantService.estimateOrder(categoryList);
		restaurantService.orderSummary(requiredTime);
		log.info("-----Restaurant Simulation Completed-----");
		return requiredTime;
	}

}
