package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import constants.RestautantConstant;

/**
 * PropertyConfigReader is used  to  read  the  data  from  the  DB
 * @author Anish M
 *
 */
public class PropertyConfigReader {

	static HSSFWorkbook workbookBook ; 
	static HSSFSheet workbookSheet ; 
	static Map<String,Integer>  categoryIdMap ;
	static Map<String,Integer>  itemsCategoryMap ;
	static Map<String,Integer>  inputTestCaseMap;


	/**
	 * getChefsData  is  used  to  get  the  chefs Data
	 * @return map
	 * @throws IOException
	 */
	public static Map<String,Integer> getChefsData() throws IOException  {
		Map<String,Integer>  chefsMap =  new HashMap<String, Integer>();
		categoryIdMap =  new HashMap<String, Integer>();

		workbookSheet = workbookBook.getSheetAt(RestautantConstant.ZERO);
		HSSFRow row ;

		for(int idx = RestautantConstant.ONE  ; idx  < workbookSheet.getPhysicalNumberOfRows()  ;  idx ++ ) {
			row = workbookSheet.getRow(idx);
			chefsMap.put(row.getCell(0).getStringCellValue(), (int) row.getCell(1).getNumericCellValue());
			categoryIdMap.put(row.getCell(0).getStringCellValue(), (int) row.getCell(2).getNumericCellValue());
		}
		return chefsMap;
	}


	/**
	 * getItemsData  is  used  to  get  the  items Data
	 * @return map
	 * @throws IOException
	 */
	public static Map<String, Map<String,Integer>> getItemsData() throws IOException {
		itemsCategoryMap =  new HashMap<String, Integer>();
		Map<String,Integer>  itemsTimeMap  =  new HashMap<String, Integer>() ;
		Map<String, Map<String,Integer>>  ItemsDataMap  =  new HashMap<>();

		workbookSheet = workbookBook.getSheetAt(RestautantConstant.ONE);
		HSSFRow row ;

		for (Entry<String, Integer> entry : categoryIdMap.entrySet()) {
			int categoryId =  entry.getValue();
			String categoryName = getKey(categoryId);
			itemsTimeMap  =  new HashMap<String, Integer>();

			for(int idx =  RestautantConstant.ONE  ; idx  < workbookSheet.getPhysicalNumberOfRows()  ;  idx ++ ) {

				row = workbookSheet.getRow(idx);
				if(row.getCell(2).getNumericCellValue() == categoryId ) {
					itemsTimeMap.put(row.getCell(0).getStringCellValue(),  (int) row.getCell(1).getNumericCellValue());
					itemsCategoryMap.put(row.getCell(0).getStringCellValue(), categoryId);

				}
			}
			ItemsDataMap.put(categoryName, itemsTimeMap);
		}
		return ItemsDataMap;
	}


	/**
	 * getInputTestCaseData  is  used  to  get  the  inputData
	 * @return map
	 * @throws IOException
	 */
	public static Map<String,Integer> getInputTestCaseData() throws IOException  {
		inputTestCaseMap =  new LinkedHashMap<String, Integer>();
		workbookSheet = workbookBook.getSheetAt(RestautantConstant.TWO);
		HSSFRow row ;

		for(int idx =  RestautantConstant.ONE  ; idx  < workbookSheet.getPhysicalNumberOfRows()  ;  idx ++ ) {
			row = workbookSheet.getRow(idx);
			inputTestCaseMap.put(row.getCell(0).getStringCellValue(), (int) row.getCell(1).getNumericCellValue());
		}
		return inputTestCaseMap;
	}


	/**
	 * getCategoryIdData  returns  categoryId  data
	 * @return map
	 */
	public static Map<String,Integer> getCategoryIdData(){
		return  categoryIdMap;
	}

	/**
	 * getItemCatgoryData  returns  Items  data
	 * @return map
	 */
	public static Map<String,Integer> getItemCatgoryData(){
		return  itemsCategoryMap;
	}


	/**
	 * getKey returns the   key for  the  value
	 * @param categoryId
	 * @return String
	 */
	public static String getKey(int categoryId) {
		for (Entry<String, Integer> entry : categoryIdMap.entrySet()) {
			if (entry.getValue().equals(categoryId)) {
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * getWorkBook  is  used to   get  the  workbook sheet
	 * @return workbook
	 * @throws IOException
	 */
	public static   HSSFWorkbook  getWorkBook() throws IOException {
		try {
			workbookBook = new HSSFWorkbook(new FileInputStream(""+System.getProperty("user.dir")+"/properties.xls"));
		} catch (FileNotFoundException e) {
			System.out.println("File not  found ....");
			throw new FileNotFoundException();
		} catch (IOException e) {
			throw new IOException();
		}
		return workbookBook;

	}

	static{
		try {
			getWorkBook();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
