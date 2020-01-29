package com.training.scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testyantra.pages.CreateNewProductPage;
import com.testyantra.pages.HomePage;
import com.testyantra.pages.ProductPage;
import com.training.generic.BaseClass;
import com.training.generic.FWUtills;

public class CreateProductTest extends BaseClass{

	
	@Test(groups= {"SmokeTest"})
	public void createProd() throws IOException, InterruptedException
	{
		
		
		String Proname = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 0);
		
		
		 //Home page 
	
		HomePage hp = new HomePage(driver);
		//navigate to product page 
		ProductPage pro = hp.navigateToProductPage();
		System.out.println("-----navigated to product page------");
		CreateNewProductPage cnp = pro.createNewProd();
		System.out.println("----product page ----- ");
		cnp.createProduct(Proname);
		System.out.println("----product is created-----");
		
		 
}
	@Test(groups= {"RegressionTest"})
	public void createProd1() throws IOException, InterruptedException
	{
		
		
		String Proname = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 0);
		String prodsheet= FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 1);
		String website= FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 2);
		
		 //Home page 
		
		HomePage hp = new HomePage(driver);
		//navigate to product page 
		ProductPage pro = hp.navigateToProductPage();
		System.out.println("-----navigated to product page------");
		CreateNewProductPage cnp = pro.createNewProd();
		System.out.println("----product page ----- ");
		cnp.createProduct(Proname,prodsheet,website);
		System.out.println("----product is created  with all details-----");
	}
	
	
	
	
	@Test(groups= {"RegressionTest"})
	public void createProd2() throws IOException, InterruptedException
	{
		
		
		String Proname = FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 0);
		String prodsheet= FWUtills.read_XL_Data("./datasource/data.xlsx", "sheet2", 1, 1);
				
		 //Home page 
		
		HomePage hp = new HomePage(driver);
		//navigate to product page 
		ProductPage pro = hp.navigateToProductPage();
		System.out.println("-----navigated to product page------");
		CreateNewProductPage cnp = pro.createNewProd();
		System.out.println("----product page ----- ");
		cnp.createProduct(Proname,prodsheet);
		System.out.println("----product is created with prodsheet-----");
	}
}

