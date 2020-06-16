package TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import PageObjects.POLogin;

public class LoginTestcases extends TestBase {
	
Logger log = Logger.getLogger(getClass().getSimpleName());

	POLogin l;
	
	@BeforeTest
	public void set() {
		 l=new POLogin(browUtil.driver);
	}
	
	@Test(priority=1)	
	public void logintoapp()  {
		l.login();
		log.info("login testcase is success");
			}
	
	@Test(priority=2)	
	public void dontLogin()  {
		l.invalidLogin();
		log.info("dontLogin testcase failed");
		
		

	}
	
	
	
	
}
