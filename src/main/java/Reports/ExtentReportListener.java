package Reports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReportListener implements ITestListener 
{
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test =new ThreadLocal<ExtentTest>();
  

    public void onStart(ITestContext context) 
    {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./src/main/java/Reports.html");
        htmlReporter.config().setDocumentTitle("Automation_Report");
        htmlReporter.config().setReportName("Test_Report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}
