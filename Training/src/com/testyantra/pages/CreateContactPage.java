package com.testyantra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	   private WebElement createCampaign;
	

	WebDriver driver;
	   public CreateContactPage(WebDriver driver)
	  	{   
		   this.driver=driver;
	  		
		   PageFactory.initElements(driver, this);
	  	}
	   
	  

}
