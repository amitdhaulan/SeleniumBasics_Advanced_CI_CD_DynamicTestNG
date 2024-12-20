package org.example.Listener;

import org.example.selenium.core.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        BaseTest.passedTestCases.add(result.getName());
        System.out.println("The name of the testcase passed is :" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest.failedTestCases.add(result.getName());
        System.out.println("The name of the testcase failed is :" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        BaseTest.skippedTestCases.add(result.getName());
        System.out.println("The name of the testcase Skipped is :" + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
