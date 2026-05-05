package com.kodnest.TestNGConcept.extentReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestListener{
	
	WebDriver driver;
	@BeforeClass
	public void url()
	{
		driver = new ChromeDriver();
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void testUrl()
	{
		String url = driver.getCurrentUrl();
		
		Assert.assertEquals(url, "https://iamsandesh23.github.io/selenium.gith", "Not valid");
	}
	
	@Test(priority=2, dependsOnMethods="testUrl")
	public void testImg()
	{
		WebElement ele = driver.findElement(By.xpath("//img[@src='pic.png']"));
		
		Assert.assertTrue(ele.isDisplayed(), "Not Displayed");
	}
	
	@Test(priority=3)
	public void testTitle()
	{
		String title =driver.getTitle();
		
		Assert.assertEquals(title, "Kodnest Selenium Demo");
	}
	
	@AfterClass
	public void quit()
	{
		driver.quit();
	}
}
