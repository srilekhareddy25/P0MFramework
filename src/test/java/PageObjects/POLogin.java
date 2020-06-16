package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import BrowserUtils.BrowserUtilities;
import Propertloader.Property;


public class POLogin extends TestBase{

	Property pl = new Property();
	public POLogin(WebDriver driver){

		browUtil.driver = driver;

        PageFactory.initElements(driver, this);

    }

	    @FindBy(id="email_field")

	    WebElement username;

	    @FindBy(id="password_field")

	    WebElement password;    

	    @FindBy(xpath="//button[contains(text(),'Login to Account')]")

	    WebElement login;
	    
	    @FindBy(xpath="//a[contains(text(),'Logout')]")

	    WebElement logout;


	    public void setUserName(){
	    	username.clear();
	    	username.sendKeys(pl.getProperty("Username"));     
	    }

	    public void setPassword(){
	    	password.clear();
	    	password.sendKeys(pl.getProperty("Password"));

	    }
	    
	    public void setPassword1(){
	    	password.clear();
	    }


	    public void clickLogin(){

	            login.click();

	    }  
	    public void clickLogout(){

            logout.click();

    }  
	    
	    public void login(){

	    	
	        this.setUserName();
	        this.setPassword();
	        this.clickLogin();    
	        browUtil.waitElementToVisible(logout);
	        extrp.logger.log(LogStatus.INFO,  "Login Button clicked");

	        this.clickLogout();

	    }

	    
	    public void invalidLogin(){
	    	browUtil.waitElementToVisible(username);
	        this.setUserName();
	        this.setPassword1();
	        this.clickLogin(); 
	        browUtil.waitElementToVisible(logout);


	    }

	}


