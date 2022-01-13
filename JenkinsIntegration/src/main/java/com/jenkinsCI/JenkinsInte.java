package com.jenkinsCI;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class JenkinsInte {

	WebDriver driver;
	Logger logs;
//	TakesScreenshot ts;
	
	@Parameters("BrowserType")
	@BeforeMethod
	public void setDrivers(String browser)
	{
		logs = LogManager.getLogger(JenkinsInte.class);
		DOMConfigurator.configure("log4j2.xml");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			logs.info("Chrome driver is initiated...");
		}
		else
		{
			System.out.println("No driver found");
			System.exit(1;
		}
		
		driver.manage().window().maximize();
		logs.info("Screen is maximized...");
		
		driver.manage().deleteAllCookies();
		logs.info("All cookies are deleted...");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logs.warn("Time duration is upto 30 seconds...");
		
		driver.get("https://github.com/login");
		logs.info("Url entered successfully...");
		
	//	ts = (TakesScreenshot)driver;
	//	
	//	File file = ts.getScreenshotAs(OutputType.FILE);
	//	try {
	//		Files.move(file, new File("C:\\Users\\Bhushan\\git\\JenkinsIntegration\\JenkinsIntegration\\test-output\\screenshot\\github.png"));
	//	} catch (IOException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		
		logs.info("Screenshot taken successfully...");
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
