package business;

import static config.PropertyConfigReader.getInputTestCaseData;
import static config.PropertyConfigReader.getItemCatgoryData;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import constants.RestautantConstant;
import entity.Category;

/**
 * OrderOuptutExecutor  is  used  to  generate  the  order  estimation
 * @author Anish M
 *
 */
public class OrderOuptutExecutor {

	/**
	 * estimateOrderRequest  is  used  to   calculate  the  estimated  time
	 * @param categoryMap
	 * @return  integer
	 * @throws IOException
	 */
	public  int estimateOrderRequest(Map<Integer, Category> categoryMap) throws IOException {

		int estimatedTime = RestautantConstant.ZERO;
		int categoryId;
		int currentTimings;
		Category category;

		
		
		synchronized (OrderOuptutExecutor.class) {
			for(String  item :  getOutputList()) {

				categoryId = getItemCatgoryData().get(item);
				category = categoryMap.get(categoryId);
				currentTimings = category.getItemsPreparationTiming().get(item);
				estimatedTime = getHighestTiming(currentTimings,category,estimatedTime);

			}
		}
		return estimatedTime;
	}

	/**
	 * getHighestTiming  is  used  to  calcluate  estimated  time  for  each  category
	 * @param currentTimings
	 * @param category
	 * @param highestCookingTimes
	 * @return  estimatedtime
	 */
	private  int getHighestTiming(int currentTimings, Category category, int highestCookingTimes) {
		int timings[] = category.getWorkloadForEachChef();
		Arrays.sort(timings);
		timings[RestautantConstant.ZERO] = timings[RestautantConstant.ZERO] + currentTimings;
		if(category.getChefs() > RestautantConstant.ONE) {
			currentTimings = timings[RestautantConstant.ZERO] > timings[timings.length-1] ? timings[RestautantConstant.ZERO] : timings[timings.length-1];			
		}else {
			currentTimings = timings[RestautantConstant.ZERO];
		}
		category.setWorkloadForEachChef(timings);
		return currentTimings > highestCookingTimes ? currentTimings : highestCookingTimes;
	}

	/**
	 * orderSummary  is  used to  display  the  order  summary and  estimation
	 * @param totalTiming
	 * @throws IOException
	 */
	public void orderSummary(Integer totalTiming) throws IOException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
		String CurrentSystemTime = LocalDateTime.now().format(formatter);
		LocalTime localTime = LocalTime.parse(CurrentSystemTime.substring(RestautantConstant.ZERO,5));
		System.out.println("==========Order Estimation=========================");
		System.out.println("Order Received  at  "+LocalDateTime.now().format(formatter)+"");
		System.out.println("Items  and  Quantity  :");
		getInputTestCaseData().entrySet().stream().forEach(action -> {System.out.println(""+action.getKey()+" "+action.getValue()+"");});
		System.out.println("Total Time Required to prepare Order : "+ totalTiming+" Minutes");
		System.out.println("Order Estimated Delivery at "+formatter.format(localTime.plusMinutes(totalTiming))+" ");
		System.out.println("===================================================");


	}


	/**
	 * getOutputList  is  used  to  get  the  output  list
	 * @return list
	 * @throws IOException
	 */
	private List<String> getOutputList() throws IOException {
		Map<String, Integer>  outMap =  getInputTestCaseData();
		return  outMap.keySet().stream().collect(Collectors.toList());
	}


}
