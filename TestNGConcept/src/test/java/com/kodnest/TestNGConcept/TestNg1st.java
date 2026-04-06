package com.kodnest.TestNGConcept;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestNg1st {
	
	WebDriver driver;
	boolean isLogo = false;
	
	@Test(priority = 1)
	public void openUrl() {	
		driver  = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(priority = 2, dependsOnMethods = "openUrl")
	public void verifyLogo() {
		try {
			
			WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
			
			int height = logo.getSize().getHeight();
			System.out.println(height);
			int width = logo.getSize().getWidth();
			System.out.println(width);
			
			
			if(height >= 0 && width > 0) {
				isLogo = true;
				System.out.println("Logo is validated");
			}
			else
			{
				isLogo = false;
				System.out.println("Logo is not validated");
			}
		}
		catch(Exception e) {
			isLogo = false;
			
			System.out.println("Logo is Invalid");
			
			throw new RuntimeException(e);
		}
		
		
	}
	
	@Test(priority = 3, dependsOnMethods = "verifyLogo")
	public void login() {
		
		if(!isLogo) {
			throw new RuntimeException("Skipping login due to logo failure");
		}
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
	}
	
	@Test(priority = 4, dependsOnMethods = "login")
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
