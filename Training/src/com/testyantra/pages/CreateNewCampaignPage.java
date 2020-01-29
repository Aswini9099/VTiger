package com.testyantra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CreateNewCampaignPage {
	
	@FindBy(name="campaignname")
	   private WebElement campName;
	
	@FindBy(id="sponsor")
	   private WebElement spons;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	   private WebElement addProd;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	   private WebElement saveCmp;
	
	
	
	FWUtills lib=new FWUtills();
	WebDriver driver;
	   public CreateNewCampaignPage(WebDriver driver)
	  	{
		   
		   this.driver=driver;
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   public void createCampaign (String campaignName,String proName,String sponser)
	   {
		 campName.sendKeys(campaignName);
		 spons.sendKeys(sponser);
		 addProd.click();
		 lib.getChildWindow(driver);
		 AddProductToCampaignPage ap =new AddProductToCampaignPage(driver);
		 ap.clickOnProduct(proName);
		 lib.getParentWindow(driver);
		 saveCmp.click();
	   }
	   
	   
	   public void createCampaign (String campaignName)
	   {
		 campName.sendKeys(campaignName);
		 saveCmp.click();
	   }
	   
	   public void createCampaign (String campaignName,String sponser)
	   {
		 campName.sendKeys(campaignName);
		 spons.sendKeys(sponser);
		 addProd.click();
		 saveCmp.click();
	   }
	   

}
