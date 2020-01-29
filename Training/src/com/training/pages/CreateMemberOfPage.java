package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CreateMemberOfPage {
	
	
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement mSearch;
	
   @FindBy(name="search_field")
    private WebElement mInListBox;
   
   @FindBy(name="search")
   private WebElement mSearchNow;
   
   @FindBy(xpath="(//table[@class='small'])[3]/tbody/tr[2]/td[1]/a")
   //(//table[@class='small'])[3]/tbody/tr[2]/td[1]/a
   private WebElement selectOrg;
   
   WebDriver driver;
   FWUtills lib =new FWUtills();
   public CreateMemberOfPage(WebDriver driver)
  	{
  		PageFactory.initElements(driver, this);
  	}
     
     public void enterMOrgName(String orgNam) throws InterruptedException
  	{
    	 lib.waitForElementAndClick(driver, mSearch);
  		mSearch.sendKeys(orgNam);
  	}
     public void SelectMOption(String option)
   	{
   	        mInListBox.click();
   	     
 		lib.select(mInListBox, option);
   	}
     
     public void clickOnSearchNow()
    	{
    	        mSearchNow.click();
   
    	}
     
     public void clickOnOrgNameInTable(String organame)
 	{
 	     if(selectOrg.getText().equals(organame))   
 	     {
 	    	 
    	 selectOrg.click();
 	}
 	}
          
     public void createMemberOFLookup(String Memname) throws InterruptedException
     {
    
    	 enterMOrgName(Memname);
 	     SelectMOption("Organization Name");
 		 clickOnSearchNow();
 	     clickOnOrgNameInTable(Memname);
 	     lib.acceptAlert(driver);
 	      
     }
}
