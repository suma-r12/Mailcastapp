package base;

import static org.testng.Assert.fail;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import resources.DefaultStrings;

public class BaseTestSuite{
	public WebDriver driver;
	private ResourceBundle bundle;
	ExtentReports report;
	ExtentTest test;
	
	 @BeforeClass
	@Parameters("browser")
	public void beforeClass(@Optional(DefaultStrings.CHROME) String browser) {
		bundle = ResourceBundle.getBundle("config", Locale.getDefault());
		System.out.println("BaseTestSuite -> Before Class");
		if (browser.equalsIgnoreCase(DefaultStrings.FIREFOX)) {
			System.getProperty(DefaultStrings.FIREFOX_DRIVER_KEY, "C:\\Program Files (x86)\\geckodriver-v0.16.0-win64\\geckodriver.exe");
			ProfilesIni ffProfiles = new ProfilesIni();
			FirefoxProfile profile = ffProfiles.getProfile("customfirefox");
			driver = new FirefoxDriver(profile);
		} else if (browser.equalsIgnoreCase(DefaultStrings.CHROME)) {
			System.setProperty(DefaultStrings.CHROME_DRIVER_KEY, "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
			DesiredCapabilities capabilities = getDesiredCapabilities();
			driver = new ChromeDriver(capabilities);
		}
		
		if (driver != null) {
            //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(DefaultStrings.FLOCK_WEB_PREPROD);
        } else {
            System.out.println("Not able to initialise driver! Failing tests explicitly");
            fail();
        }

	}
	 
	 private DesiredCapabilities getDesiredCapabilities() {
	        System.out.println("Inside getDesiredCapabilities");
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("test-type");
	        options.addArguments("--disable-notifications"); // Note: Disabled notifications to avoid chrome ok notifications dialog
	        capabilities.setCapability("chrome.binary", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        return capabilities;
	    }
	 

	 @AfterClass
		public void afterClass() throws InterruptedException {
		 System.out.println("BaseTestSuite -> After Class");
		 Thread.sleep(3000);
		 if (driver != null) {
	            driver.quit();
	            
	        }
		}
	 
	 @BeforeSuite
		public void beforeSuite() {
			System.out.println("BaseTestSuite -> After Test Suite");
		}
	 
	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseTestSuite -> After Test Suite");
	}

}