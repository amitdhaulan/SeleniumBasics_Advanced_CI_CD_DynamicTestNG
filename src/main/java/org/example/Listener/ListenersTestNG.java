package org.example.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.example.selenium.core.BaseTest.*;

public class ListenersTestNG implements ITestListener {
    public void onStart(ITestContext context) {
        System.out.println("onStart method started");
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish method started");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("New Test Started" +result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        passedTestCases.add(result.getName());
        System.out.println("onTestSuccess Method" +result.getName());
    }

    public void onTestFailure(ITestResult result) {
        failedTestCases.add(result.getName());
        System.out.println("onTestFailure Method" +result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        skippedTestCases.add(result.getName());
        System.out.println("onTestSkipped Method" +result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
    }
}