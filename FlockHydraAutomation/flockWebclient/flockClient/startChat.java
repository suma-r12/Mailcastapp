package flockClient;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSuite;
import utilities.GenericMethods;
import utilities.OnBoardingUtils;
import utilities.SignOutUtils;

public class startChat extends BaseTestSuite{

	private GenericMethods gm;
	private OnBoardingUtils onboard;
	private SignOutUtils signOut;
	
	@BeforeMethod
	public void beforeMethod() {
		gm = new GenericMethods(driver);
		onboard = new OnBoardingUtils(driver);
		signOut = new SignOutUtils(driver);
		onboard.setUpUserAccount();
	
	}

	@Test
	public void testMethod() throws Exception {
		
		onboard.setUpUserAccount();
		Thread.sleep(5000);
		gm.elementDisplayed(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), "Univerl-Search-Plus-Icon");
		gm.click(By.xpath("//div[@id='shell_plus_PlusWidget_0']"), 1);
		Thread.sleep(2000);
		boolean universalSearchInviteButton = gm.isElementPresent("//table[@id='widgets_Menu_0']", "xpath");
		if(universalSearchInviteButton){
			boolean option1 = gm.isElementPresent("//div[@id='dijit__WidgetsInTemplateMixin_2']/td[2]", "xpath");
			System.out.println(option1);
			//if(option1){
				gm.elementDisplayed(By.xpath("//div[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[@class='plus-item__icon group']"), "Create-Channel-icon");
				gm.elementDisplayed(By.xpath("//div[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[@class='plus-item__label']"), "Create-Channel-label");
				gm.getText(By.xpath("//div[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[@class='plus-item__label']"));
				gm.elementDisplayed(By.xpath("//div[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[@class='plus-item__sublabel']"), "Create-Channel-sublabel");
				gm.getText(By.xpath("//div[@id='dijit__WidgetsInTemplateMixin_2']/td[2]/div[@class='plus-item__sublabel']"));
				
			/*}else{
				System.out.println("If loop was not exeeccuted");
			}*/
		}
	
		
		
		
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		signOut.vanillaLogout();
		Thread.sleep(5000);
	}

}
