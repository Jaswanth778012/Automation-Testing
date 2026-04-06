package com.kodnest.TestNGConcept.Assertion;

import org.testng.Assert;
import org.testng.annotations.*;

public class AssertionDemo {
	
	@Test
	void testText() {
		String expected = "KODNEST SELENIUM DEMO";
		
		String actual = "KODNEST SELENIUM DEMO1";
		
//		if(expected.equals(actual)) 
//		{
//			System.out.println("Test Passed");
//		}
//		else
//		{
//			System.out.println("Test Failed");
//		}
		
//		Assert.assertEquals(actual, expected);
		
		if(expected.equals(actual)) 
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
		
		
	}
}
