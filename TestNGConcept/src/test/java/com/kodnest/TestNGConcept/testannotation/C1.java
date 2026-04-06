package com.kodnest.TestNGConcept.testannotation;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	
	@BeforeTest
	void login() {
		System.out.println("This is login");
	}
	
	@Test
	void search() {
		System.out.println("This is Search");
	}
	
	
	
	
}
