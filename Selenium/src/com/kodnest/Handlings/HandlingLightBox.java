package com.kodnest.Handlings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingLightBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.pinterest.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='lIkAnG eMU5i5 o5UlW_ hL1e7w'][normalize-space()='Log in']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='VHreRh cLlqFI XjRT60']//*[name()='svg']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(text(),'Explore')]")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
