package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CampaignPage {

	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	   private WebElement createCampaign;
	
	@FindBy(name="search_text")
	   private WebElement cSearch;
	
	@FindBy(id="bas_searchfield")
	   private WebElement cListBox;
	
	@FindBy(name="search")
	   private WebElement cSearchNow;
	
	   public CampaignPage(WebDriver driver)
	  	{
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   public void clickOnCreateCmp()
	   {
		   createCampaign.click();
	   }
	   
	   
	   public void EnterSearchCampaignName(String CmpName)
	   {
		   cSearch.sendKeys(CmpName);
	   }
	   
	   public void SearchCampaignoption(String option)
	   {
		   cListBox.click();
		   FWUtills lib =new FWUtills();
			lib.select(cListBox, option);
	   }
	   
	   public void clickOnSearchNow()
	   {
		   cSearchNow.click();
	   }

	public Object createCampaign() {
		// TODO Auto-generated method stub
		return null;
	}
	   
	   
	   
}
