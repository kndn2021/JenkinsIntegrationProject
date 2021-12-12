package com.jenkinsCI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JenkinsInte {

	WebDriver driver;
	
	@BeforeMethod
	public void setDrivers()
	{
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://github.com/login");
	}
	
	@Test
	public void exec()
	{
		driver.findElement(By.name("login")).sendKeys("Kundan");
		driver.findElement(By.id("password")).sendKeys("passeword");
		driver.findElement(By.name("commit")).click();
		
	}
	
	@AfterMethod
	public void tearDrivers()
	{
		driver.close();
	}
	
}
