package com.kodnest.TestNGConcept.sirQuestion;

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

public class EndToEndTest {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void url() {
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://automationexercise.com/");
	    driver.manage().window().maximize();
	}
	
	
	@Test(priority = 1)
	public void register() {
		
		String actualUrl = driver.getCurrentUrl();
		
		String expectedUrl = "https://automationexercise.com/";
		
		Assert.assertEquals(actualUrl, expectedUrl, "Not a Valid Url");	
		
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("jaswanth");
		
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("jame4@example.com");
		
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
		
		driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("James");
		
		driver.findElement(By.id("first_name")).sendKeys("John");
		
		driver.findElement(By.id("last_name")).sendKeys("Doe");
		
		driver.findElement(By.id("address1")).sendKeys("Abc Street");
		
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Karnataka");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Banglore");
		
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("560029");
		
		driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1589892325");
		
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
		
		WebElement text = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));

		Assert.assertTrue(text.isDisplayed(), "Account not created");
		
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
	}
	
	@Test(priority = 2, dependsOnMethods = "register")
	public void login() {
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("jame4@example.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("James");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement loggedUser = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//a[contains(text(),'Logged in as')]")));

		Assert.assertTrue(loggedUser.isDisplayed(), "Login failed");
		
		
	}
	
	@Test(priority= 3, dependsOnMethods = "login")
	public void addToCart() {
		driver.findElement(By.xpath("//a[normalize-space()='Men']")).click();
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.elementToBeClickable(
			    By.xpath("//a[contains(text(),'Tshirts')]"))).click();
		
		driver.findElement(By.linkText("View Product")).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
		

		WebElement message = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//p[contains(text(),'Your product has been added to cart')]")
		    )
		);

		String item = message.getText();

		Assert.assertEquals(item.trim(), "Your product has been added to cart.", "Item Not added to Cart");
		driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
	}
	
	@Test(priority=4, dependsOnMethods="addToCart")
	public void checkout() {
		driver.findElement(By.xpath("//a[normalize-space()='Proceed To Checkout']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();
	}
	
	@Test(priority=5, dependsOnMethods="checkout")
	public void payment() {
		driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Javeed");
		
		driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("6498498498545");
		
		driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("152");
		
		driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("12");
		
		driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("2028");
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		String confirmed = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']")).getText();
		
		Assert.assertEquals(confirmed, "Congratulations! Your order has been confirmed!", "Payment Failed Order Not placed");
		
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
	}
	
	
	@AfterTest
	public void logout() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
		driver.quit();
	}
}
