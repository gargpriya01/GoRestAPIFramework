package com.gorest.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static ExtentReports getInstance(){
        if(extent==null){
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportName = "Test-Automation-Report_" + timeStamp + ".html";
            ExtentSparkReporter reporter=new ExtentSparkReporter("reports/"+reportName);
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setReportName("Go Rest API Automation");
            reporter.config().setDocumentTitle("Automation Report");
            reporter.config().setTimelineEnabled(true);
            reporter.config().setEncoding("utf-8");
            reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
            extent=new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("QA", "Priya Garg");
            extent.setSystemInfo("Project Name", "GoRest API Automation");
            extent.setSystemInfo("Build", "1.0.3");
            extent.setSystemInfo("Platform", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Environment", "QA");

        }
        return extent;
        }
    }
