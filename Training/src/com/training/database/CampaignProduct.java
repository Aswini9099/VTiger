package com.training.database;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.training.generic.FWUtills;

public class CampaignProduct {
	
	static
	{
		System.setProperty("webdriver.driver.chrome","./driver/chromedriver.exe");
		
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		FWUtills lib=new FWUtills();
		
		lib.implicitWait(driver);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("9099");
		
		driver.findElement(By.id("submitButton")).click();
		
		String ProdName="Hp"+ lib.ranDomNum();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(ProdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
				
				lib.moveToElement(driver, more);
				driver.findElement(By.name("Campaigns")).click();
				driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				String camName = "Aswi"+lib.ranDomNum(); 
				driver.findElement(By.name("campaignname")).sendKeys(camName);
				
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				lib.getChildWindow(driver);
				driver.findElement(By.name("search_text")).sendKeys(ProdName);
				WebElement search = driver.findElement(By.name("search_field"));
				lib.select(search, "Product Name");
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText(ProdName)).click();
				lib.getParentWindow(driver);
			
				//lib.waitForElementAndClick(driver,driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")));
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				  driver.findElement(By.linkText("Campaigns")).click();
			
				  WebElement lc = driver.findElement(By.id("bas_searchfield"));
					 lib.select(lc, "Campaign Name");
					 driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(camName,Keys.ENTER);
					String text = driver.findElement(By.linkText(camName)).getText();
					if(text.equals(camName))
					{
						System.out.println("campaign created");
					}
						
					else 
						System.out.println("campaign is not created");
					
				}
				
						
				
	}			
		

