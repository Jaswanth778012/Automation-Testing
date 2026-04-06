package com.kodnest.TestNGConcept.Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoft {
	
	@Test
	void test_hard() {
		System.out.println("Testing 1");
		System.out.println("Testing 2");
		
		Assert.assertEquals(1, 1); // true
		
		System.out.println("Testing 3");
		System.out.println("Testing 4");
	}
	
	// Soft Assertion
	
	@Test
	void soft_assertion() {
		
		System.out.println("Testing 1");
		System.out.println("Testing 2");
		
		SoftAssert s = new SoftAssert();
		
		s.assertEquals(1, 2);
		
		System.out.println("Testing 3");
		System.out.println("Testing 4");
		
		s.assertAll();
	}
}
