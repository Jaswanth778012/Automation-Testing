package com.kodnest.Handlings;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitingMechanismHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().window().maximize();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // it is a global wait
		
		driver.findElement(By.className("dropbtn")).click();
		
//		driver.findElement(By.linkText("Facebook")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // it will given to the particular element
//		
//		@Nullable
//		WebElement facebookElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
//		
//		facebookElement.click();
		
		
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		
		 WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.linkText("Facebook"));
			}
		});
		 
		 element.click();
		
		driver.close();
		
		

	}

}
