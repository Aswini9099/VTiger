package com.testyantra.pages;

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
   private WebElement selectOrg;
   
   WebDriver driver;
   FWUtills lib =new FWUtills();
   
   public CreateMemberOfPage(WebDriver driver)
  	{
  		this.driver=driver;
	    PageFactory.initElements(driver, this);
  	}
     


	public WebElement getmSearch() {
		return mSearch;
	}

	public WebElement getmInListBox() {
		return mInListBox;
	}

	public WebElement getmSearchNow() {
		return mSearchNow;
	}
	
	public WebElement getSelectOrg() {
		return selectOrg;
	}
	
	
	public CreateNewOrgPage selectMember(String MemName)
	{
		mSearch.click();
		mInListBox.click();
		lib.select(mInListBox,"Organization Name");
		mSearchNow.click();
		selectOrg.click();
		lib.acceptAlert(driver);
		return new CreateNewOrgPage(driver);
		
	}



	
	
}
