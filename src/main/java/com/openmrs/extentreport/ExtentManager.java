package com.openmrs.extentreport;


import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"\\Reports\\Test Report.html", true);
        }
        return extent;
    }
}
