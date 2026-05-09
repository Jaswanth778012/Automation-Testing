package com.kodnest.TestNGConcept.POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void login()
	{
//		LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory(driver);
		
		LoginPageWithPageFactory login = new LoginPageWithPageFactory(driver);
		
		login.username("jaswanthkumarpothina12@gmail.com");
		
		login.password("Jaswanth@2024");
		
		login.click();
		
		 WebElement name = driver.findElement(By.xpath("//h2[normalize-space()='My Account']"));
		
		Assert.assertTrue(name.isDisplayed());
	}
	
	@AfterClass
	public void quit()
	{
		driver.quit();
	}
}
