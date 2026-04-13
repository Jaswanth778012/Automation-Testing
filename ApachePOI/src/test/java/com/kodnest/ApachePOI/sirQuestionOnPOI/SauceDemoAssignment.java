package com.kodnest.ApachePOI.sirQuestionOnPOI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemoAssignment {
	
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void url()
	{
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1)
	public void login() {
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		String url = driver.getCurrentUrl();
		
		Assert.assertTrue(url.contains("inventory"), "url is invalid");
	}
	
	
	@Test(priority=2, dependsOnMethods="login")
	public void addproduct()
	{
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		
		 String card = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		 
		 int value = Integer.parseInt(card);
		 
		 Assert.assertEquals(value, 1, "Cart Badge not working");
	}
	
	@Test(priority=3, dependsOnMethods="addproduct")
	public void checkOut()
	{
			WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='shopping_cart_link']")));

			wait.until(ExpectedConditions.elementToBeClickable(cart));
			cart.click();
		    
		    String after = driver.getCurrentUrl();
		    
		    System.out.println(after);

		    WebElement checkoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));

		    checkoutBtn.click();
		    
		    String url = driver.getCurrentUrl();
		    
		    Assert.assertTrue(url.contains("checkout"),"Checkout is not working");
	}
	
	@Test(priority=4)
	public void loginInvalid() {
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_s");
		
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-message-container error']")));
		
		Assert.assertTrue(ele.isDisplayed(), "Mssg is not displayed");
	}
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}

}
