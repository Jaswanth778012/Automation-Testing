package com.kodnest.TestNGConcept.testannotation;

import org.testng.annotations.AfterTest;

public class C3 {
	@AfterTest
	void logout() {
		System.out.println("This is logout");
	}
}
