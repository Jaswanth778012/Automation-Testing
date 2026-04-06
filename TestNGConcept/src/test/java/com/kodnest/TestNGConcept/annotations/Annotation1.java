package com.kodnest.TestNGConcept.annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation1 {
	
	@BeforeMethod
	void login() {
		System.out.println("This is login");
	}
	
	@Test
	void search() {
		System.out.println("This is Search");
	}
	
	@AfterMethod
	void logout() {
		System.out.println("This is logout");
	}
	
	@Test
	void AdvSearch() {
		System.out.println("This is adv search");
	}
}
