package com.testyantra.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrg;
	
	
	WebDriver driver;

	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	

	
	
	public CreateNewOrgPage navigateToNewOrgPage() throws InterruptedException
	
	{
		createOrg.click();
		return new  CreateNewOrgPage(driver);
		
	}





	public WebElement getCreateOrg()
	{
		return createOrg;
	}
	
	
	
	
	
}
