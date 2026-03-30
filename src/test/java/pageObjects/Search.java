package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends BasePage {
	
	WebDriver driver;
	 public Search(WebDriver driver)
	 {
		super(driver);
	 }
	 
	 @FindBy(xpath="//input[@placeholder='Search']")
	 WebElement search;
	 
	 @FindBy(xpath="//i[@class='fa fa-search']")
	 WebElement srbtn;
	 
	 public void setname (String src)
	 {
		 search.sendKeys(src);
	 }
	 
	 public void ClickBtn()
	 {
		 srbtn.click();
	 }
}

