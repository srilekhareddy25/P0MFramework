package EListener;
import java.io.IOException;

import org.testng.ITestContext;		
import org.testng.ITestListener;		
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import EReport.EReport;



public class TestListener implements ITestListener {

	static ExtentReports extent = EReport.createInstance();
	public static ThreadLocal<ExtentTest> testLocal = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		EReport.logger = extent.startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result)  {
		
		EReport.logger.log(LogStatus.PASS, result.getMethod().getMethodName()+" Passed");	
		
			try {
				EReport.logger.addScreenCapture(EReport.takeScreenshot());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		EReport.logger.log(LogStatus.FAIL, result.getMethod().getMethodName()+" Failed");	

		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		EReport.logger.log(LogStatus.SKIP, result.getMethod().getMethodName()+" Skipped");	

		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {

		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		//extent.close();
	}	
	
	public void onTestEnd(ITestResult result) {
		 extent.endTest(EReport.logger);
	}

	    
	    
	    	
	
}
