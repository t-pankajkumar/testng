package com.testngex;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgEx {

	@BeforeTest
	public void b4() {
		System.out.println("B 4");
	}

	@Test(priority = 0)
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

}
