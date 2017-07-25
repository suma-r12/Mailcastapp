package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOutUtils {
	private WebDriver driver;
    private GenericMethods gm;
    private static final Logger log = LogManager.getLogger(SignOutUtils.class.getName());
    
    public SignOutUtils(WebDriver webDriver) {
        this.driver = webDriver;
        gm = new GenericMethods(this.driver);
    }
    
    public void flockSignOut() throws Exception{
    	gm.click(By.xpath("//div[@id='shell_appMenu_AppMenu_0']//div[@class='app_menu_icon']"), 2);
		gm.click(By.xpath("//div[@id='app-menu-item-sing-out']"), 1);
		gm.click(By.xpath("//div[@id='widgets_SignoutDialog_0']//button[@class='confirmDialogExecute btn btn--action']"), 1);
		Thread.sleep(8000);
    }
    
    public void clearUserAccount() throws Exception{
    	if (gm.isElementPresent("//div[@id='shell_appLogo_AppLogo_0']", "xpath")) {
			log.info("App not logged out. Try logging out from the default test account.");
			flockSignOut();
		} else {
			log.info("App user already logged out");
			
		}
    }
    

}
