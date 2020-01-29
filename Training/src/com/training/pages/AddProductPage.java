package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class AddProductPage {
	
	@FindBy(name="search_text")
	   private WebElement PSearch ;
	
	@FindBy(name="search_field")
	   private WebElement PListBox ;
	
	@FindBy(name="search")
	   private WebElement PSearchNow ;
	
	@FindBy(xpath="((//table[@class='small'])[3]/tbody/tr[2]/td[1]/a)")
	private WebElement Productadd;
	
	
	
	   public AddProductPage(WebDriver driver)
	  	{
	  		PageFactory.initElements(driver, this);
	  	}
	   
	   public void clickOnSearch(String ProdName)
	   {
		 PSearch.sendKeys(ProdName);
	   }
	   public void clickOnProductListBox(String option)
	   {
		   PListBox.click();
		   FWUtills lib =new FWUtills();
	 		lib.select( PListBox, option);
		 
	   }
	   
	   public void SelectProduct(String Product)
	   {
		   if (Productadd.getText().equals(Product))
		   {
			   Productadd.click(); 
		   }
	   }
	
	

}
