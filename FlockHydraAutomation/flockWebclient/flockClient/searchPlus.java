package flockClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseTestSuite;
import utilities.ExtentFactory;
import utilities.GenericMethods;
import utilities.OnBoardingUtils;
import utilities.SignOutUtils;

public class searchPlus extends BaseTestSuite {

	private GenericMethods gm;
	private OnBoardingUtils onboard;
	private SignOutUtils signOut;
	ExtentReports report;
	ExtentTest test;
	private static final Logger log = LogManager.getLogger(searchPlus.class.getName());

	@BeforeMethod
	public void beforeMethod() {
		report = ExtentFactory.getInstance();
		gm = new GenericMethods(driver);
		onboard = new OnBoardingUtils(driver);
		signOut = new SignOutUtils(driver);
		test = report.startTest("Search Plus");
		/*onboard.setUpUserAccount();
		test.log(LogStatus.INFO, "User Logged in to the app");*/
	}

	@Test(priority=1)
	public void searchPlusChannelOption() throws Exception {
		onboard.setUpUserAccount();
		test.log(LogStatus.INFO, "User Logged in to the app");
		
		if (gm.isElementPresent("//div[@id='shell_plus_PlusWidget_0']", "xpath")) {

			gm.elementDisplayed(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), "Univerl-Search-Plus-Icon");
			gm.click(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), 1);
			test.log(LogStatus.INFO, "Clicked on the searchPlusWidget");

			searchPlusContentOption1();
			searchPlusChannelOptionsClick();

		}
	
	}
	
	public void searchPlusContentOption1() throws Exception {

		Thread.sleep(2000);
		
			if (gm.isElementPresent("//tr[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[1]", "xpath")) {
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[1]"),
						"Create-Channel-icon");
				gm.elementDisplayed(
						By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"),
						"Create-Channel-label");
				gm.getInnerText(
						By.xpath("//*[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[2]"));
				gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"),
						"Create a new channel");
				gm.elementDisplayed(
						By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"),
						"Create-Channel-sublabel");
				gm.getInnerText(
						By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"));
				gm.compareText(
						By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"),
						"For your projects or topics");
				test.log(LogStatus.INFO, "The create a channel option is present");
			} else {
				test.log(LogStatus.ERROR, "The create a channel option is not present");
			}		
	}
	
	public void searchPlusChannelOptionsClick(){
		if (gm.isElementPresent("//tr[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[1]", "xpath")){
			gm.click(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[1]"), 1);
			test.log(LogStatus.INFO, "The Create Channel Option is clicked");
			log.info("The Create Channel Option is not clicked");
		}else{
			test.log(LogStatus.ERROR, "The Create Channel Option is not clicked");
			log.info("The Create Channel Option is not clicked");
		}
		WebElement channelHeading = null;
		try{
		channelHeading = driver.findElement(By.xpath("//div[@id='widgets_Dialog_4']//div[@class='title']"));
		}catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(channelHeading != null);
		test.log(LogStatus.PASS, "Channel Option in the Search Plus Menu Clicked");
		gm.click(By.xpath("//div[@id='widgets_Dialog_6']/div[1]/span[@title='Cancel']"), 1);
	}
	
	@Test(priority=2)
	public void searchPlusJoinChannelOption() throws Exception {
		
		if (gm.isElementPresent("//div[@id='shell_plus_PlusWidget_0']", "xpath")) {

			gm.elementDisplayed(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), "Univerl-Search-Plus-Icon");
			gm.click(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), 1);
			test.log(LogStatus.INFO, "Clicked on the searchPlusWidget");

			searchPlusContentOption2();	
			searchPlusJoinChannelOptionsClick();
		}
	}
	
	public void searchPlusContentOption2() throws Exception{
		if (gm.isElementPresent("//tr[@id='dijit__WidgetsInTemplateMixin_1']/td[2]/div[1]", "xpath")) {
			gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']/td[2]/div[1]"),
					"Create-Channel-icon");
			gm.elementDisplayed(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"),
					"Create-Channel-label");
			gm.getInnerText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"));
			gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"),
					"Join Public Channels");
			gm.elementDisplayed(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"),
					"Create-Channel-sublabel");
			gm.getInnerText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"));
			gm.compareText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"),
					"Discover shared interests");
			test.log(LogStatus.INFO, "The join a channel option is present");
		} else {
			test.log(LogStatus.ERROR, "The join a channel option is not present");
		}
		
	}
	public void searchPlusJoinChannelOptionsClick(){
		if (gm.isElementPresent("//tr[@id='dijit__WidgetsInTemplateMixin_1']/td[2]/div[1]", "xpath")){
			gm.click(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[1]"), 1);
			test.log(LogStatus.INFO, "The Join Channel Option is clicked");
			log.info("The Join Channel Option is not clicked");
		}else{
			test.log(LogStatus.ERROR, "The Join Channel Option is not clicked");
			log.info("The Join Channel Option is not clicked");
		}
		WebElement discoverChannelHeading = null;
		try{
			discoverChannelHeading = driver.findElement(By.xpath("//div[@id='widgets_Dialog_5']//div[@class='title']"));
		}catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(discoverChannelHeading != null);
		test.log(LogStatus.PASS, "Join Channel Option in the Search Plus Menu Clicked");
		gm.click(By.xpath("//div[@id='widgets_Dialog_5']/div[1]/span[@title='Cancel']"), 1);
	}
	
	
	@Test(priority=3)
	public void searchPlusInviteOption() throws Exception {
		
		if (gm.isElementPresent("//div[@id='shell_plus_PlusWidget_0']", "xpath")) {

			gm.elementDisplayed(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), "Univerl-Search-Plus-Icon");
			gm.click(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), 1);
			test.log(LogStatus.INFO, "Clicked on the searchPlusWidget");

			searchPlusContentOption3();
			searchPlusInviteOptionsClick();
		}

	}

	public void searchPlusInviteOptionsClick(){
		if (gm.isElementPresent("//tr[@id='dijit__WidgetsInTemplateMixin_3']/td[2]/div[1]", "xpath")){
			gm.click(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']/td[2]/div[1]"), 1);
			test.log(LogStatus.INFO, "The Invite Option is clicked");
			log.info("The Invite Option is not clicked");
		}else{
			test.log(LogStatus.ERROR, "The Invite Option is not clicked");
			log.info("The Invite Option is not clicked");
		}
		WebElement discoverChannelHeading = null;
		try{
			discoverChannelHeading = driver.findElement(By.xpath("//div[@id='widgets_Dialog_5']//div[@class='title']"));
		}catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(discoverChannelHeading != null);
		test.log(LogStatus.PASS, "Invite Option in the Search Plus Menu Clicked");
		gm.click(By.xpath("//div[@id='widgets_Dialog_7']/div[1]/span[@title='Cancel']"), 1);
		
	}

	
	public void searchPlusContentOption3() throws Exception{
		if (gm.isElementPresent("//tr[@id='dijit__WidgetsInTemplateMixin_3']/td[2]/div[1]", "xpath")) {
			gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']/td[2]/div[1]"),
					"Create-Channel-icon");
			gm.elementDisplayed(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__label']"),
					"Create-Channel-label");
			gm.getInnerText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__label']"));
			gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__label']"),
					"Invite contacts");
			gm.elementDisplayed(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__sublabel']"),
					"Create-Channel-sublabel");
			gm.getInnerText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__sublabel']"));
			gm.compareText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__sublabel']"),
					"Add members to your team");
			test.log(LogStatus.INFO, "The invite option is present");
		} else {
			test.log(LogStatus.ERROR, "The invite option is not present");
		}
		
	}
	
	
	

	@AfterMethod
	public void afterMethod() throws Exception {
		signOut.clearUserAccount();
		test.log(LogStatus.INFO, "Signed Out from the Client");
		Thread.sleep(2000);
		report.endTest(test);
		report.flush();
	}

}
