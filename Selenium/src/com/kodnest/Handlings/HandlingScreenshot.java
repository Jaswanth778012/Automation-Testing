package com.kodnest.Handlings;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingScreenshot {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().window().maximize();
		
		TakesScreenshot sct = (TakesScreenshot)driver;
		
		File file = sct.getScreenshotAs(OutputType.FILE);
//		File f = new File("C://Users//JaswanthKumar//git//Automation-Testing//Selenium//pics/fullpage.png"); --> this is bad way to do because of hardcoding
		File f = new File(System.getProperty("user.dir") + "/pics/demo.jpg");
		
		file.renameTo(f);
		
		driver.quit();
	}

}
