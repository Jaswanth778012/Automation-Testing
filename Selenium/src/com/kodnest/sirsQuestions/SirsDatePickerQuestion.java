package com.kodnest.sirsQuestions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SirsDatePickerQuestion {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		String month = "December";
		String year = "2026";
		
		
		String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String actualyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();	
		
		while (true) {
			if (actualMonth.equals(month) && actualyear.equals(year)) {
				break;
			} else {
				File file = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"))
						.getScreenshotAs(OutputType.FILE);

				File f = new File(System.getProperty("user.dir") + "/pics/date.png");

				file.renameTo(f);

				break;
			}
		}

		
	}

}
