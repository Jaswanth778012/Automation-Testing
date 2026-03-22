package com.kodnest.Handlings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MSBAndDropDownHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
//		WebElement element = driver.findElement(By.id("drop1"));
//		
//		Select s = new Select(element);
		
//		s.selectByVisibleText("doc 3");
//		s.selectByIndex(3);
		
		WebElement msb = driver.findElement(By.id("multiselect1"));
		
		Select s = new Select(msb);
		
		s.selectByVisibleText("Volvo");
		s.selectByVisibleText("Swift");
		s.selectByVisibleText("Audi");
	}

}
