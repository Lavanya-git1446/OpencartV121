package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC002_LoginTest extends BaseClass {
	@Test(groups= {"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("****Starting TC_002 LoginTest*****");
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
		//myaccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true,"Login Failed");
		}
		catch (Exception e){
			Assert.fail();
		}
		
		logger.info("****Finish TC_002 LoginTest*****");

	}

}
