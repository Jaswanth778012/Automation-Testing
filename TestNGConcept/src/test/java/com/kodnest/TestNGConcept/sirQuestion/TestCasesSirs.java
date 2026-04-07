package com.kodnest.TestNGConcept.sirQuestion;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCasesSirs {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void url() {
		
		driver = new ChromeDriver();
		
		driver.get("https://automationexercise.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void urlTest() {
		@Nullable
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, "https://automationexercise.com/", "Home page is not loaded");
		
	        
	}
	//Test case - 1
	@Test(priority=2, dependsOnMethods ="urlTest")
	public void register() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		
		WebElement signupText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[text()='New User Signup!']")));
		Assert.assertTrue(signupText.isDisplayed(), "Signup section not visible");
    
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("jaswanth");
		
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("jame5@example.com");
		
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
		
		WebElement accountText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[normalize-space()='Enter Account Information']")));
		
		Assert.assertTrue(accountText.isDisplayed(), "Account Info Page is not visible");
		
		driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("James");
		
		WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
		Select s = new Select(day);
		s.selectByVisibleText("1");
		
		WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
		
		Select s1 = new Select(month);
		s1.selectByVisibleText("February");
		
		WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
		
		Select s2 = new Select(year);
		s2.selectByVisibleText("2003");
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		driver.findElement(By.id("first_name")).sendKeys("John");
		
		driver.findElement(By.id("last_name")).sendKeys("Doe");
		
		driver.findElement(By.id("address1")).sendKeys("Abc Street");
		
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Karnataka");
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Banglore");
		
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("560029");
		
		driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("1589892325");
		
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
		
		WebElement createmsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[normalize-space()='Account Created!']")));
		Assert.assertTrue(createmsg.isDisplayed(), "Account not created");
	
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		
		WebElement loggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]")));
	    Assert.assertTrue(loggedIn.isDisplayed(), "Login not successful");
	    
	    driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
	    
	    WebElement deletetext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[normalize-space()='Account Deleted!']")));
	    
	    Assert.assertTrue(deletetext.isDisplayed(), "Account not deleted");
	    
	    driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
	}
	
	@Test(priority=3, dependsOnMethods = "register")
	public void loginWithCorrect() {
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		
		WebElement loginText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[normalize-space()='Login to your account']")));
		Assert.assertTrue(loginText.isDisplayed(), "login section not visible");
		
		
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("jame4@example.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("James");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		WebElement logged_in = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logged in as')]")));
		
		Assert.assertTrue(logged_in.isDisplayed(), "User logged in is not visible");
		
		driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
		
		WebElement deletetext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[normalize-space()='Account Deleted!']")));
	    
	    Assert.assertTrue(deletetext.isDisplayed(), "Account not deleted");
	    
	    driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		
	}
	
	@Test(priority=4, dependsOnMethods="register")
	public void loginWithIncorrect() {
		driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
		
		WebElement loginText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[normalize-space()='Login to your account']")));
		Assert.assertTrue(loginText.isDisplayed(), "login section not visible");
		
		
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("jame8@example.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("James");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		WebElement errorMssg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")));
		
		Assert.assertTrue(errorMssg.isDisplayed(), "Error mssg not displayed");
	}
}
