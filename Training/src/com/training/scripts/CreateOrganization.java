package com.training.scripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.training.generic.FWFile;
import com.training.generic.FWUtills;
import com.training.pages.CreateMemberOfPage;
import com.training.pages.CreateNewOrgPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.OrganizationPage;

public class CreateOrganization  {
	
	@Test
	public void createOrg() throws IOException, InterruptedException
	{
		
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FWUtills lib=new FWUtills();
		FWFile fw=new FWFile();
		lib.implicitWait(driver);
		String url=fw.getDataFromProperty("url");
		driver.get(url);
		
		LoginPage lp =new LoginPage(driver);
		String username=fw.getDataFromProperty("username");
		String password=fw.getDataFromProperty("password");
		lp.login(username, password);
		//Click on organization Link 
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(1000);
		hp.organizationLink();
		 
		//click on add organization 
		
		OrganizationPage org = new OrganizationPage(driver);
		org.clickOnAddOrg();
		
		//add organization/member page 
		
		CreateNewOrgPage cno=new CreateNewOrgPage(driver);
		
		
		String name1 = lib.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 0);
		String MemberName = cno.enterOrgName(name1);
		String phno = lib.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 1);
		cno.enterPhone(phno);
		cno.clickOnSave();
		
		Thread.sleep(2000);
		
		
		//create  organization 
		hp.organizationLink();
		org.clickOnAddOrg();
		String orgname = lib.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 0);
		String organizaName = cno.enterOrgName(orgname);
		String phn = lib.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 1);
		cno.enterPhone(phn);
		String email = lib.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 2);
		cno.enterEmail(email);
		
		cno.ClickOnMemberOf();
		
		lib.getChildWindow(driver);
		
		// click on memberof page 
		CreateMemberOfPage cmp= new CreateMemberOfPage(driver);
		cmp.enterMOrgName(MemberName);
		cmp.SelectMOption("Organization Name");
		cmp.clickOnSearchNow();
		cmp.clickOnOrgNameInTable(MemberName);
		lib.acceptAlert(driver);
		
		lib.getParentWindow(driver);
		
		cno.clickOnSave();
		
		Thread.sleep(2000);
		
		hp.organizationLink();
		org.SearchFor(organizaName);
		org.inselectBox("Organization Name");
		org.clickOnSearchNow();
		Thread.sleep(1000);
		org.checkOrgPresent(organizaName);
		
			
		
	}

}
