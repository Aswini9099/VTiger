package com.training.scripts;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testyantra.pages.CreateNewOrgPage;
import com.testyantra.pages.HomePage;
import com.testyantra.pages.LoginPage;
import com.testyantra.pages.OrgInfoPage;
import com.testyantra.pages.OrganizationPage;
import com.training.generic.BaseClass;
import com.training.generic.FWUtills;

public class CreateOrgTest extends BaseClass{  
	
	@Test(groups= {"SmokeTest"})
	public void createOrg() throws IOException, InterruptedException
	{
		
		
		String orgname = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 0);
		String oName = orgname+lib.ranDomNum();
		String emailID = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 2);
		
		 //Home page 
		 HomePage hp = new HomePage(driver);
		 //navigate to Organization page 
		 OrganizationPage op = hp.navigateToOrgPage();
		
		 //navigate to createNew organization 
		 CreateNewOrgPage nop =  op.navigateToNewOrgPage();
		 OrgInfoPage oip = nop.createORg(oName, emailID);
		 System.out.println("-------Organization is created------");
		 String actOrg=oip.getOrgNameInfo().getText();
		 Assert.assertEquals(actOrg, oName);
		 System.out.println("---------Organization name is matched ------");
		 
	}
	
	@Test(groups= {"RegressionTest"})
	public void createOrg2() throws IOException, InterruptedException
	{
		
		
		String orgname = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 0)+lib.ranDomNum();
		String phn = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 1);
		String emailID = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 2);
		
		 //Home page 
		 HomePage hp = new HomePage(driver);
		 //navigate to Organization page 
		 OrganizationPage op = hp.navigateToOrgPage();
		
		 //navigate to createNew organization 
		 CreateNewOrgPage nop =  op.navigateToNewOrgPage();
		 OrgInfoPage oip = nop.createORg(orgname,phn,emailID);
		 System.out.println("-------Organization is created with phNo------");
		 
		 // verify the Organization
		 String actOrg=oip.getOrgNameInfo().getText();
		 Assert.assertEquals(actOrg, orgname);
		 System.out.println("---------Organization name is matched ------");
		 
	}
	
	@Test(groups= {"RegressionTest"})
	public void createOrg1() throws IOException, InterruptedException
	{
		
		String orgname1 = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 0);
		String oName = orgname1+lib.ranDomNum();
		String phn = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 1);
		String emailID = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet1", 1, 2);
		
		//Home PAge 
		 HomePage hp = new HomePage(driver);
		 
		 //navigate to Organization page 
		 OrganizationPage op = hp.navigateToOrgPage();
		
		 //navigate to createNew organization 
		 CreateNewOrgPage nop =  op.navigateToNewOrgPage();
		 OrgInfoPage oip = nop.createORg(oName, emailID);
		 System.out.println("-------Organization is created------");
		 
		 //Verify the organization 
		 String actOrg=oip.getOrgNameInfo().getText();
		 Assert.assertEquals(actOrg, oName);
		 System.out.println("---------Organization name is matched ------");
		 
	    //navigate to createNew organization 
	     CreateNewOrgPage nop1 =  op.navigateToNewOrgPage();
		 OrgInfoPage mem = nop1.createORg(orgname1, phn, emailID, actOrg);
		 System.out.println("-----Member is Selcted and Organization is created------");
		               
		              		
	}
	
	
	
	
	
	
	

}



