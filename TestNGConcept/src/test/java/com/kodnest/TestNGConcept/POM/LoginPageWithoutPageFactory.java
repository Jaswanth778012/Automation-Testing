package com.kodnest.TestNGConcept.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageWithoutPageFactory {
	
	WebDriver driver;
	
	// Constructor
	public LoginPageWithoutPageFactory(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// locator
	By username = By.xpath("//input[@id='input-email']");
	By password = By.xpath("//input[@id='input-password']");
	By button = By.xpath("//input[@value='Login']");
	
	//Actions
	
	public void username(String user)
	{
		driver.findElement(username).sendKeys(user);
	}
	
	public void password(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void click()
	{
		driver.findElement(button).click();
	}

}
