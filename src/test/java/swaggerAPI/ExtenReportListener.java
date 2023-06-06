package swaggerAPI;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtenReportListener  implements ITestListener {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports reports;
	public static ExtentTest logger;

	public void onStart(ITestContext arg0) {

		sparkReporter = new ExtentSparkReporter("./target/Spark.html");
		sparkReporter.config().setDocumentTitle("Swagger API test");
		sparkReporter.config().setReportName("Pet api test");
		sparkReporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.setSystemInfo("project name : ", "pet api database");
		reports.setSystemInfo("host name : ", "local host");
		reports.setSystemInfo("Environment : ", "QA");
		reports.setSystemInfo("user : ", "Jawad");

		reports.attachReporter(sparkReporter);

	}

	public void onTestStart(ITestResult result) {

		logger = reports.createTest(result.getName());
		logger.info(result.getName()+" tes started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger = reports.createTest(result.getName());
		logger.pass(result.getName()+" tes passed");

	}

	public void onTestFailure(ITestResult result) {
		logger = reports.createTest(result.getName());
		logger.fail(result.getName()+" tes failed");

	}

	public void onTestSkipped(ITestResult result) {
		logger = reports.createTest(result.getName());
		logger.skip(result.getName()+" tes skipped");

	}


	public void onTestSuccess(ITestResult result) {
		logger = reports.createTest(result.getName());
		logger.pass(result.getName()+" tes succeed");

	}

	public void onFinish(ITestContext result) {
		logger = reports.createTest(result.getName());
		logger.info(result.getName()+" tes finished");
		reports.flush();

	}
}
