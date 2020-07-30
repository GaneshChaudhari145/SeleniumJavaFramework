package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserDemo {

	WebDriver driver=null;
	String path=System.getProperty("user.dir");

	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("ff")) 
		{
			System.setProperty("webdriver.gecko.driver", path+"\\drivers\\geckodriver\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", path+"\\drivers\\iedriver\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}
	}

	@Test
	public void test1() throws InterruptedException
	{
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
