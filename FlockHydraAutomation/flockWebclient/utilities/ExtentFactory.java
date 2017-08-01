package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import resources.DefaultStrings;;

public class ExtentFactory {
	public static ExtentReports getInstance(){
		ExtentReports extent;
		String path = DefaultStrings.Extent_Report_SearchPlus;
		extent = new ExtentReports(path, false);
		extent
		.addSystemInfo("Selenium Version", "3.4.0")
		.addSystemInfo("Platform", "Win 10");
		
		return extent;
	}

}
