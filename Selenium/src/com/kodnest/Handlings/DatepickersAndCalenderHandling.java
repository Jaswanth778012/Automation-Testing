package com.kodnest.Handlings;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatepickersAndCalenderHandling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		// method : 1 by using the sendKeys
		driver.findElement(By.id("datepicker")).sendKeys("25/04/2025");
		
		// method 2: handling Calenders
		
		driver.findElement(By.id("datepicker")).click();
		
		String month = "December";
		String year = "2026";
		String date = "25";
		
		
		while(true) {
			String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(actualMonth.equals(month) && actualYear.equals(year)) {
				break;
			}
		
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			
		}
		
		// Handlingg dates
		
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		for(WebElement dt: alldates) {
			
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		
	}

}
