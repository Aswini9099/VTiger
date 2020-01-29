package com.testyantra.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class AddProductToCampaignPage {
	
	@FindBy(name="search_text")
	   private WebElement PSearch ;
	
	@FindBy(name="search_field")
	   private WebElement PListBox ;
	
	@FindBy(name="search")
	   private WebElement PSearchNow ;
	
	@FindBy(xpath="((//table[@class='small'])[3]/tbody/tr[2]/td[1]/a)")
	private WebElement Productadd;
	
	 FWUtills lib =new FWUtills();
	WebDriver driver;
	   public AddProductToCampaignPage(WebDriver driver)
	  	{
		   this.driver=driver;	   
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   
	   
	   public CreateNewCampaignPage clickOnProduct(String prodName)
	   {
		   PSearch.sendKeys(prodName);
		   PListBox.click();
		  lib.select( PListBox, "Product Name");
		  PSearchNow.click();
		  Productadd.click();
		  return new CreateNewCampaignPage(driver) ;
		 
	   }
	  

}
