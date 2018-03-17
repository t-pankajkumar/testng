package com.testngex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TestNgExGroup {

	@BeforeTest
	public void b4() {
		System.out.println("B 4");
	}

	@Test(priority = 0,groups= {"priority1"})
	public void open() {
		System.out.println("Hello");
	}
	
	@Test(priority = 1)
	public void world() {
		System.out.println("World");
	}
	
	@Test(dependsOnMethods={"world"})
	public void openbr() {
		System.out.println("World BR");
	}
	
	@Test(enabled = false)
	public void worldEn() {
		System.out.println("Enabled");
	}
	
	@Test(timeOut = 1000)
	public void timerelated() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Timerelated");
	}
	
	@AfterTest
	public void after() {
		System.out.println("After");
	}
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData("D:/sampledoc.xls","Sheet1");
		return arrayObject;
	}

	/**
	 * @param File Name
	 * @param Sheet Name
	 * @return
	 */
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheetName);
			XSSFRow shh = sh.getRow(0);
			int totalNoOfCols = shh.getLastCellNum();
			
			int totalNoOfRows = sh.getLastRowNum() + 1;
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					//arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		return arrayExcelData;
	}

}
