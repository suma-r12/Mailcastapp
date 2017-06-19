package base;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import resources.DefaultStrings;

public class BaseTestSuite{
	public WebDriver driver;

	@Parameters("browser")
	@BeforeSuite
	public void beforesuite(@Optional(DefaultStrings.CHROME)String browser) {
		
		System.out.println("BaseTestSuite -> Before Test Suite");
		if (browser.equalsIgnoreCase(DefaultStrings.FIREFOX)) {
			System.getProperty(DefaultStrings.FIREFOX_DRIVER_KEY, DefaultStrings.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase(DefaultStrings.CHROME)) {
			System.setProperty(DefaultStrings.CHROME_DRIVER_KEY, DefaultStrings.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
		
		if (driver != null) {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(DefaultStrings.FLOCK_WEB_PREPROD);
        } else {
            System.out.println("Not able to initialise driver! Failing tests explicitly");
            fail();
        }
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseTestSuite -> After Test Suite");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("BaseTestSuite -> After Test");
	}

}
