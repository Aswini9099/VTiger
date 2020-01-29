package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgLink;
	
   @FindBy(xpath="//a[text()='Products']")
    private WebElement proLink;
   
   @FindBy(xpath="//a[text()='More']")
   private WebElement moreLink;
   
   public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   FWUtills lib=new FWUtills();
   WebDriver driver;
   public void organizationLink() throws InterruptedException
	{
	  
	 
	lib.waitForElementAndClick(driver,orgLink );
		orgLink.click();
	}
   
   public void productLink(WebDriver driver)
   {
	   proLink.click();
   }
   public void moreLink(WebDriver driver)
   {
	   moreLink.click();
	   lib.moveToElement(driver, moreLink);
   }

public void logoutformAPP() {
	// TODO Auto-generated method stub
	
}
   
   
   
   
   
   
   
   
   
  
}
