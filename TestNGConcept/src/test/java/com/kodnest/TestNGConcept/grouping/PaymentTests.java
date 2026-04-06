package com.kodnest.TestNGConcept.grouping;

import org.testng.annotations.Test;

public class PaymentTests {
	@Test(priority = 1, groups = {"smoke", "regression", "functional"})
	void paymentByCredit() {
		System.out.println("Payment by the Credit");
	}
	
	@Test(priority = 2, groups = {"smoke", "regression", "functional"})
	void paymentByDebit() {
		System.out.println("Payment by the Debit");
	}
	
	@Test(priority = 3, groups = {"smoke", "regression", "functional"})
	void paymentByCash() {
		System.out.println("Payment by the Cash");
	}
}
