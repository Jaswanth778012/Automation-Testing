package com.kodnest.TestNGConcept.parameterization;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecutionConcept {
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"param"})
	public void open(String br)
	{
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver();
		break;
		case "edge": driver = new EdgeDriver();
		break;
		default: System.out.println("Invalid browser");
		return;
		}
//		driver = new ChromeDriver();
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
	
	@Test(priority=3)
	void titleTest()
	{
		@Nullable
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Kodnest Selenium Demo");
	}
	
	@Test(priority=4)
	void urlTest()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://iamsandesh23.github.io/selenium.github.io/");
	}
	
	@AfterClass
	public void quit()
	{
		driver.quit();
	}
}
