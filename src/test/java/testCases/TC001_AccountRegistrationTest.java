package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration()
	{
		
		logger.info("*****Starting TC001_AccountRegistrationTest *****" );
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link" );

		hp.clickRegister();
		logger.info("Clicked on Register link" );

		AccountRegistrationPage rp=new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		rp.setFirstName(randomeString().toUpperCase());
		
		rp.setLastName(randomeString().toUpperCase());
		
		rp.setEmail(randomeString()+"@gmail.com");
		
		rp.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumeric();
		
		rp.setPassword(password);
		
		rp.setConfirmPassword(password);
		
		rp.setPrivacyPolicy();
		
		rp.clickContinue();
		
		logger.info("Validating Expected message");
		
		String confmsg=rp.getConfirmationmsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		
		else {
			logger.error("Test Failed..");
			logger.debug("Debug Logs..");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("*****Finished TC001_AccountRegistrationTest *****" );

		
	}
	
	
}
