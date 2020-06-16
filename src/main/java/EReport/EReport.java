package EReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import BrowserUtils.BrowserUtilities;

public class EReport{
	
	public static ExtentReports reports;
    public static ExtentTest logger;
    static  String sPath = System.getProperty("user.dir")+"//Reports//Report.html";
    
    public static ExtentReports createInstance() {
    	if(reports!=null) {
    		return reports;
    	}
    	
    	reports = new ExtentReports(sPath);
    	return reports;
    }

    
    public static String takeScreenshot() throws IOException {
        TakesScreenshot srcShot = ((TakesScreenshot) BrowserUtilities.driver);
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
        String imagePath = System.getProperty("user.dir")+"//ScreenShot//screenshot.png";
        File destFile = new File(imagePath);
        FileUtils.copyFile(srcFile,destFile);
        return imagePath;
    }

}
