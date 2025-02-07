package Infosys.Testcomponants;

import Infosys.resorces.ExtentReporterng;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent=ExtentReporterng.getReportobject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentest=new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = extent.createTest(result.getMethod().getMethodName());
        extentest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        test.log(Status.PASS,"Test Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        extentest.get().fail(result.getThrowable());
        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception el) {
            el.printStackTrace();
        }
        String filepath= null;
        try {
            filepath = String.valueOf(takescreenshot(result.getMethod().getMethodName(),driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }
    //ExtentReports extent=ExtentReporterng.getReportobject();
    @Override
    //ExtentReports extent =new ExtentReports();
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        //Take Screenshot
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {

        ITestListener.super.onFinish(context);
        extent.flush();
    }

    @Override
    public boolean isEnabled() {
        return ITestListener.super.isEnabled();
    }
}
