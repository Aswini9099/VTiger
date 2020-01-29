package com.training.generic;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.testyantra.pages.HomePage;
import com.testyantra.pages.LoginPage;

public class BaseClass {
	
	
	public FWUtills  lib= new FWUtills();
	public FWFile flib=new FWFile();
	public WebDriver driver;
	
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void configBC() throws IOException
	{
		String BrowserName = flib.getDataFromProperty("browser");
		System.out.println("=======launch the browser=======");
		if(BrowserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		else if(BrowserName.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
	}
	

	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void configBM() throws IOException
	{
		String URL = flib.getDataFromProperty("url");
		String USERNAME = flib.getDataFromProperty("username");
		String PASSWORD= flib.getDataFromProperty("password");
		System.out.println("-----login------");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lib.implicitWait(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void configAM() throws InterruptedException 
	{
	
	HomePage hp= new HomePage(driver);
	hp.logoutformAPP();
	System.out.println("-----logout------");
	}
	
	
	
	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void configAC() throws IOException
	{
	
	driver.close();
	System.out.println("-----close Browser------");
	}
	
	
	
}
