package com.mplatform.framework.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.*;

public class MyListeners implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("OnTestStart - Invoked at every test method");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("OnTestStart - Invoked at every test method success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("OnTestStart - Invoked at every test method fails");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTestStart - Invoked at every test method skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("OnTestStart - Invoked when test method fails with some success percentage defined by user");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Onstart - Invoked on the test class initiation before any test method execution"+ context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("OnFinish - Invoked after all test methods is executed");
		
	}
}