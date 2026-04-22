package com.kodnest.ApachePOI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DataProviderConcept {
	
	WebDriver driver;
		@BeforeClass
		public void setUp()
		{
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		}
		
		@Test(dataProvider = "dp1", dataProviderClass = DBUtilty.class)
		public void login(String email, String password) throws InterruptedException
		{
			driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
			
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			
			boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
			
			if(status)
			{
				driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
				
				driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")).click();
				
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
			
		}
		
		
		@AfterClass
		public void quit()
		{
			driver.quit();
		}
		
//		@DataProvider(name = "dp1")
//		Object[][] loginData()
//		{
////			Object data[][]  = {
////					{"abc@gmail.com", "test123"},
////					{"xyz@gmail.com", "test12"},
////					{"sandesh1@kodnest.com","qazwsxedc"},
////					{"James@gmail.com","test1"}
////			};
//			
//			
//			
////			return data;
//		}
		
		


}
