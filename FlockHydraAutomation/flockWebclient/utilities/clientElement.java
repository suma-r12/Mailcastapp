package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseTestSuite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;

public class clientElement {
	ExtentTest test;
	WebDriver driver;
	WebElement element = null ;
	
	private static GenericMethods gm ;
	private static final Logger log = LogManager.getLogger(clientElement.class.getName());
	
	public clientElement(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
		}
	@BeforeMethod
	public void beforeMethod(){
		
	}
	
	@FindBy(xpath="//div[@id='shell_plus_PlusWidget_0']")
	public WebElement univerlSearchPlusIcon;
	
	public void clickUniverlSearchPlusIcon(){
		
		univerlSearchPlusIcon.click();
		log.info("Clicked on the Universal Search Button");
		test.log(LogStatus.INFO, "Clicked on the searchPlusWidget");
	}
	
	@FindBy(xpath="//tr[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[1]")
	WebElement searchPlusCreateChannel;
	
	public void  clickSearchPlusCreateChannel(){
		if(searchPlusCreateChannel.getSize() != null){
			searchPlusCreateChannel.click();
			test.log(LogStatus.INFO, "The Create Channel Option is clicked");
			log.info("The Create Channel Option is not clicked");
		}else{
			test.log(LogStatus.ERROR, "The Create Channel Option is not clicked");
			log.info("The Create Channel Option is not clicked");
		}
		
			
	}
	

}
