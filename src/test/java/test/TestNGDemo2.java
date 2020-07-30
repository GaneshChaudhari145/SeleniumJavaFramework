package test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo2 {

	WebDriver driver=null;
	@BeforeTest
	public void setUpTest()
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test
	public void googleSearch2()
	{
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		//driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}
	@Test
	public void googleSearch3()
	{
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		//driver.findElement(By.name("btnk")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
	}
	@AfterTest
	public void teadDownTest()
	{
		//driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
