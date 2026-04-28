package com.kodnest.TestNGConcept.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerClass implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("=== Test Suite STARTED: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== Test Suite FINISHED: " + context.getName() + " ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getName());
        System.out.println("Reason: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("FAILED BUT WITHIN SUCCESS %: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("FAILED DUE TO TIMEOUT: " + result.getName());
    }
}