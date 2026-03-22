package com.kodnest.Handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().window().maximize();
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("kodnest");
		
		Thread.sleep(3000);
		
//		driver.findElement(By.id("alert1")).click();
		
		searchBox.clear();
		
		String retrivedText = driver.findElement(By.id("pah")).getText();
		
		System.out.println(retrivedText);
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		
		System.out.println(url);
		
		boolean isDisplayed = driver.findElement(By.id("but1")).isDisplayed();
		
		System.out.println(isDisplayed);
		
		boolean isEnabled = driver.findElement(By.id("but2")).isEnabled();
		
		System.out.println(isEnabled);
		
		boolean isSelected = driver.findElement(By.id("checkbox2")).isSelected();
		
		System.out.println(isSelected);

	}

}
