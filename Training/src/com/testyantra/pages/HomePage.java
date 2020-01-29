package com.testyantra.pages;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;
import com.testyantra.pages.ProductPage;


public class HomePage extends FWUtills{
	
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orgLink;
	
   @FindBy(xpath="//a[text()='Products']")
    private WebElement proLink;
   
   @FindBy(xpath="//a[text()='More']")
   private WebElement moreLink;
   
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement logouticon;
   
   @FindBy(linkText="Sign Out")
   private WebElement logout;
   
   WebDriver driver;
   public HomePage(WebDriver driver)
   
	{
	   this.driver=driver;
		PageFactory.initElements(driver, this);
	}

   public WebElement getOrgLink() {
	return orgLink;
   }

   public WebElement getProLink() {
	return proLink;
   }

    public WebElement getMoreLink() {
	return moreLink;
    }
    
    
    
    public void logoutformAPP() throws InterruptedException
    {
    	//lib.waitForElementVisibility(driver, logouticon);
    	moveToElement(driver, logouticon);
    	//lib.waitForElementAndClick(driver, logout);
    	logout.click();
    	
    }
   
	public OrganizationPage navigateToOrgPage()
	
	{
		orgLink.click();
	   OrganizationPage org=new  OrganizationPage(driver);
			return org;
		
	}
	
	
public ProductPage navigateToProductPage()
	
	{
	
	proLink.click();
	return new ProductPage(driver);
	
	
	}

	FWUtills lib=new FWUtills();
     public ProductPage navigateToProPage() throws InterruptedException
	
	{
    	 lib.waitForElementAndClick(driver, proLink);
		proLink.click();
	    return new  ProductPage(driver);
		
	}
    
     
     
     public MorePage navigateToMorePage()
 	
 	{
 		moreLink.click();
 		lib.moveToElement(driver,moreLink);
 	    return new  MorePage(driver);
 		
 	}
	
	
	
}
