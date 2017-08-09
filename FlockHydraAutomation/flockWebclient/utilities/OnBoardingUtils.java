package utilities;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OnBoardingUtils {
	ExtentTest test;
	WebDriver driver = null;
	private GenericMethods gm;
	private clientElement ce;
	
	private static final Logger log = LogManager.getLogger(OnBoardingUtils.class.getName());

	public OnBoardingUtils(WebDriver webDriver, ExtentTest test) {
		this.driver = webDriver;
		this.test = test;
		gm = new GenericMethods(this.driver);
		ce = new clientElement(this.driver, this.test);
		
	}


	public void flockSignIn() {
		gm.SwitchToiFrameNo(0);
		WebElement element = gm.getElement("//input[@placeholder='Enter your work email']", "xpath");
		element.sendKeys(DefaultStrings.DIRECTI_TESTER_002_Email);
		gm.click(By.className("btn--action"), 2);
		gm.click(By.className("google-auth-footer"), 2);
		gm.SendKey(By.xpath("//input[@tabindex='1']"), 2, DefaultStrings.OTP);
		gm.click(By.className("btn--action"), 1);
		gm.implicitWait(30);
		//gm.click(By.xpath("//div[@id='widgets_Dialog_3']//a[@class='btn btn--action btn--block']"), 2);
		test.log(LogStatus.INFO, "Test User Signed In");
	}

	public void setUpUserAccount() throws Exception {
		if (!gm.isElementPresent("//div[@id=\"globalButtonApps\"]/div[1]", "xpath")) {
			log.info("App not logged in. Try logging in default test account.");
			test.log(LogStatus.INFO, "App not logged in. Try logging in default test account.");
			
			flockSignIn();
		} else {
			log.info("App user already logged in. Continue with tests as it is");
			test.log(LogStatus.INFO, "App user already logged in. Continue with tests as it is");
		}
		handleLanguageAlert();
	
		skipFeatureTour();
	}

	public void handleLanguageAlert() throws InterruptedException {
		 log.debug("Inside handle language alert");
	        gm.waitAndClick(By.xpath("//div[contains(@class,'language-conflict-dialog')]"), 30);
	        try {
	            Thread.sleep(15 * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
    }

	public void skipFeatureTour() throws Exception {
		Thread.sleep(5000);
		
		gm.click(By.xpath("//div[@class='search__plus']"), 1);
		gm.waitForElement(By.xpath("//div[contains(@class,'fcStartNewConversation')]"), 12);
		if (gm.elementDisplayed(By.xpath("//div[contains(@class,'fcStartNewConversation')]"), "Feature Tour Card")) {
			log.info("Clicking on Feature Tour Skip");
			test.log(LogStatus.INFO, "Clicking on Feature Tour Skip");
			gm.click(By.className("fcSkipButton"), 1);
		} else {
			log.info("Feature tour not displayed");
			test.log(LogStatus.INFO, "Feature tour not displayed");
		}
	}

	public void browserDownloadPrompt() {
		String parentHandle = driver.getWindowHandle();
		if (gm.isElementPresent("//div[@class='header-prompt header-prompt--download']", "xpath")) {
			gm.elementDisplayed(By.xpath("//div[@class='header-prompt header-prompt--download']"),
					"Browser-Header-DownloadPrompt");
			gm.getInnerText(By.xpath("//div[@class='header-prompt header-prompt--download']"));
			gm.compareText(By.xpath("//div[@class='header-prompt header-prompt--download']"),
					"Get notifications without opening your browser. Enjoy a richer native experience.");
			if (gm.isElementPresent("//a[@id='downloadFlock']", "xpath")) {
				gm.elementDisplayed(By.xpath("//a[@id='downloadFlock']"), "DownloadPrompt-Button");
				gm.getInnerText(By.xpath("//a[@id='downloadFlock']"));
				gm.compareText(By.xpath("//a[@id='downloadFlock']"), "Download Flock");
				gm.click(By.xpath("//a[@id='downloadFlock']"), 1);
				Set<String> Handles = driver.getWindowHandles();
				
				for(String Handle:  Handles){
					if(!Handle.equals(parentHandle)){
						driver.switchTo().window(Handle);
						driver.close();
					}
				}
				driver.switchTo().window(parentHandle);
				log.info("The download button test executed");
				test.log(LogStatus.INFO, "The download button test executed");
			} else {
				log.info("The download button inthe download prompt is not present");
				test.log(LogStatus.INFO, "The download button inthe download prompt is not present");
			}
			if (gm.isElementPresent("//span[@id='downloadPromptClose']", "xpath")) {
				gm.elementDisplayed(By.xpath("//span[@id='downloadPromptClose']"), "DownloadPrompt-close");
				gm.getInnerText(By.xpath("//span[@id='downloadPromptClose']"));
				gm.compareText(By.xpath("//span[@id='downloadPromptClose']"), "Download Close");
				gm.click(By.xpath("//span[@id='downloadPromptClose']"), 1);
				log.info("The cancel option test executed");
				test.log(LogStatus.INFO, "The cancel option test executed");
			} else {
				log.info("The cancel option in the download prompt is not present");
				test.log(LogStatus.INFO, "The cancel option in the download prompt is not present");
			}
			driver.switchTo().window(parentHandle);
		} else {
			log.info("The Download Promot Bar is not present");
			test.log(LogStatus.INFO, "The Download Promot Bar is not present");
		}

	}

}
