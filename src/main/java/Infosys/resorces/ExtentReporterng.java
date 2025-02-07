package Infosys.resorces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterng {
    //ExtentReports extent;
    public  static ExtentReports getReportobject(){
       String path= System.getProperty("uswr.dir")+"//Report//index.html";
        ExtentSparkReporter reporter =new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation");
        reporter.config().setDocumentTitle("Test Report");
        ExtentReports extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Sugi");
        //extent.createTest(path);
        return extent;



        /*public void extentreport(){
            ///Users/kumarvaduganathan/Documents/WorkspaceSuhanya/Extentrep/src/test/java/Infosys
            String path =System.getProperty("user.dir")+"//Report//index.html";
            //helper class
            ExtentSparkReporter reporter =new ExtentSparkReporter(path);
            reporter.config().setReportName("Web Automation");
            reporter.config().setDocumentTitle("Test Report");
            //main class this is the one generate the report to above class
            exten =new ExtentReports();
            exten.attachReporter(reporter);
            exten.setSystemInfo("Tester","sugi");*/
    }
}
