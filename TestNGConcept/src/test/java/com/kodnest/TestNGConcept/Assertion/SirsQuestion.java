package com.kodnest.TestNGConcept.Assertion;

import java.io.File;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SirsQuestion {

	WebDriver driver;
	
	@BeforeTest
	public void login() {
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://academybugs.com/find-bugs/");
		
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void validate() {
		driver.findElement(By.xpath("//h3[@class='ec_product_title_type1']//a[@class='ec_image_link_cover'][normalize-space()='Dark Grey Jeans']")).click();
		
		driver.findElement(By.xpath("//input[@value='+']")).click();
		
		driver.findElement(By.xpath("//input[@value='ADD TO CART']")).click();
	}
	
	@Test(priority = 2)
	public void screenshot() {
		
		driver.findElement(By.xpath("//input[@value='+']")).click();
		
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement ele1 = driver.findElement(By.xpath("//div[contains(@id,'ec_cartitem_update')]"));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele1));
		
		element.click();
		

		    WebElement qtyElement = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//input[contains(@class,'ec_quantity')]")
		        )
		    );

		    String value = qtyElement.getAttribute("value");
		
		Assert.assertEquals(value, "2");
		
		WebElement ele = driver.findElement(By.xpath("//td[@class='ec_cartitem_quantity']"));
		
		File f = ele.getScreenshotAs(OutputType.FILE);

		File fs = new File(System.getProperty("user.dir") 
		        + "/pics/sir.png");

		f.renameTo(fs);
	}
	
	@AfterTest
	public void logout() {
		driver.quit();
	}
}
