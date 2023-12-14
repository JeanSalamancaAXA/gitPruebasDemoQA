package org.AXA.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManage {
    private  static ExtentReports extent;

    public static ExtentReports getInstance(){
        if(extent == null){
            extent = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/extentReport/reporte.html");
            extent.attachReporter(extentSparkReporter);
        }
        return extent;
    }
}