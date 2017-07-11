package flockClient;

import org.testng.annotations.Test;

import base.BaseTestSuite;
import utilities.GenericMethods;
import utilities.OnBoardingUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class startChat extends BaseTestSuite{
	
	private GenericMethods gm;
	private OnBoardingUtils onboard;
	
	@BeforeMethod
	public void beforeMethod() {
		gm = new GenericMethods(driver);
		onboard = new OnBoardingUtils(driver);
		onboard.setUpUserAccount();
	}

	@Test
	public void f() {
		System.out.println("Test");
	}

	@AfterMethod
	public void afterMethod() {
	}

}
