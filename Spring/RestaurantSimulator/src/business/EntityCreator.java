package business;

import static config.PropertyConfigReader.getCategoryIdData;
import static config.PropertyConfigReader.getChefsData;
import static config.PropertyConfigReader.getInputTestCaseData;
import static config.PropertyConfigReader.getItemCatgoryData;
import static config.PropertyConfigReader.getItemsData;
import static config.PropertyConfigReader.getKey;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import entity.Category;

/**
 * EntityCreator  is  used  to  create  the entity  of  category
 * @author Anish M
 */
public class EntityCreator {

	static Map<String,Integer> chefsMap ;
	static Map<String,Integer> categoryIdMap ;
	static Map<String, Map<String,Integer>>  itemsMap;
	static Map<String,Integer>  itemsCategoryMap ;
	static Map<String,Integer>  inputTestCaseMap;


	/**
	 * readRestaurantData  is  used  to read the  data  of  input
	 * @throws IOException
	 */
	public  void readRestaurantData() throws IOException {
		chefsMap =   getChefsData();
		categoryIdMap  =getCategoryIdData();
		itemsMap=   getItemsData();
		itemsCategoryMap = getItemCatgoryData();
		inputTestCaseMap = getInputTestCaseData();
		
	}

	/**
	 * createEntityData  create  the  entity  for  each  category
	 * @return map
	 */
	public  Map<Integer, Category> createEntityData() {
		Map<Integer, Category> categoryMap = new HashMap<>();

		for(Entry<String,Integer> entry :  categoryIdMap.entrySet()) {
			Category  category  = new Category(categoryIdMap.get(entry.getKey()),
					chefsMap.get(entry.getKey()),
					getItemsPreparationTimingMap(getKey(categoryIdMap.get(entry.getKey()))));
			categoryMap.put(categoryIdMap.get(entry.getKey()), category);
		}
		return  categoryMap;
	}


	/**
	 * getItemsPreparationTimingMap returns  the  items and  preparation timing
	 * @param categoryName
	 * @return map
	 */
	public  Map<String, Integer> getItemsPreparationTimingMap(String categoryName) {
		Map<String,Integer> itemsPreparationTiming = new HashMap<>();
		Map<String,Integer>  map  =  itemsMap.get(categoryName);

		map.entrySet().forEach(mapData->{
			itemsPreparationTiming.put(mapData.getKey(), (int)mapData.getValue());
		});
		return itemsPreparationTiming;
	}

}
