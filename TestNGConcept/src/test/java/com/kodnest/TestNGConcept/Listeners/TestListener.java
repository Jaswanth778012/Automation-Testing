package com.kodnest.TestNGConcept.Listeners;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(MyListenerClass.class)
public class TestListener {
	
WebDriver driver;
	
	@BeforeClass
	public void open()
	{
		driver = new ChromeDriver();
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=2)
	public void imgTest()
	{	
		boolean img = driver.findElement(By.xpath("//img[@src='pic.png']")).isDisplayed();
		
		Assert.assertTrue(img);
	}
	
	@Test(priority=4, dependsOnMethods="urlTest")
	void titleTest()
	{
		@Nullable
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Kodnest Selenium Demo");
	}
	
	@Test(priority=3)
	void urlTest()
	{
//		Assert.assertEquals(driver.getCurrentUrl(), "https://iamsandesh23.github.io/selenium.github.io/");
		Assert.fail();
	}
	
	@AfterClass
	public void quit()
	{
		driver.quit();
	}
}
