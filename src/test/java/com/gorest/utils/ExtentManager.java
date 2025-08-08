package com.gorest.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static ExtentReports getInstance(){
        if(extent==null){
            ExtentSparkReporter reporter=new ExtentSparkReporter("reports/ExtentReport.html");
            reporter.config().setReportName("Go Rest API Automation");
            reporter.config().setDocumentTitle("Test Results");
            extent=new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("QA", "Priya Garg");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
        }
    }
