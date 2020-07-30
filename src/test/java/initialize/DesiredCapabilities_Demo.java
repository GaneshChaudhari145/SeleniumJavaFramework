package initialize;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {
		
		String path=System.getProperty("user.dir");
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		System.setProperty("webdriver.ie.driver", path+"\\drivers\\iedriver\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver(caps);
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close(); 
	}

}
