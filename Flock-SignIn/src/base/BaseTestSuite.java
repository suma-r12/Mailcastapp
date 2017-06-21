package base;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import resources.DefaultStrings;

public class BaseTestSuite{
	public WebDriver driver;
	//private ResourceBundle bundle;
	
	 @BeforeClass
	@Parameters("browser")
	public void beforeClass(@Optional(DefaultStrings.CHROME) String browser) {
		//bundle = ResourceBundle.getBundle("config", Locale.getDefault());
		System.out.println("BaseTestSuite -> Before Class");
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
	 
	 /*private DesiredCapabilities getDesiredCapabilities() {
	        System.out.println("Inside getDesiredCapabilities");
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("test-type");
	        options.addArguments("--disable-notifications"); // Note: Disabled notifications to avoid chrome ok notifications dialog
	        capabilities.setCapability("chrome.binary", bundle.getString("chrome_driver_path"));
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        return capabilities;
	    }*/

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