package flockClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseTestSuite;

public class searchPlus extends BaseTestSuite{
	/*
	Created on 9th August 2017
	By Farzan Shaikh
	*/
	
	private static final Logger log = LogManager.getLogger(searchPlus.class.getName());

	@BeforeMethod
	public void beforeMethod() throws Exception {
		
	}

	@Test(priority=1)
	public void searchPlusChannelOption() throws Exception {
		
		if (ce.univerlSearchPlusIconPresent()) {
			
			ce.clickUniverlSearchPlusIcon();

			searchPlusContentOption1();
			ce.clickSearchPlusCreateChannel();
			
			boolean result = driver.findElement(By.xpath("//div[contains(text(),'Start a New Channel')]")) != null;
			Assert.assertTrue(result);
			
			ce.clickStartChannelModalClose();
			
			test.log(LogStatus.PASS, "searchPlusChannelOption Test Passed");
		}
	}
	
	
	public void searchPlusContentOption1() throws Exception {

		Thread.sleep(2000);
		
			if (gm.isElementPresent("dijit__WidgetsInTemplateMixin_2", "id")) {
				gm.elementDisplayed(By.xpath("//div[@class='plus-item__icon group']"),
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
				test.log(LogStatus.FAIL, "The create a channel option is not present");
			}		
	}
	
	
	@Test(priority=2)
	public void searchPlusJoinChannelOption() throws Exception {
		Thread.sleep(3000);
		
		if (ce.univerlSearchPlusIconPresent()) {
			
			ce.clickUniverlSearchPlusIcon();

			searchPlusContentOption2();	
			
			ce.clickSearchPlusJoinChannel();
			
			boolean result = driver.findElement(By.xpath("//div[contains(text(),'Public Channels')]")) != null;
			Assert.assertTrue(result);
			
			ce.clickJoinChannelModalClose();
			test.log(LogStatus.PASS, "searchPlusJoinChannelOption Test Passed");
		}
	}
	
	
	public void searchPlusContentOption2() throws Exception{
		if (gm.isElementPresent("dijit__WidgetsInTemplateMixin_1", "id")) {
			gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__icon join_channel']"),
					"Create-Channel-icon");
			gm.elementDisplayed(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"),
					"Create-Channel-label");
			gm.getInnerText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"));
			gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"),
					"Join Public Channels");
			gm.elementDisplayed(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__sublabel']"),
					"Create-Channel-sublabel");
			gm.getInnerText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__sublabel']"));
			gm.compareText(
					By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__sublabel']"),
					"Discover shared interests");
			test.log(LogStatus.INFO, "The join a channel option is present");
		} else {
			test.log(LogStatus.FAIL, "The join a channel option is not present");
		}
	}
	
	
	@Test(priority=3)
	public void searchPlusInviteOption() throws Exception {
		Thread.sleep(3000);
		
		if (ce.univerlSearchPlusIconPresent()) {
			

			ce.clickUniverlSearchPlusIcon();

			searchPlusContentOption3();
			
			ce.clickSearchPlusInviteButton();
			
			boolean result = driver.findElement(By.xpath("//div[contains(text(),'Invite team members')]")) != null;
			Assert.assertTrue(result);
			
			ce.clickInviteContactCancel();
			test.log(LogStatus.PASS, "searchPlusInviteOption Test Passed");
		}
	}

	
	public void searchPlusContentOption3() throws Exception{
		if (gm.isElementPresent("dijit__WidgetsInTemplateMixin_3", "id")) {
			gm.elementDisplayed(By.xpath("//div[@class='plus-item__icon invite']"),
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
			test.log(LogStatus.FAIL, "The invite option is not present");
		}
	}

	

}
