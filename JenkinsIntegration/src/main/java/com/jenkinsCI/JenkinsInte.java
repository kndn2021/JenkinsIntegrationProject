package com.jenkinsCI;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JenkinsInte {

	WebDriver driver;
	Logger logs;
	
	
	@BeforeMethod
	public void setDrivers()
	{
		logs = LogManager.getLogger(JenkinsInte.class);
		DOMConfigurator.configure("log4j2.xml");
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		logs.info("Chrome driver is initiated...");
		
		driver.manage().window().maximize();
		logs.info("Screen is maximized...");
		
		driver.manage().deleteAllCookies();
		logs.info("All cookies are deleted...");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logs.warn("Time duration is upto 30 seconds...");
		
		driver.get("https://github.com/login");
		logs.info("Url entered successfully...");
	}
	
	@Test
	public void exec()
	{
		driver.findElement(By.name("login")).sendKeys("Kundan");
		logs.info("Username entered successfully...");
		
		driver.findElement(By.id("password")).sendKeys("passeword");
		logs.info("Password entered successfully...");
		
		driver.findElement(By.name("commit")).click();
		logs.info("Clicked on submit button...");
		
	}
	
	@AfterMethod
	public void tearDrivers()
	{
		driver.close();
		logs.warn("Browser session is closed...");
	}
	
}
