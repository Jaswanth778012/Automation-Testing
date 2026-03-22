package com.kodnest.Handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTwo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
//		driver.navigate().to("https://www.facebook.com/"); // navigate to the respective url
//		
//		Thread.sleep(3000);
//		
//		driver.navigate().back(); // navigate to back
//		
//		Thread.sleep(3000);
//		
//		driver.navigate().forward(); // navigate to front
//		
//		Thread.sleep(3000);
//		
//		driver.navigate().refresh(); // refresh the page
//		
//		Thread.sleep(3000);
		 
//		String res = driver.getPageSource(); // to get the source code of the webpage
//		
//		System.out.println(res);
		
		driver.findElement(By.id("input-email")).sendKeys("jaswanthKumar@gmail.com");
		Thread.sleep(3000);
		
		driver.findElement(By.id("input-password")).sendKeys("123356");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@value='Login']")).submit(); // when we have html forms only then only we have to use the submit() rather than click
		Thread.sleep(3000);
		
		driver.quit();

	}

}
