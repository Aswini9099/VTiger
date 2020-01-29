package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class MorePage {

	
	

	@FindBy(name="Campaigns")
	   private WebElement CmpLink ;
	

	FWUtills lib=new FWUtills();
	
	
	   public MorePage(WebDriver driver)
	  	{
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   public void clickOnCampaignLink()
	   {
		   
		  CmpLink.click();
	   }
}
