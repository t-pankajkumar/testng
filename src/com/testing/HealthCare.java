package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HealthCare {
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pankajkumar\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://test7-order.asdhealthcare.com");
		driver.findElement(By.linkText("Log In")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("txtusername")).sendKeys("sherrytest500");
		driver.findElement(By.id("txtpassword")).sendKeys("welcome12");
		driver.findElement(By.id("btnlogin")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String bodyText = driver.findElement(By.xpath("//span[@itemprop='telephone']")).getText();
		System.out.println(bodyText);
		Assert.assertTrue(bodyText.contains("303.485.4084"), "Text not found!");
	}
}
