package com.kodnest.TestNGConcept.sirQuestion;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TakingScreenShot {
	
	WebDriver driver;
	
	@BeforeClass
	public void test()
	{
		driver = new ChromeDriver();
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	
	@Test
	public void testImage()
	{
		boolean ele = driver.findElement(By.xpath("//img[@src='pic.png']")).isDisplayed();
		
		Assert.assertTrue(ele);
		
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='pic.png']"));
		
		File file = ele1.getScreenshotAs(OutputType.FILE);
		
		File f = new File(System.getProperty("user.dir")+"/pics/scrren.png");
		
		file.renameTo(f);
	}
	
	@AfterClass
	public void quit()
	{
		driver.quit();
	}

}
