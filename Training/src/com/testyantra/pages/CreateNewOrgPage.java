package com.testyantra.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CreateNewOrgPage {
	
	public static final String ORgN = null;

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgName;
	
   @FindBy(xpath="//input[@name='phone']")
    private WebElement phoneNo;
   
   @FindBy(xpath="//input[@id='email1']")
   private WebElement email;
   
   @FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
   private WebElement memberOf;
   
   @FindBy(xpath="//input[@title='Save [Alt+S]']")
   private WebElement save;
   
   FWUtills lib=new FWUtills();
   WebDriver driver;
   public CreateNewOrgPage(WebDriver driver)
	{
	   this.driver=driver;
		PageFactory.initElements(driver, this);
	}

public WebElement getOrgName() {
	return orgName;
}

public WebElement getPhoneNo() {
	return phoneNo;
}

public WebElement getEmailId() {
	return email;
}

public WebElement getMemberOf() {
	return memberOf;
}

public WebElement getSave() {
	return save;
}

public OrgInfoPage createORg(String orgname,String phNo,String emailId)
{
	orgName.sendKeys(orgname);
	phoneNo.sendKeys(phNo);
	email.sendKeys(emailId);
	save.click();
	return new OrgInfoPage(driver);
}

public OrgInfoPage createORg(String orgname,String emailId) throws InterruptedException
{
	orgName.sendKeys(orgname);
	email.sendKeys(emailId);
	//lib.waitForElementAndClick(driver, save);
	save.click();
	return new OrgInfoPage(driver);
}

public OrgInfoPage createORg(String orgname,String phNo,String emailId,String MemName)
{
	orgName.sendKeys(orgname);
	phoneNo.sendKeys(phNo);
	email.sendKeys(emailId);
	memberOf.click();
	lib.getChildWindow(driver);
	CreateMemberOfPage cmp=new CreateMemberOfPage(driver);
	cmp.selectMember(MemName);
	lib.getParentWindow(driver);
	save.click();
	return new OrgInfoPage(driver);
}

public OrgInfoPage createORg() throws EncryptedDocumentException, FileNotFoundException, IOException
{
	
	String orgname = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 0);
	String ORgN=orgname+lib.ranDomNum();
	String phn = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 1);
	
	String emailID = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 2);
	orgName.sendKeys(ORgN);
	phoneNo.sendKeys(phn);
	email.sendKeys(emailID);
	save.click();
	return new OrgInfoPage(driver);
	
	
}



}
   
   
   
   
