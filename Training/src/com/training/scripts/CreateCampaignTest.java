package com.training.scripts;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testyantra.pages.CreateNewCampaignPage;
import com.testyantra.pages.CreateNewOrgPage;
import com.testyantra.pages.CreateNewProductPage;
import com.testyantra.pages.HomePage;
import com.testyantra.pages.LoginPage;
import com.testyantra.pages.OrgInfoPage;
import com.testyantra.pages.OrganizationPage;
import com.testyantra.pages.ProductPage;
import com.training.generic.BaseClass;
import com.training.generic.FWUtills;
import com.testyantra.pages.CampaignPage;


public class CreateCampaignTest extends BaseClass{  
	
	@Test(groups= {"RegressionTest"})
	public void createOrg() throws IOException, InterruptedException
	{
		
		
		String proName = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 0)+lib.ranDomNum();
		String cmpName = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 1)+lib.ranDomNum();
		String sponserName = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 2)+lib.ranDomNum();
		
		
		//Home page 
		HomePage hp = new HomePage(driver);
		
		//navigate to Product page 
		ProductPage pro = hp.navigateToProPage();
		System.out.println("-----Navigated to product  page -----");
		
		//navigate to createNew Product 
		 CreateNewProductPage cnp = pro.createNewProd();
		 cnp.createProduct(proName);
		 System.out.println("----Product is created-------");
		 
		 //navigate to campaign page 
		 HomePage hp1 = new HomePage(driver);
		 CampaignPage c = hp1.navigateToMorePage().clickOnCmp();
		 System.out.println("-----Navigated to More and click camapign page -----");
		 
		 //Click on newCampaign
		 CreateNewCampaignPage cnc = c.createCampaign();
	      
		 //create campaign
          cnc.createCampaign(cmpName,proName,sponserName);
		 System.out.println("-----Campaign is created with Product------");
		  
		 	 
			
	}
	
	
	
	
	
	@Test(groups= {"SmokeTest"})
	public void createOrg1() throws IOException, InterruptedException
	{
		
		
		
	String cmpName = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 1)+lib.ranDomNum();
		
	 HomePage hp1 = new HomePage(driver);
	 CampaignPage c = hp1.navigateToMorePage().clickOnCmp();
	 System.out.println("-----Navigated to More and click camapign page -----");
	 
	 //Click on newCampaign
	 CreateNewCampaignPage cnc = c.createCampaign();
      
	 //create campaign
      cnc.createCampaign(cmpName);
	 System.out.println("-----Campaign is created------");
	  
	 	 
		
}
	
	
	@Test(groups= {"RegressionTest"})
	public void createOrg2() throws IOException, InterruptedException
	{
		
		
		String cmpName = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 1)+lib.ranDomNum();
		String sponserName = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 2)+lib.ranDomNum();
		
	 HomePage hp1 = new HomePage(driver);
	 CampaignPage c = hp1.navigateToMorePage().clickOnCmp();
	 System.out.println("-----Navigated to More and click camapign page -----");
	 
	 //Click on newCampaign
	 CreateNewCampaignPage cnc = c.createCampaign();
      
	 //create campaign
      cnc.createCampaign(cmpName,sponserName);
	 System.out.println("-----Campaign is created with sponser name------");
	  
	 	 
		
}

}



