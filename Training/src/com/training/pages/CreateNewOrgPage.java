package com.training.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CreateNewOrgPage {
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgName;
	
   @FindBy(xpath="//input[@name='phone']")
    private WebElement phoneNo;
   
   @FindBy(xpath="//input[@id='email1']")
   private WebElement emailId;
   
   @FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
   private WebElement memberOf;
   
   @FindBy(xpath="//input[@title='Save [Alt+S]']")
   private WebElement save;
   
   FWUtills lib=new FWUtills();
   
   public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   
   
   
   
   public String  enterOrgName(String orgNam)
   
	{
	  
	   String org= orgNam+ FWUtills.ranDomNum();
		orgName.sendKeys(org);
		return org;
	}
   
   public void enterPhone(String phNo)
   {
	   phoneNo.sendKeys(phNo);
   }
  
   public void enterEmail(String email)
   {
	   emailId.sendKeys(email);
   }
   public void ClickOnMemberOf()
   {
	   memberOf.click();
   }
   
   public void clickOnSave()
   {
	   save.click();
   }
    String MemberName;
   public void createMemOrganization() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException
   {
	   
	    String name1 = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 0);
		MemberName = enterOrgName(name1);
		String phno = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 1);
		enterPhone(phno);
		Thread.sleep(1000);
	    clickOnSave();
	    Thread.sleep(1000);
   }
   
   WebDriver driver;
   public static String organizaName;
   
   public void createOrganization() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException
   {
	  
	   String orgname = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 0);
		 organizaName = enterOrgName(orgname);
		String phn = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 1);
		enterPhone(phn);
		String email = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 2);
		enterEmail(email);
		ClickOnMemberOf();
		lib.getChildWindow(driver);
		CreateMemberOfPage cmp= new CreateMemberOfPage(driver);
		cmp.createMemberOFLookup(MemberName);
        lib.getParentWindow(driver);
		clickOnSave();
		
	
   }
   
   
}
