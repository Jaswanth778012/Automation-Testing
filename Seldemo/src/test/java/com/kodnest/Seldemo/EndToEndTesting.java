package com.kodnest.Seldemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndToEndTesting {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://tutorialsninja.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("https://tutorialsninja.com/demo")).click();
		
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
		driver.findElement(By.id("input-email")).sendKeys("pothinajaswanth123@gmail.com");
		
		driver.findElement(By.id("input-password")).sendKeys("Jaswanth@2024");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		
		searchBox.click();
		searchBox.sendKeys("hp");
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		String text = "hp lp3065";
		String Currenttext = driver.findElement(By.xpath("//div[@class='caption']//a[contains(text(),'HP LP3065')]")).getText().toLowerCase();
		
		System.out.println(Currenttext);
		
		if(text.equals(Currenttext)) {
			driver.findElement(By.xpath("//div[@class='caption']//a[contains(text(),'HP LP3065')]")).click();
			
			WebElement Quantity = driver.findElement(By.id("input-quantity"));
			
			Quantity.clear();
			
			Quantity.sendKeys("2");
			
			driver.findElement(By.id("button-cart")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


			WebElement msg = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//div[contains(@class,'alert-success')]")
			    )
			);

			boolean alert = msg.isDisplayed();
			
			System.out.println(alert);
			
			if(alert == true)
			{
				driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
				
				driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
				
				driver.findElement(By.xpath("//input[@id='button-payment-address']")).click();
				
				driver.findElement(By.xpath("//input[@id='button-shipping-address']")).click();
				
				driver.findElement(By.id("button-shipping-method")).click();
				
				
				WebElement check = driver.findElement(By.xpath("//input[@name='agree']"));
				
				if(!check.isSelected()) {
				    check.click();
				}
				
				driver.findElement(By.id("button-payment-method")).click();
				
				driver.findElement(By.xpath("//input[@id='button-confirm']")).click();
			}
			else
			{
				System.out.println("Not visible and not added to cart");
			}
		}
		else
		{
			System.out.println("Item is not selected");
		}
		
		driver.quit();
		
	}

}
