package utilities;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListeners implements IInvokedMethodListener, ITestListener, ISuiteListener {
	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// Before every method in the Test class

		System.out.println(
				"About to begin executing following method (beforeInvocation): " + arg1.getTestClass().getName() + " => " + arg0.getTestMethod().getMethodName());
	}

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// After every method in the Test class
		System.out.println(
				"afterInvocation: " + arg1.getTestClass().getName() + " => " + arg0.getTestMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// Will run after every <test> tag in the xml file
		System.out.println("Finished <test> tag with name: " + arg0.getName());

	}

	@Override
	public void onStart(ITestContext arg0) {
		// Will run before every <test> tag in the xml file
		System.out.println("Starting <test> tag with name: " + arg0.getName());
		ITestNGMethod methods[] = arg0.getAllTestMethods();
		System.out.println("The following methods from the <test> tag will be executed: ");
		for (ITestNGMethod method : methods) {
			System.out.println(method.getMethodName());
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// if the test method is fails i.e for @Test annotations only
		System.out.println("Failed Test (onTestFailure): " + arg0.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// if the test method is skipped i.e for @Test annotations only
		System.out.println("Skipped Test (onTestSkipped): " + arg0.getName());
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// When test method starts i.e for @Test annotations only
		System.out.println("Starting Test (onTestStart): " + arg0.getName());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// if the test method is successfully i.e for @Test annotations only
		System.out.println("Successful Test (onTestSuccess): " + arg0.getName());
	}

	@Override
	public void onStart(ISuite arg0) {
		// Runs when the <suite> tag starts
		System.out.println("Starting the Suite");
	}

	@Override
	public void onFinish(ISuite arg0) {
		// Runs when the <suite> tag ends
		System.out.println("Completed the Suite");
	}

}
