package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	WebDriver driver;
	public SearchPage (WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath="//h1[normalize-space()='Search - mac']")
	WebElement srcHeading;
	
	@FindBy(xpath="//a[normalize-space()='iMac']")
	WebElement lnkimac;
	
	public boolean isMySearchPageExists()
	{
		try {
			return (srcHeading.isDisplayed());
		}
		catch (Exception e)
		{
			return false;
		}
	}
	public void clickimac()
	{
		lnkimac.click();
	}
	

}
