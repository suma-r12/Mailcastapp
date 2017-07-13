package flockClient;

import org.testng.annotations.Test;

import base.BaseTestSuite;
import utilities.GenericMethods;
import utilities.OnBoardingUtils;
import utilities.SignOutUtils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;

public class startChat extends BaseTestSuite{
	
	private GenericMethods gm;
	private OnBoardingUtils onboard;
	//private SignOutUtils signOut;
	
	@BeforeMethod
	public void beforeMethod() {
		gm = new GenericMethods(driver);
		onboard = new OnBoardingUtils(driver);
		//signOut = new SignOutUtils(driver);
		
	
	}

	@Test
	public void f() throws Exception {
		
		onboard.setUpUserAccount();
		Thread.sleep(2000);
		System.out.println("Test");
		
		
	}

	@AfterMethod
	public void afterMethod() {
		
	}

}
