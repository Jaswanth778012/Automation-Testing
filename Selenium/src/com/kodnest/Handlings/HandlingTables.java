package com.kodnest.Handlings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		int rows =driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr")).size();
		
		System.out.println(rows);
		
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr//th")).size();
		
		System.out.println(cols);
		
		// For specific data from the table
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[5]//td[1]")).getText();
		
		System.out.println(data);
		
		// To get the all data from the table
		
		for (int i=2; i<=rows; i++) {
			for (int j=1; j<=cols; j++) {
				String datas = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + i +"]//td["+j+"]")).getText();
				System.out.print(datas + "\t");
			}
			System.out.println();
		}
		
		System.out.println("-----------------------------");
		
		// only one particular row		
		for(int i=2; i<=rows; i++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr["+i+"]//td[2]")).getText();
			
			if(author.equals("Animesh")) {
				for(int j=1; j<=cols; j++) {
					String datas = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + i +"]//td["+j+"]")).getText();
					System.out.print(datas + "\t");
				}
				System.out.println();
			}
		}
		
	}

}
