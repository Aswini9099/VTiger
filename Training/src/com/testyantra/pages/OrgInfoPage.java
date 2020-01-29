package com.testyantra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class OrgInfoPage {
	
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgNameInfo;
	
   FWUtills lib=new FWUtills();
   WebDriver driver;
   public OrgInfoPage(WebDriver driver)
	{
	   this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   



public WebElement getOrgNameInfo() {
	// TODO Auto-generated method stub
	return orgNameInfo;
}


   

}
