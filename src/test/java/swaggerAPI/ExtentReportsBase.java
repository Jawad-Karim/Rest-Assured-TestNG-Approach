package swaggerAPI;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsBase {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports reports;
	public static ExtentTest logger;

	public static int i = 0;

	@BeforeSuite
	public void setupReport() {

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


	@AfterMethod
	public void getResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {			
			logger.pass(result.getName()+" : is passed");
			i++;
		}		
		else if(result.getStatus()==ITestResult.FAILURE) {			
			logger.fail(result.getName()+" : is failed");
			i++;
		}		
		else if(result.getStatus()==ITestResult.SKIP) {			
			logger.skip(result.getName()+" : is skipped");
			i++;
		}		
	}	

	@AfterSuite
	public void tearDown() {		
		reports.flush();
	}
}
