package com.kodnest.mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().window().maximize();
		
		WebElement link = driver.findElement(By.linkText("jqueryui"));
		
		Actions act = new Actions(driver);
		
		act.contextClick(link).perform();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
