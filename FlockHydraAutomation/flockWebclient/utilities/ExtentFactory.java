package utilities;

import com.relevantcodes.extentreports.ExtentReports;;

public class ExtentFactory {
	public static ExtentReports getInstance(){
		ExtentReports extent;
		String path = "C:\\Automation\\ExtentReport\\searchPlus.html";
		extent = new ExtentReports(path, false);
		extent
		.addSystemInfo("Selenium Version", "3.4.0")
		.addSystemInfo("Platform", "Win 10");
		
		return extent;
	}

}
