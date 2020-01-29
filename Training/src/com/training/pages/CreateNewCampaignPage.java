package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CreateNewCampaignPage {
	
	@FindBy(name="campaignname")
	   private WebElement campName;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	   private WebElement addProd;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	   private WebElement saveCmp;
	
	
	
	
	
	   public CreateNewCampaignPage(WebDriver driver)
	  	{
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   public void EnterCmpName(String cmpName)
	   
	   {
		   FWUtills lib=new FWUtills();
		   
			 cmpName="Hp"+ lib.ranDomNum();
			
		   campName.sendKeys(cmpName);
	   }
	   
	   public void clickOnAddProduct()
	   {
		   addProd.click();
	   }
	   
	   public void clickOnSaveCmp()
	   {
		   saveCmp.click();
	   }


}
