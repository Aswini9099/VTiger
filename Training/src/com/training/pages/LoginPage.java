package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	@FindBy(name="user_name")
	private WebElement untb;
	
	@FindBy(name="user_password")
	private WebElement pwtb;
	@FindBy(id="submitButton")
	private WebElement lgnbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getterUN(String un)
	{
		untb.sendKeys(un);
	}
	public void getterpw(String pw)
	{
		pwtb.sendKeys(pw);
	}
	public void clickOnlgn()
	{
		lgnbtn.click();
	}
	 public void login(String username,String password) 
	 {
		 untb.sendKeys(username); 
		 pwtb.sendKeys(password);
		 lgnbtn.click();
	 }
	
	
	
	

}
