package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import resources.DefaultStrings;

public class BaseTestSuite{
	public WebDriver driver;

	@Parameters("browser")
	@BeforeSuite
	public void beforesuite(@Optional(DefaultStrings.FIREFOX)String browser) {
		
		System.out.println("BaseTestSuite -> Before Test Suite");
		if (browser.equalsIgnoreCase(DefaultStrings.FIREFOX)) {
			System.getProperty(DefaultStrings.FIREFOX_DRIVER_KEY, DefaultStrings.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase(DefaultStrings.CHROME)) {
			System.setProperty(DefaultStrings.CHROME_DRIVER_KEY, DefaultStrings.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseTestSuite -> After Test Suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BaseTestSuite -> Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("BaseTestSuite -> After Test");
	}

}
