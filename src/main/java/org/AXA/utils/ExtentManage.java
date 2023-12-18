package org.AXA.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManage {
    private  static ExtentReports extent;

    public static ExtentReports getInstance(String path){
        File directorio = new File(path);
        if(!directorio.exists()){
            directorio.mkdirs();
        }

        if(extent == null){
            extent = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(directorio+ "/reporte.html");
            extent.attachReporter(extentSparkReporter);
        }
        return extent;
    }


}