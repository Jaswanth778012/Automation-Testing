package com.kodnest.TestNGConcept.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory {
	
	WebDriver driver;
	
	//Constructor
	LoginPageWithPageFactory(WebDriver driver)
	{
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//Locator
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement button;
	
	// Actions
	
	public void username(String user)
	{
		username.sendKeys(user);
	}
	
	public void password(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void click()
	{
		button.click();
	}

}
