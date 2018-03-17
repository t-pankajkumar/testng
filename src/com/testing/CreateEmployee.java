package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEmployee {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pankajkumar\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost/Sumo-Payroll/public");
		driver.findElement(By.id("email")).sendKeys("nokia@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("btn-login")).click();
		
		driver.navigate().to("http://localhost/Sumo-Payroll/public/employees/create");
		
		Select s = new Select(driver.findElement(By.id("work_location_id")));
		s.selectByValue("80");
		
		driver.findElement(By.id("fname")).sendKeys("Pankaj");
		driver.findElement(By.id("lname")).sendKeys("Kumar");
		driver.findElement(By.className("gender")).click();
		//driver.findElement(By.id("date_of_birth_table")).sendKeys("2017");
		//driver.findElement(By.xpath("//table[@id='date_of_birth_table']/tbody/tr/td[3]/div")).click();
		
		Select employee_type = new Select(driver.findElement(By.id("employee_type_id")));
		//;
		System.out.println(employee_type.getOptions());
		//(new Random()).nextInt(items.size())
		employee_type.selectByValue("6172");
		
		Select department_id = new Select(driver.findElement(By.id("department_id")));
		department_id.selectByValue("6159");
		
		driver.findElement(By.id("title")).sendKeys("Developer");
		
		driver.findElement(By.id("companyInternalID")).sendKeys("12345");
		
		Select payrollBatch = new Select(driver.findElement(By.id("payrollBatch")));
		payrollBatch.selectByValue("164");
	}

}
