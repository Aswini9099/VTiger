package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProducttainigPage {
	
	@FindBy(xpath="xpath(\"//img[@alt='Create Product...']")
	   private WebElement addProd;
	
	
	
	
	
	   public ProducttainigPage(WebDriver driver)
	  	{
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   public void clickOnProduct()
	   {
		   addProd.click();
	   }

	public void createNewProd() {
		// TODO Auto-generated method stub
		
	}

}
