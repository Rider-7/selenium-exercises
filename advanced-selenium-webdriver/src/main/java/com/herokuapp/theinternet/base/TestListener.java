package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  Logger log;
  String testName;
  String testMethodName;

  @Override
  public void onFinish(ITestContext context) {
    log.info(String.format("[TEST %s FINISHED]", this.testName));
  }

  @Override
  public void onStart(ITestContext context) {
    this.testName = context.getCurrentXmlTest().getName();
    this.log = LogManager.getLogger(this.testName);
    log.info(String.format("[TEST %s STARTED]", this.testName));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // TODO Auto-generated method stub
    ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
  }

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    log.info(String.format("[Test %s failed with timeout]", this.testMethodName));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    log.info(String.format("[Test %s failed]", this.testMethodName));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    log.info(String.format("[Test %s skipped]", this.testMethodName));
  }

  @Override
  public void onTestStart(ITestResult result) {
    this.testMethodName = result.getMethod().getMethodName();
    log.info(String.format("[Starting %s]", this.testMethodName));
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log.info(String.format("[Test %s successful]", this.testMethodName));
  }
  
}
