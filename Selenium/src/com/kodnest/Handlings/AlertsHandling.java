package com.kodnest.Handlings;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alert1")).click();
		
		Alert ele = driver.switchTo().alert();
		
		Thread.sleep(3000);
		
		String text = ele.getText();
		
		System.out.println(text);
		
		Thread.sleep(3000);
		
		ele.accept();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
