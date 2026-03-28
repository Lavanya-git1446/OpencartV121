package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;
import testBase.BaseClass;


/* Data is valid-- login success--testpass---logout
 * data is valid- login failed--test fail
 *   
 *   Data is invalid-- login success--testfail---logout
 * data is invalid- login failed--test pass
 * 
 */

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")//getting data provider from different class
public void verify_loginDDT(String email, String pwd, String exp)
{
	logger.info("****starting TC003_LoginDDT******");
try {
HomePage hp=new HomePage(driver);
hp.clickMyAccount();
hp.clickLogin();

LoginPage lp=new LoginPage(driver);
{
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
}
//myaccountPage
MyAccountPage macc=new MyAccountPage(driver);
boolean targetpage=macc.isMyAccountPageExists();
 
if(exp.equalsIgnoreCase("Valid"))
{
	if(targetpage==true)
	{
		macc.clickLogout();
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}
if(exp.equalsIgnoreCase("Invalid"))
{
	if(targetpage==true)
	{
		macc.clickLogout();
		Assert.assertTrue(false);
	}
	else
	{
		Assert.assertTrue(true);
	}
	
}
}catch(Exception e)
{
	Assert.fail();
}

logger.info("****finished TC003_LoginDDT******");


}
}