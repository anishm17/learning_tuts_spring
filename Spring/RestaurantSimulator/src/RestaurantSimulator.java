import java.io.IOException;
import java.util.Map;

import business.EntityCreator;
import business.OrderOuptutExecutor;
import entity.Category;

/**
 * RestaurantSimulator  is  used  to  calculate  the  Order Estimation
 * @author Anish Mohan
 */
public class RestaurantSimulator {

	public static void main(String[] args) throws IOException {
		EntityCreator   entityCreator  =  new EntityCreator();
		OrderOuptutExecutor  orderOutput  =  new OrderOuptutExecutor();
		System.out.println("-----Welcome  to  Restaurant  Simulator-----");
		System.out.println("-----Reading Restaurant Data's from "+System.getProperty("user.dir")+"/properties.xls-----");
		entityCreator.readRestaurantData();
		System.out.println("-----Restaurant Data's Fetched Successfully-----");
		System.out.println("-----Creating  Entities  for  Categorys-----");
		Map<Integer, Category>  category =  entityCreator.createEntityData();
		System.out.println("-----Entities are  created based on Category-----");
		System.out.println("-----Estimating  the order----");
		Integer totalTimimg =  orderOutput.estimateOrderRequest(category);
		System.out.println("-----Order Estimated Succesfully-----");
		System.out.println("-----Writing the  Order Summary-----");
		orderOutput.orderSummary(totalTimimg);

	}
}
