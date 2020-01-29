package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CreateNewProductPage {
	
	@FindBy(name="productname")
	   private WebElement prodName;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	   private WebElement proSave;
	
	
	
	
	   public CreateNewProductPage(WebDriver driver)
	  	{
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   
	   
	   public void enterProName(String ProName)
	   {
		   FWUtills lib=new FWUtills();
				   
		String  pro=ProName+ lib.ranDomNum();
		   prodName.sendKeys(pro);
	   }
	
	   public void clickOnProSave()
	   {
		   proSave.click();
	   }
	

}
