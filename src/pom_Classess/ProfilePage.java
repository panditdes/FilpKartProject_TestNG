package pom_Classess;

import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClassess.UtilityClass1;

public class ProfilePage extends UtilityClass1{

	WebDriver driver;     //declaring as global so we can use in whole class and not initiate 

	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddress;                   
	//giving xpath by using @FindBy so we will use only emailID and perform action on it.it will reduce rework/retype

	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement AddNewAddressText;

	@FindBy(xpath="(//div[@class='_1XFPmK'])[2]")
	private WebElement RadioWork;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement Save;


	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	public void ClickOnManageAddress()
	{
		IsElementVisible(driver,manageAddress);
		manageAddress.click();
	}



	public void ClickOnAddNewAddress()
	{
		IsElementVisible(driver,AddNewAddressText);
		AddNewAddressText.click();
	}

	
	public void GetDataForAddress() throws EncryptedDocumentException, IOException
	{
		
		List<String> list = GetMultipleDataFromExcel(0,3);
				
		for(int i=1;i<=4;i++)
		{
			
			WebElement element = driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
			
			element.sendKeys(list.get(i-1));
		}
	}
	
	public void ClickOnRadio()
	{
		RadioWork.click();
	}
	
	public void ClickOnSave()
	{
		Save.click();
	}
	
}
