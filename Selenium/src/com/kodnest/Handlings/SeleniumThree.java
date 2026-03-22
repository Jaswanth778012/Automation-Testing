package com.kodnest.Handlings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumThree {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://iamsandesh23.github.io/selenium.github.io/");
		
		driver.manage().window().maximize();
		
		List<WebElement> elements= driver.findElements(By.tagName("a"));
		
//		for (int i=0; i<=elements.size()-1; i++) {
//			
//			if(elements.get(i).getText().length() > 0)
//			{
//				System.out.println(elements.get(i).getText());
//			}	
//		}
		
		for(WebElement element : elements) {
			
			if(element.getText().length() > 0) {
				System.out.println(element.getText());
			}
		}
		
		driver.quit();
	}

}
