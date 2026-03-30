package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Search;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchTest extends BaseClass {
	
	
	@Test(groups= {"sanity","master"})
	public void verify_search()
	{
		logger.info("*****Starting TC004_SearchTest****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		{
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
	}

	
	Search sh = new Search(driver);
	sh.setname(p.getProperty("src"));
	sh.ClickBtn();
	Thread.sleep(5000);
		
		
		SearchPage srpage=new SearchPage(driver);
		boolean targetpage=srpage.isMySearchPageExists();
		Thread.sleep(5000);
		srpage.clickimac();
		Thread.sleep(5000);
		Assert.assertEquals(targetpage, true,"Search Failed");
		
		}
	catch (Exception e){
		Assert.fail();
	}
		
	
		
		logger.info("*****Finished TC004_SearchTest****");
	
}
}
