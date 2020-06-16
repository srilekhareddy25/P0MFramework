package Base;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.LogStatus;

import BrowserUtils.BrowserUtilities;
import EReport.EReport;
import Propertloader.Property;

import bsh.BshClassManager.Listener;


@Listeners(EListener.TestListener.class)

public class TestBase {
	
	
	
	public static BrowserUtilities browUtil = new BrowserUtilities();
	public static Property  prop = new Property();
	public static EReport  extrp = new EReport();
	
	Property pl = new Property();
	@BeforeSuite
	public void on() throws Exception {
		
		BrowserUtilities.launchBrowser();
		prop.loadLog4jPropertyFile(pl.getProperty("log4"));

	}

	
	@AfterSuite
	public void off() {
		BrowserUtilities.quitBrowser();
		
	}
	
}
