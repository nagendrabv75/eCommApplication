package com.ecommappv5.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class baseClass {

	
	public String baseURL="http://admin-demo.nopcommerce.com/";
	public String username="admin@yourstore.com";
	public String password="admin";
	
	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setupMethod()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver");
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		logger=Logger.getLogger("eCommAppV5");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void closeDown()
	{
		driver.close();
	}
	
	public static String randomestring()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
		
	}
	
}
