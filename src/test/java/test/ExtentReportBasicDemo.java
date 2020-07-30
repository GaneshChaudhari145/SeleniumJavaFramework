package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicDemo {
	
	private static WebDriver driver=null;

	public static void main(String[] args) {
		
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
        
     // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test", "Search functionality");
        
        String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		test1.log(Status.INFO, 	"Starting Test case");
		driver.get("https://www.google.com/");
		test1.pass("Navigate to google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in search box");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("pressed keyboard key");
		driver.close();
		test1.pass("close the browser");
		
		 extent.flush();
        
	}

}
