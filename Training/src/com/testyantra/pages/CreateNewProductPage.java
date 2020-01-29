package com.testyantra.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class CreateNewProductPage {
	
	@FindBy(xpath="//input[@class='detailedViewTextBox']")
	   private WebElement prodName;
	
	
	
	@FindBy(id="productsheet")
	   private WebElement prodsheet;
	
	
	@FindBy(name="website")
	   private WebElement website;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	   private WebElement proSave;
	
	
	FWUtills lib=new FWUtills();
	WebDriver driver;
	   public CreateNewProductPage(WebDriver driver)
	  	{
		   
		 
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   
	   
	   public void createProduct(String Productname ) throws InterruptedException
	   {
		  
		// lib.waitForElementAndClick(driver, prodName);
		 prodName.sendKeys(Productname);
		 //lib.acceptAlert(driver);
		 proSave.click();
		
		   
	   }
	   
	   public void createProduct(String Productname,String productsheet ) throws InterruptedException
	   {
		  
		// lib.waitForElementAndClick(driver, prodName);
		 prodName.sendKeys(Productname);
		 prodsheet.sendKeys(productsheet);
		 //lib.acceptAlert(driver);
		 proSave.click();
		
		   
	   }
	   
	   public void createProduct(String Productname,String productsheet,String websitefield) throws InterruptedException
	   {
		  
		// lib.waitForElementAndClick(driver, prodName);
		 prodName.sendKeys(Productname);
		 prodsheet.sendKeys(productsheet);
		 website.sendKeys(websitefield);
		  //lib.acceptAlert(driver);
		 proSave.click();
		 
	   }
	

}
