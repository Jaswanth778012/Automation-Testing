package com.kodnest.ApachePOI.sirQuestionOnPOI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderSirsQuestion {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
    	
    	ChromeOptions options = new ChromeOptions();

        // Disable notifications
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    @Test(dataProvider="dp")
    public void login(String email, String password) throws InterruptedException {

        driver.get("https://www.facebook.com/");

        WebElement loginText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[normalize-space()='Log in to Facebook']")
                ));

        Assert.assertTrue(loginText.isDisplayed());


        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("pass")).sendKeys(password);

        driver.findElement(By.xpath("//span[@class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft'][normalize-space()='Log in']")).click();
        
        
        
        boolean status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Jaswanth Kumar')]"))).isDisplayed();
        
        
        if(status)
        {
        	
        	WebElement profile = wait.until(
        		    ExpectedConditions.elementToBeClickable(
        		        By.xpath("//div[.//*[name()='svg' and @aria-label='Your profile']]")
        		    ));

        		((JavascriptExecutor)driver).executeScript("arguments[0].click();", profile);

        		WebElement logout = wait.until(
        		    ExpectedConditions.elementToBeClickable(
        		        By.xpath("//span[text()='Log out']")
        		    ));

        		((JavascriptExecutor)driver).executeScript("arguments[0].click();", logout);

        		wait.until(
        		    ExpectedConditions.elementToBeClickable(
        		        By.xpath("//span[contains(text(),'Use another profile')]")
        		    )).click();

        		Assert.assertTrue(true);
        }
        else
        {
        	Assert.fail();
        }
    }


    @DataProvider(name="dp")
    Object[][] data() {

        Object[][] dt = {

            {"1896591836", "James@123"},
            {"2158484549", "Jaga"},
            {"7780420127", "Jaswanth@2026"},
            {"1478663164", "vgxwuwvdj"},
            {"1549896326", "vxvujwhvw"}

        };

        return dt;
    }
}