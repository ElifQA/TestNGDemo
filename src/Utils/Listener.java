package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utils.CommonMethods;

public class Listener implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed "+result.getName());
		CommonMethods.takeScreenShot("passed/"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed "+result.getName());
		CommonMethods.takeScreenShot("failed/"+result.getName());
	}
		}



