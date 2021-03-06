package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver=null;
	
	By textbox_Search=By.xpath("//input[@type='text']");
	
	By button_Search=By.name("btnK");
	
	public GoogleSearchPageObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	public void setTextSearchBox(String text)
	{
		driver.findElement(textbox_Search).sendKeys(text);
	} 
	
	public void clickSearchButton()
	{
		driver.findElement(button_Search).sendKeys(Keys.RETURN);
	}

}
