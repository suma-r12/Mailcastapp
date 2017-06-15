package utilities;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	WebDriver driver;
	private static final Logger log = LogManager.getLogger(GenericMethods.class.getName());
	
	public GenericMethods(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getElement(String locator, String type){
		type = type.toLowerCase();
		if (type.equals("id")) {
			log.info("Element found with id: " + locator);
			return this.driver.findElement(By.id(locator));
		}
		else if (type.equals("xpath")) {
			log.info("Element found with xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));
		}
		else if (type.equals("css")) {
			log.info("Element found with xpath: " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		}
		else if (type.equals("linktext")) {
			log.info("Element found with xpath: " + locator);
			return this.driver.findElement(By.linkText(locator));
		}
		else if (type.equals("partiallinktext")) {
			log.info("Element found with xpath: " + locator);
			return this.driver.findElement(By.partialLinkText(locator));
		}
		else {
			log.error("Locator type not supported");
			return null;
		}
	}
	
	public List<WebElement> getElementList(String locator, String type){
		type = type.toLowerCase();
		if (type.equals("id")) {
			log.info("Element found with id: " + locator);
			return this.driver.findElements(By.id(locator));
		}
		else if (type.equals("xpath")) {
			log.info("Element found with xpath: " + locator);
			return this.driver.findElements(By.xpath(locator));
		}
		else if (type.equals("css")) {
			log.info("Element found with css: " + locator);
			return this.driver.findElements(By.cssSelector(locator));
		}
		else if (type.equals("linktext")) {
			log.info("Element found with link text: " + locator);
			return this.driver.findElements(By.linkText(locator));
		}
		else if (type.equals("partiallinktext")) {
			log.info("Element found with partial link text: " + locator);
			return this.driver.findElements(By.partialLinkText(locator));
		}
		else {
			log.error("Locator type not supported");
			return null;
		}
	}

	
	public boolean isElementPresent(String locator, String type){
		List<WebElement> getElementList = getElementList(locator, type);
		int size = getElementList.size();
		if(size>0){
			return true;
		}else{
			return false;
	}
	}

	public WebElement waitForElement(By locator, int timeout) {
		WebElement element = null;
		try {
			log.info("Waiting for a max: " + timeout + " sec for the element to appear");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			log.info("The Element that you waited for is now displayed on the webpage");
		} catch (Exception e) {
			log.error("The Element that you waited for is not displayed on the webpage");
		}
		return element;
	}

	public void click(By locator, int timeout) {

		try {
			WebElement element = null;
			log.info("Waiting for a max: " + timeout + " sec for the element to be clickable");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			log.info("Element clicked on the webpage");
		} catch (Exception e) {
			log.error("Element not clicked on the webpage");
		}
	}
	
	public void SendKey(By locator, int timeout, String text){
		try{
			WebElement element =  null;
			log.info("Waiting for a max: " + timeout + " sec for the element to be send key");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.sendKeys(text);
			log.info("Value Entered in the place holder");
		}catch (Exception e) {
			log.error("Element not displayed on the webpage");
		}
	}
	
	public void getTitle(){
		String Title = driver.getTitle();
		log.info("The title of the Page is: "+Title);
		if(driver.getPageSource().contains(Title)){
			log.info("The Title is Correct");
		}
		else{
			log.error("The Title is InCorrect");
		}
	}
	
	
	public void switchToiFrame(String value) {
		driver.switchTo().frame(value);
		log.info("Switched to iframe by value : "+value);
	}
	
	public void SwitchToiFrameNo(int value) {
		driver.switchTo().frame(value);
		log.info("Switched to iframe by int : "+value);
	}
	
	public void maximize(){
		driver.manage().window().maximize();
		log.info("Browser Window Maximized");
	}
	
	public boolean pageSourceContains(String text){
		 if(driver.getPageSource().contains(text)){
			 log.info("The Page Source is Fetched");
			 return true;
		 }else{
			 log.error("The Page Source could not be Fetched");
			 return false;
		 }
	}
	
	public boolean elementDisplayed(By Locator){
		WebElement element = driver.findElement(Locator);
		if(element.getSize()!= null){
			log.info("The element at loction: "+Locator+" is displayed");
			return true;
		}else{
			log.error("The element at loction: "+Locator+" is displayed");
			return false;
		}
	}
	
	public boolean elementIsDisplayed(By locator){
		boolean display = driver.findElement(locator).isDisplayed();
		 if(display){
			 log.info("The element: "+locator+" is displayed.");
			 return true;
		 }else{
			 log.error("The element: "+locator+" is NOT displayed.");
			 return false;
		 }
	}

	public void navigateBack(){
		driver.navigate().back();
	}
	
	public void clearField(By locator){
		WebElement field = driver.findElement(locator);
			field.clear();
			log.info("The field is cleared");
	}
	
	public void getText(By locator){
		 String Text = driver.findElement(locator).getText();
		log.info("THe text at locator: "+locator+" is "+Text);
	}
	
	public boolean compareText(By locator){
		String Text = driver.findElement(locator).getText();
		if(driver.getPageSource().contains(Text)){
			log.info("The text: "+Text+" displayed is correct");
			return true;
		}else{
			log.error("The text: "+Text+" displayed is not correct");
			return false;
		}
	}

	public WebElement switchToHandle(String handleName){
		log.info("Switching the window handle to "+handleName);
		return (WebElement) driver.switchTo().window(handleName);	
	}
	
	public Set<String> getHandles(){
	 return driver.getWindowHandles();
	}

	public void implicitWait(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		log.info("Implicitly waiting for "+time+"secs");
	}
	
	public void radioButtonIterate(By locator) throws Exception {
		boolean isChecked = false;
		List<WebElement> radioButtons = driver.findElements(locator);
		int size = radioButtons.size();
		log.info("Size of the list: " + size);
		for (int i=0; i<size; i++) {
			isChecked = radioButtons.get(i).isSelected();
			if (isChecked) {
				WebElement element = driver.findElement(locator);
				if(element.getSize()!= null){
					log.info("The element at loction: "+locator+" is displayed");	
				}else{
					log.error("The element at loction: "+locator+" is displayed");
				}
				 String Text = driver.findElement(locator).getText();
				log.info("THe text at locator: "+locator+" is "+Text);
				if(driver.getPageSource().contains(Text)){
					log.info("The text: "+Text+" displayed is correct");
				}else{
					log.error("The text: "+Text+" displayed is not correct");
				}
				Thread.sleep(2000);
			}
			else{
				radioButtons.get(i).click();
				WebElement element = driver.findElement(locator);
				if(element.getSize()!= null){
					log.info("The element at loction: "+locator+" is displayed");	
				}else{
					log.error("The element at loction: "+locator+" is displayed");
				}
				 String Text = driver.findElement(locator).getText();
				log.info("THe text at locator: "+locator+" is "+Text);
				if(driver.getPageSource().contains(Text)){
					log.info("The text: "+Text+" displayed is correct");
				}else{
					log.error("The text: "+Text+" displayed is not correct");
				}
			}
		}
	}

}
