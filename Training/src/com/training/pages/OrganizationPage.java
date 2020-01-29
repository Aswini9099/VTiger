package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generic.FWUtills;

public class OrganizationPage {
	
	
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement addOrg;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchFor;
	
	@FindBy(id="bas_searchfield")
	private WebElement inSelectBox;
	
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	private WebElement searchNow;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[3]/td[3]/a")
	private WebElement orgTable;
	
	
	
	
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	
	public void clickOnAddOrg()
	{
		addOrg.click();
	}
	
	public void SearchFor(String Orgname)
	{
		searchFor.sendKeys(Orgname);
	}
	
	public void inselectBox(String option )
	{
		inSelectBox.click();
		FWUtills lib =new FWUtills();
		lib.select(inSelectBox, option);
		
	}
	public void clickOnSearchNow()
	{
		searchNow.click();
	}
	
	public void checkOrgPresent( String orgname)
	{
		
		String ON=orgTable.getText();
		if(ON.equals(orgname))
		{
			System.out.println("Organization is present");
		}
		else
			System.out.println("organization is not present");
	}
	
	WebDriver driver;
	public void searchOrg() {
		
		CreateNewOrgPage cno=new CreateNewOrgPage(driver);
		SearchFor(cno.organizaName);
		inselectBox("Organization Name");
		clickOnSearchNow();
		checkOrgPresent(cno.organizaName);
	}
	
	
	
	
	
}
