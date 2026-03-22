package com.kodnest.Handlings;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Blogger")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		
		Iterator<String> window = windowIds.iterator();
		
//		while(window.hasNext()) {
//			String windowId = window.next();
//			System.out.println(windowId); // it will be used when there is multiple windows that we dont know the windowid is required to switch
//		}
		
		String parentWindow = window.next();
		
		String childWindow = window.next();
		
		driver.switchTo().window(childWindow);
		
		String text = driver.findElement(By.xpath("//h2[normalize-space()='Publish your passions, your way']")).getText();
		
		System.out.println(text);
		
		driver.quit();
	}

}
