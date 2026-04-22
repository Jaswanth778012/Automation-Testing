package com.kodnest.TestNGConcept.parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	WebDriver driver;
	
	@BeforeMethod
	public void url()
	{
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test(dataProvider="ap1")
	public void login(String email, String password)
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("input-email")).sendKeys(email);
		
		driver.findElement(By.id("input-password")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		
		if(status)
		{
			driver.findElement(By.xpath("//a[@title='My Account']")).click();
			
			driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")).click();
			
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@DataProvider(name = "ap1")
	Object[][] data()
	{
		Object[][] arr = {
				{"abc@gmail.com", "test123"},
				{"xyz@gmail.com", "test12"},
				{"sandesh1@kodnest.com","qazwsxedc"},
				{"James@gmail.com","test1"}
		};
		
		return arr;
	}
	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}
}
