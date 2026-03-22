package com.kodnest.mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		 
//		Point leftElement = driver.findElement(By.xpath("//div[@id='HTML7']//span[1]")).getLocation();
//		System.out.println(leftElement);
		
		WebElement leftElement = driver.findElement(By.xpath("//div[@id='HTML7']//span[1]"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDropBy(leftElement, -100, 0).perform();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
