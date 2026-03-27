package com.kodnest.TestNGConcept;

import org.testng.annotations.Test;

public class AppTest {
	
	@Test(priority = 1) //priority can be negative numbers also
	void openApp() {
		System.out.println("Opening the application");
	}
	
	@Test(priority = 2)
	void login() {
		System.out.println("logging in the application");
	}
	
	@Test(priority = 3)
	void logout() {
		System.out.println("logging out from the application");
	}
}
