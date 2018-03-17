package com.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewExcelTesting {
	WebDriver driver;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static FileInputStream fis;
	static XSSFRow row;
	static XSSFCell value;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pankajkumar\\Documents\\chromedriver.exe");
		
		NewExcelTesting net = new NewExcelTesting();
		net.formsubmit();

	}
	
	public void formsubmit() {
		driver = new ChromeDriver();
		for (int i = 1; i <= 4; i++) {
			driver.navigate().to("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
			driver.findElement(By.id("title")).sendKeys(getCellData(i, 0));
			driver.findElement(By.id("description")).sendKeys(getCellData(i, 1));
			driver.findElement(By.id("btn-submit")).click();
			
			String validation = driver.findElement(By.className("validation-error")).getText();
			Assert.assertEquals(validation.contains("*"), false);
			
			long start = System.currentTimeMillis();
			
			WebDriverWait wd = new WebDriverWait(driver, 5);
			wd.until(ExpectedConditions.textMatches(By.id("submit-control"), Pattern.compile("Form submited Successfully!")));
			
			String success_message = driver.findElement(By.id("submit-control")).getText();
			System.out.println(validation);
			Assert.assertEquals(success_message.contains("Form submited Successfully!"), true);
			System.out.println(validation);
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		}
		
	}

	public static String getCellData(int rownum, int colnum) {
		try {
			fis = new FileInputStream("C:\\Users\\pankajkumar\\Downloads\\excel.xlsx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet("Sheet1");
		row = sheet.getRow(rownum);
		value = row.getCell(colnum);
		return value.getStringCellValue();
	}

}
