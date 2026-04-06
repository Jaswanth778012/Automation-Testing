package com.kodnest.TestNGConcept.grouping;

import org.testng.annotations.Test;

public class LoginTests {
	
	@Test(priority = 1, groups = {"smoke"})
	void loginByEmail() {
		System.out.println("Login by the email");
	}
	
	@Test(priority = 2, groups = {"smoke"})
	void loginByFacebook() {
		System.out.println("Login by the Facebook");
	}
	
	@Test(priority = 3, groups = {"smoke"})
	void loginByUsername() {
		System.out.println("Login by the username");
	}
}
