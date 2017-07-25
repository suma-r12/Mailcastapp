package flockClient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSuite;
import resources.DefaultStrings;
import utilities.GenericMethods;

public class CreateTodo extends BaseTestSuite {

	private GenericMethods gm;

	public WebDriver getDriver() {

		return driver;

	}

	@BeforeMethod

	public void beforeMethod() {

		gm = new GenericMethods(driver);

	}

	@Test(priority = 1)

	public void signin() {

		gm.implicitWait(50);

		gm.SwitchToiFrameNo(0);

		gm.SendKey(By.xpath("//input[@class='input']"), 5, DefaultStrings.DIRECTI_TESTER_002_Email);

		gm.click(By.xpath("//*[@id='uniqName_15_0']/div[2]/div/a"), 1);

		gm.click(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"), 2);

		gm.SendKey(By.xpath("//input[@class='input']"), 1, DefaultStrings.OTP);

		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);

		gm.implicitWait(60);

	}

	@Test(priority = 2)

	public void openTodoByApplaunch() {
		//gm.click(By.xpath("//div[@id='shell_roster_RosterWidget_0']//div[@class='app-container__close']"), 10);

		gm.getElement(".//div[@id='globalButtonApps']", "xpath");

		if (gm.isElementPresent(
				"#globalButtonApps>div[data-name='Shared To-Dos']", "css")) {
			gm.click(By.xpath("//div[@id='globalButtonApps']/div[@data-id='ae05fb5b1e39e29b396e03c2efe053196e3b9461']"),
					1);
		} else {
			System.out.println("Todo in the sidebar is not displayed");

		}

	}

	@AfterMethod

	public void afterMethod() {

		System.out.println("BaseTestSuite -> After Method");

	}

}