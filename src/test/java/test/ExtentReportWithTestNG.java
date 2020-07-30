package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	private static WebDriver driver=null;

	@BeforeSuite
	public void setUp()
	{
		htmlReporter = new ExtentHtmlReporter("extentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest()
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Test
	public void test1() throws IOException {
		ExtentTest test = extent.createTest("Google Search Test", "Search functionality");
		driver.get("https://www.google.com/");
		test.pass("Navigate to google.com");
		
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.info("This step shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	@AfterTest
	public void teadDownTest()
	{
		driver.quit();
	}
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
