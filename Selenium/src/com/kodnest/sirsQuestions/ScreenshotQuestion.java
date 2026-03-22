package com.kodnest.sirsQuestions;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotQuestion {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//section[@class='category-grid home-page-category-grid']//div[@class='item-grid']"));
		
		File fileSource = element.getScreenshotAs(OutputType.FILE);
		
		File f = new File(System.getProperty("user.dir") + "/pics/sirs.png");
		
		fileSource.renameTo(f);
		
		driver.quit();
	}

}
