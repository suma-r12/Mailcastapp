package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOutUtils {
	private WebDriver driver;
    private GenericMethods gm;
    
    public SignOutUtils(WebDriver webDriver) {
        this.driver = webDriver;
        gm = new GenericMethods(this.driver);
    }
    
    public void vanillaLogout(){
    	gm.click(By.xpath("//div[@id='widgets_contact_Avatar_0']//div[@class='contact_avatar_name']"), 2);
    	gm.click(By.xpath("//div[@id='shell_appMenu_AppMenuItem_10']//div[@text='Sign out']"), 2);
    }
    

}
