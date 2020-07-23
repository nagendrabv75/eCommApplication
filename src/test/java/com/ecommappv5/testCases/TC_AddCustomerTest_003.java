package com.ecommappv5.testCases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommappv5.pageObjects.AddcustomerPage;
import com.ecommappv5.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends baseClass
{

	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		driver.get(baseURL);
		
		
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).clear();

		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		
		lp.setPassword(password);
		logger.info("password is provided");
		
		lp.clickLogin();
		
		logger.info("providing customer details....");
		Thread.sleep(5000);
		
		AddcustomerPage addcust=new AddcustomerPage(driver);
		
		addcust.clickOnCustomersMenu();
		addcust.clickOnCustomersMenuItem();
		
		addcust.clickOnAddnew();
		Thread.sleep(3000);
		
		addcust.exPand();
		
		
		String email = "Nag30" + "@gmail.com";
		addcust.setEmail(email);
				
		addcust.setPassword("test123");

		addcust.setCustomerRoles("Guest");
		
		addcust.setManagerOfVendor("Vendor 2");
		
		addcust.setGender("Male");
		
		addcust.setFirstName("Naggi");
		addcust.setLastName("Venugopal");
		
		addcust.setDob("01/05/1985"); // Format: D/MM/YYY
		
		addcust.setCompanyName("busyQA");
		addcust.setAdminContent("This is for testing.........");
		Thread.sleep(3000);
		
		addcust.exPand();
		
	
		addcust.clickOnSave();
		
		logger.info("validation started....");
				
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("test case failed....");
		}
				
	}
	
	
	
	
}
