package testClassess;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseClasses.BaseClass1;
import pom_Classess.HomePage;
import pom_Classess.LogInPage;
import pom_Classess.ProfilePage;

public class AddNewAddress {
	
	WebDriver driver;
	LogInPage lp;
	HomePage hp;
	ProfilePage pp;
	
	
	
	@BeforeClass
	
	public void beforeclass() throws InterruptedException
	{
		driver = BaseClass1.getWebDriver();
	}

	
	@BeforeMethod
	
	public void beforemethod()
	{
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
	}
	
	@Test
	
	public void VerifyUserCanLogIn() throws InterruptedException
	{
		lp.EnterEmailID();
		lp.EnterPassword();
		lp.ClickOnSubmitButton();
		hp.hoverToProfileName();
		
		String text = hp.GetLogOutText();
		
			if(text.equals("Logout"))
			{
				System.out.println("TestPassed");
			}
		else
		{
			Assert.fail();
		}
		
	}
	
	
	@Test(priority=1)
	
	public void UserCanAddNewAddress() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		hp.MovePointer();
		hp.hoverToProfileName();
		hp.ClickOnMyProfileText();
		pp.ClickOnManageAddress();
		pp.ClickOnAddNewAddress();
		pp.GetDataForAddress();
		pp.ClickOnRadio();
		//pp.ClickOnSave();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}

}
