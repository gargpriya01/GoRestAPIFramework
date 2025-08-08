package com.gorest.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private final int maxRetryCount=2;
    private int retryCount=0;

    public boolean retry(ITestResult result){
    if(retryCount<maxRetryCount){
    retryCount++;
    return true;
}
    return false;
    }
}
