package flockClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSuite;
import utilities.GenericMethods;
import utilities.OnBoardingUtils;
import utilities.SignOutUtils;

public class searchPlus extends BaseTestSuite{

	private GenericMethods gm;
	private OnBoardingUtils onboard;
	private SignOutUtils signOut;
	private static final Logger log = LogManager.getLogger(searchPlus.class.getName());
	
	@BeforeMethod
	public void beforeMethod() {
		gm = new GenericMethods(driver);
		onboard = new OnBoardingUtils(driver);
		signOut = new SignOutUtils(driver);
		onboard.setUpUserAccount();
	
	}

	@Test
	public void testMethod() throws Exception {
		
		Thread.sleep(5000);
		gm.elementDisplayed(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), "Univerl-Search-Plus-Icon");
		gm.click(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), 1);
		Thread.sleep(2000);
		boolean universalSearchInviteButton = gm.isElementPresent("//table[@id='widgets_Menu_0']", "xpath");
		if(universalSearchInviteButton){
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[1]"), "Create-Channel-icon");
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"), "Create-Channel-label");
				gm.getInnerText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"));
				gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__label']"), "Create a new channel");
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"), "Create-Channel-sublabel");
				gm.getInnerText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"));
				gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"), "For your projects or topics");
				
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']/td[2]/div[1]"), "Create-Channel-icon");
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"), "Create-Channel-label");
				gm.getInnerText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"));
				gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_1']//div[@class='plus-item__label']"), "Join Public Channels");
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"), "Create-Channel-sublabel");
				gm.getInnerText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"));
				gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_2']//div[@class='plus-item__sublabel']"), "Discover shared interests");
				
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']/td[2]/div[1]"), "Create-Channel-icon");
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__label']"), "Create-Channel-label");
				gm.getInnerText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__label']"));
				gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__label']"), "Invite contacts");
				gm.elementDisplayed(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__sublabel']"), "Create-Channel-sublabel");
				gm.getInnerText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__sublabel']"));
				gm.compareText(By.xpath("//tr[@id='dijit__WidgetsInTemplateMixin_3']//div[@class='plus-item__sublabel']"), "Add members to your team");
				}else{
					log.info("The options in the dropdown is not displayed");
				}
		}
	

	@AfterMethod
	public void afterMethod() throws Exception {
		signOut.vanillaLogout();
		Thread.sleep(2000);
	}

}
