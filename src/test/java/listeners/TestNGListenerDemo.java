package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("In test1");
	}
	@Test
	public void test2() {
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.quit();
	}
	@Test
	public void test3() {
		System.out.println("In test3");
	}
}
