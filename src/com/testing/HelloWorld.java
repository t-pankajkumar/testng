package com.testing;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloWorld {
	WebDriver driver;

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pankajkumar\\Documents\\chromedriver.exe");

		/*
		 * driver.navigate().to("https://tin.tin.nsdl.com/oltas/");
		 * System.out.println(driver.getCurrentUrl());
		 * driver.findElement(By.xpath("//form[@name='form4']/input[@name='submit']")).
		 * click(); driver.findElement(By.id("TAN_NO")).sendKeys("DELS32663B"); Select s
		 * = new Select(driver.findElement(By.id("TAN_FROM_DT_DD")));
		 * s.selectByValue("01"); Select s1 = new
		 * Select(driver.findElement(By.id("TAN_FROM_DT_MM"))); s1.selectByValue("03");
		 * Select s2 = new Select(driver.findElement(By.id("TAN_FROM_DT_YY")));
		 * s2.selectByValue("2013"); Select b = new
		 * Select(driver.findElement(By.id("TAN_TO_DT_DD"))); b.selectByValue("08");
		 * Select b1 = new Select(driver.findElement(By.id("TAN_TO_DT_MM")));
		 * b1.selectByValue("07"); Select b2 = new
		 * Select(driver.findElement(By.id("TAN_TO_DT_YY"))); b2.selectByValue("2014");
		 * Random ran = new Random(); int x = ran.nextInt(10); System.out.println(x);
		 * try { Thread.sleep(2000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		// driver.close();
		
		HelloWorld hw = new HelloWorld();
		try {
			hw.runtest();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	public void runtest() throws Exception {
		ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=800,480");
 
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        
		driver = new ChromeDriver(cap);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.navigate().to("https://tin.tin.nsdl.com/oltas/");
		WebDriverWait wdw = new WebDriverWait(driver, 5);
		wdw.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("")));
		getscreenshot();
	}

	public void getscreenshot() throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("H:\\screenshot.png"));
	}

}
