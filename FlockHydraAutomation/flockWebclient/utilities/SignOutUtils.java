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
    	gm.click(By.xpath("//div[@id='shell_appMenu_AppMenu_0']//div[@class='app_menu_icon']"), 2);
		gm.click(By.xpath("//div[@id='shell_appMenu_AppMenuItem_10']"), 1);
		gm.click(By.xpath("//div[@id='widgets_SignoutDialog_0']//button[@class='confirmDialogExecute btn btn--action']"), 1);
		
    }
    

}
