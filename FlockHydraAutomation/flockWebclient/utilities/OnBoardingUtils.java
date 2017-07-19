package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.DefaultStrings;

public class OnBoardingUtils {
	    private WebDriver driver;
	    private GenericMethods gm;

	    public OnBoardingUtils(WebDriver webDriver) {
	        this.driver = webDriver;
	        gm = new GenericMethods(this.driver);
	    }

	    /**
	     * Will login directly to a test account
	     */
	    public void flockSignIn() {
	        gm.SwitchToiFrameNo(0);
	        WebElement element = gm.getElement("//input[@placeholder='Enter your work email']", "xpath");
	        element.sendKeys(DefaultStrings.DIRECTI_TESTER_002_Email);
	        gm.click(By.className("btn--action"), 2);
	        gm.click(By.className("google-auth-footer"), 2);
	        gm.SendKey(By.xpath("//input[@tabindex='1']"), 2, DefaultStrings.OTP);
	        gm.click(By.className("btn--action"), 1);
	        gm.implicitWait(30);
	        gm.click(By.xpath("//div[@id='widgets_Dialog_3']//a[@class='btn btn--action btn--block']"), 2);
	    }

	    public void setUpUserAccount() {
	        if (!gm.isElementPresent("//*[@id=\"globalButtonApps\"]/div[1]", "xpath")) {
	            System.out.println("App not logged in. Try logging in default test account.");
	            flockSignIn();
	        } else {
	            System.out.println("App user already logged in. Continue with tests as it is");
	        }
	        handleLanguageAlert();
	    }

	    public void handleLanguageAlert() {
	        System.out.println("Inside handle language alert");
	        gm.click(By.xpath("//*[@id=\"widgets_LanguageConflictDialog_0\"]/div[3]/button[1]"), 10);
	    }

}
