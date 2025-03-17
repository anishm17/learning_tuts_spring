package entity;

import java.util.Map;

public class Category {
	
	
	private int categoryId;
	private int chefs;
	private Map<String, Integer> itemsPreparationTiming;
	private int[] workloadForEachChef;


	public Category() {

	}

	public Category(int categoryId, int chefs, Map<String, Integer> itemsPreparationTiming) {
		super();
		this.categoryId = categoryId;
		this.chefs = chefs;
		this.itemsPreparationTiming = itemsPreparationTiming;
		this.workloadForEachChef = new int[chefs];
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getChefs() {
		return chefs;
	}

	public void setChefs(int chefs) {
		this.chefs = chefs;
	}

	public Map<String, Integer> getItemsPreparationTiming() {
		return itemsPreparationTiming;
	}

	public void setItemsPreparationTiming(Map<String, Integer> itemsPreparationTiming) {
		this.itemsPreparationTiming = itemsPreparationTiming;
	}

	public int[] getWorkloadForEachChef() {
		return workloadForEachChef;
	}

	public void setWorkloadForEachChef(int[] workloadForEachChef) {
		this.workloadForEachChef = workloadForEachChef;
	}
}
