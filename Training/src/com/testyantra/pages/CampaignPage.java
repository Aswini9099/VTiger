package com.testyantra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CampaignPage {

	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	   private WebElement createCampaign;
	

	WebDriver driver;
	   public CampaignPage(WebDriver driver)
	  	{   
		   this.driver=driver;
	  		
		   PageFactory.initElements(driver, this);
	  	}
	   
	  
	   public CreateNewCampaignPage  createCampaign()
	   {
		   createCampaign.click();
		   return new CreateNewCampaignPage(driver);
	   }
	   
	   
}
