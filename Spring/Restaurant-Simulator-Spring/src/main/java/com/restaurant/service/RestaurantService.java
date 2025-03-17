package com.restaurant.service;



import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.constants.RestautantConstant;
import com.restaurant.entity.Category;
import com.restaurant.repository.RestaurantRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	static  Integer  categoryId;
	static  Category  category;
	static  Integer  itemTiming;

	/**
	 * getRestaurantEnityData is used  to  get  the  restaurant Entity  from data
	 * @return List
	 */
	public List<Category> getRestaurantEnityData() {
		log.info("-----Reading Restaurant Entity-----");
		return restaurantRepository.findAll();
	}

	/**
	 * estimateOrder  is  used  to  calculate  the  total  delivery estimation
	 * @param categoryList
	 * @return requiredTime
	 */
	public Integer estimateOrder(List<Category> categoryList) {
		log.info("-----Estimating the Order Request-----");
		int estimatedTime = RestautantConstant.ZERO;
		int categoryId;
		int currentTimings;
		Category category;

		synchronized (RestaurantService.class) {
			for(String  item :  getInputList()) {
				categoryId = getCategoryID(item,categoryList);
				category = getCategory(categoryId,categoryList);
				currentTimings = itemTiming;
				estimatedTime = getHighestTiming(currentTimings,category,estimatedTime);
			}
		}
		log.info("-----Order Estimated Succesfully-----");
		return estimatedTime;
	}

	/**
	 * getCategoryID  is  used  to  get  the  categoryId  based  on  itemname
	 * @param item
	 * @param categoryList
	 * @return  categoryId
	 */
	public Integer getCategoryID(String item, List<Category> categoryList) {
		categoryList.stream().forEach(action -> 
		action.getItems().forEach(it ->{
			if(it.getItemName().equals(item)) {
				categoryId =  it.getCategoryId();
				itemTiming = it.getTimeRequired();
			}
		}));
		return categoryId;
	}

	/**
	 * getCategory is  used  to  get  category  based  on  categoryId
	 * @param categoryId
	 * @param categoryList
	 * @return category
	 */
	public Category getCategory(Integer categoryId, List<Category> categoryList) {
		categoryList.stream().forEach(action -> {
			if(action.getCategoryId() == categoryId) {
				category =  action;
			}
		});
		return category;
	}

	/**
	 * getHighestTiming is  used  to  find  the highestTiming
	 * @param currentTimings
	 * @param category
	 * @param highestCookingTimes
	 * @return  highestTime
	 */
	private  int getHighestTiming(int currentTimings, Category category, int highestCookingTimes) {
		int timings[] = new int[category.getChefs()];
		Arrays.sort(timings);
		timings[RestautantConstant.ZERO] = timings[RestautantConstant.ZERO] + currentTimings;
		if(category.getChefs() > RestautantConstant.ONE) {
			currentTimings = timings[RestautantConstant.ZERO] > timings[timings.length-1] ? timings[RestautantConstant.ZERO] : timings[timings.length-1];			
		}else {
			currentTimings = timings[RestautantConstant.ZERO];
		}
		//category.setWorkloadForEachChef(timings);
		return currentTimings > highestCookingTimes ? currentTimings : highestCookingTimes;
	}

	/**
	 * orderSummary is  used  to  print  the  order summary
	 * @param requiredTime
	 */
	public void orderSummary(Integer requiredTime) {
		log.info("-----Writing the  Order Summary-----");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
		String CurrentSystemTime = LocalDateTime.now().format(formatter);
		LocalTime localTime = LocalTime.parse(CurrentSystemTime.substring(RestautantConstant.ZERO,5));
		log.info("==========Order Estimation=========================");
		log.info("Order Received  at  "+LocalDateTime.now().format(formatter)+"");
		log.info("Items  and  Quantity  :");
		getInputList().stream().forEach(action -> System.out.println(""+action+""));
		log.info("Total Time Required to prepare Order : "+ requiredTime+" Minutes");
		log.info("Order Estimated Delivery at "+formatter.format(localTime.plusMinutes(requiredTime))+" ");
		log.info("===================================================");
	}


	/**
	 * getInputList  is  used  to  return  the  input list
	 * @return list
	 */
	public  List<String>  getInputList(){
		List<String>  itemList =  new LinkedList<String>();
		itemList.add("Chicken Briyani");
		itemList.add("Tea");
		itemList.add("Bajji");
		itemList.add("Apple");
		return itemList;
	}


}
