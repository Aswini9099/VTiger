package com.testyantra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class MorePage {

	
	

	@FindBy(name="Campaigns")
	   private WebElement CmpLink ;
	
	
	WebDriver driver;
	
	   public MorePage(WebDriver driver)
	  	{
		   this.driver=driver;
	  		PageFactory.initElements(driver, this);
	  	}
	   

	public WebElement getCmpLink() {
		return CmpLink;
	}
	
	
	FWUtills lib=new FWUtills();
	public CampaignPage clickOnCmp()
	{
	
		CmpLink.click();
		return new CampaignPage(driver) ;
		
	}
}
