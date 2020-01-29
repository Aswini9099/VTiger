package com.testyantra.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWFile;

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

	public WebElement getUntb() {
		return untb;
	}

	public WebElement getPwtb() {
		return pwtb;
	}

	public WebElement getLgnbtn() {
		return lgnbtn;
	}
	
	public void loginToApp(String un,String pw)
	{
		untb.sendKeys(un);
		pwtb.sendKeys(pw);
		lgnbtn.click();
		
	}
	WebDriver driver;
	public void loginToApp() throws IOException
	{
		FWFile flib=new FWFile();
		untb.sendKeys(flib.getDataFromProperty("username"));
		pwtb.sendKeys(flib.getDataFromProperty("password"));
		lgnbtn.click();
		
	
		
		
	}
	
	
	
	
	

}
