package com.kodnest.TestNGConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestNg1st {
	
	WebDriver driver = new ChromeDriver();
	
	@Test(priority = 1)
	public void openUrl() {	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(priority = 2, dependsOnMethods = "openUrl")
	public void verifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		
		Assert.assertNotNull(logo, "Logo element is not found");
		
		// method 2
//		int height = logo.getSize().getHeight();
//		int width = logo.getSize().getWidth();
//		
//		Assert.assertTrue(height > 0 && width > 0, "logo is not visible");
		
		System.out.println("Logo is verified");
	}
	
	@Test(priority = 3, dependsOnMethods = "verifyLogo")
	public void login() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority = 4)
	public void logout() throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
		System.out.println("Logout successfull");
	}
	
	@AfterClass
	public void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
}
