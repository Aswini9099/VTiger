package com.testyantra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class ProductPage {
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	   
	private WebElement Productadd;
	
	
	
	
	
	FWUtills lib=new FWUtills();
	
	WebDriver driver;
	   public ProductPage(WebDriver driver)
	  	{
		   this.driver=driver;
	  		PageFactory.initElements(driver, this);
	  	}
	
	
	
	public WebElement getProdName() {
		return Productadd;
	}
	
	
	public CreateNewProductPage createNewProd() throws InterruptedException 

	
	{
		lib.waitForElementAndClick(driver, Productadd);
		Productadd.click();
		return new CreateNewProductPage(driver);
		
	}


	


}
