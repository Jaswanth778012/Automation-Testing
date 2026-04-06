package com.kodnest.TestNGConcept.grouping;

import org.testng.annotations.Test;

public class SignUpTests {
	@Test(priority =1, groups = {"regression"})
	void signupByEmail() {
		System.out.println("Signup by the email");
	}
	
	@Test(priority = 2, groups = {"regression"})
	void signupByFacebook() {
		System.out.println("Signup by the Facebook");
	}
	
	@Test(priority = 3, groups = {"regression"})
	void signupByUsername() {
		System.out.println("Signup by the username");
	}
}
