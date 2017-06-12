package SignIn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import SignIn.GenericMethods;

public class FlockSignIn {
	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(FlockSignIn.class.getName());
	static String hydraURL = "http://updates.flock.co/fl_hydra_web/2.1.0.64/?s=qa&config=preprod";
	static GenericMethods gm;

	@Parameters("browserType")
	@BeforeClass
	public void beforeClass(String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			System.getProperty("webdriver.gecko.driver",
					"C:\\Program Files (x86)\\geckodriver-v0.16.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		gm = new GenericMethods(driver);

		gm.maximize();
		driver.get(hydraURL);
		log.info("Opening the webclient");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@DataProvider(name="emails")
	public static Object[][] emailInputs(){
		return new Object[][]{{""},{"jffhfhfh"},{"jffhfhfh@jdjdjjdj"}};
	}

	@Test(priority = 0)
	public void windowTitle(){
		gm.getTitle();
		
	}
	
	@Test(priority = 1)
	public void Heading(){
		//gm.implicitWait(30);
		gm.SwitchToiFrameNo(0);
		gm.waitForElement(By.xpath("//div[@id='uniqName_15_0']//h2"), 10);
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_15_0']//h2"));
		gm.getText(By.xpath("//div[@id='uniqName_15_0']//h2"));
		gm.compareText(By.xpath("//div[@id='uniqName_15_0']//h2"));
	}
	
	@Test(priority = 2)
	public void subHeading(){
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_15_0']//h5"));
		gm.getText(By.xpath("//div[@id='uniqName_15_0']//h5"));
		gm.compareText(By.xpath("//div[@id='uniqName_15_0']//h5"));
	}
	
	@Test(priority = 3)
	public void emailPlaceHolder(){
		gm.elementDisplayed(By.xpath("//input[@class='input']"));
		gm.getText(By.xpath("//input[@class='input']"));
		gm.compareText(By.xpath("//input[@class='input']"));
	}
	
	@Test(priority = 4)
	public void submitButton(){
		gm.elementDisplayed(By.xpath("//a[@class='btn btn--action btn--block']"));
		gm.getText(By.xpath("//a[@class='btn btn--action btn--block']"));
		gm.compareText(By.xpath("//a[@class='btn btn--action btn--block']"));	
	}
	
	@Test(priority = 5)
	public void contactSupport(){
		gm.elementDisplayed(By.xpath("//span[@class='feedbackLinkSpan']"));
		gm.getText(By.xpath("//span[@class='feedbackLinkSpan']"));
		gm.compareText(By.xpath("//span[@class='feedbackLinkSpan']"));
	}
	
	@Test(priority = 6)
	public void onbaordingSideBar(){
		gm.elementDisplayed(By.xpath("//div[@class='onboarding-sidebar']"));
	}
	

	@Test(priority = 7, dataProvider ="emails")
	public void errorMessage(String emailIDs){
		gm.SendKey(By.xpath("//input[@class='input']"), 1, emailIDs);
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
		gm.elementIsDisplayed(By.xpath("//div[@class='errorMessage']"));
		gm.getText(By.xpath("//div[@class='errorMessage']"));
		gm.clearField(By.xpath("//input[@class='input']"));
	}
	
	@Test(priority =8)
	public void enterEmail(){
		gm.SendKey(By.xpath("//input[@class='input']"), 1, "directitester002@directi.com");
		gm.click(By.xpath("//a[@class='btn btn--action btn--block']"), 1);
	}
	
	@Test(priority = 9)
	public void googleAuthHeading(){
		gm.implicitWait(10);
		gm.waitForElement(By.xpath("//div[@id='uniqName_17_0']//h2"), 10);
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_17_0']//h2"));
		gm.getText(By.xpath("//div[@id='uniqName_17_0']//h2"));
		gm.compareText(By.xpath("//div[@id='uniqName_17_0']//h2"));
	}
	
	@Test(priority = 10)
	public void googleAuthSubHeading(){
		gm.elementDisplayed(By.xpath("//div[@id='uniqName_17_0']//h5"));
		gm.getText(By.xpath("//div[@id='uniqName_17_0']//h5"));
		gm.compareText(By.xpath("//div[@id='uniqName_17_0']//h5"));
	}
	
	@Test(priority = 11)
	public void googleAuthButton(){
		gm.elementDisplayed(By.xpath("//a[@class='btn btn--block btn--google']"));
		gm.getText(By.xpath("//a[@class='btn btn--block btn--google']"));
		gm.compareText(By.xpath("//a[@class='btn btn--block btn--google']"));
	}
	
	@Test(priority = 11)
	public void googleAuthSkipButton(){
		gm.elementDisplayed(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"));
		gm.getText(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"));
		gm.compareText(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"));
	}
	
	@Test(priority = 12)
	public void googleAuthNote(){
		gm.elementDisplayed(By.xpath("//div[@class='google-auth-blurb']"));
		gm.getText(By.xpath("//div[@class='google-auth-blurb']"));
		gm.compareText(By.xpath("//div[@class='google-auth-blurb']"));
	}
	
	@Test(priority =13)
	public void clickSkipGoogleAuth(){
		gm.click(By.xpath("//a[@data-dojo-attach-event='onclick: _skipOAuth']"), 2);
	}
	
	
	

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
