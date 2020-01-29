package com.training.database;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.training.generic.FWUtills;

public class EndToEnd {
	
	
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
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//img[@alt='Create Organization...']"));
				 ele.click();
				 //lib.waitForElementAndClick(driver, ele);
				 
				 String OrgName="ty_"+lib.ranDomNum();
				 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
				 driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123456789");
				 driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("asw@gmail.com");
				 WebElement save = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
				 save.click();
				 lib.waitForElementAndClick(driver,save);
				 
				 
				 
				 driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	
				 WebElement element = driver.findElement(By.xpath("//img[@alt='Create Organization...']"));
						 element.click();
						 lib.waitForElementAndClick(driver, element);
				 
				 String OrgName2="ty_"+lib.ranDomNum();
				 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName2);
				 driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123456789");
				 driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("asw@gmail.com");
				 driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				 lib.getChildWindow(driver);
				 driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName);
				 WebElement search = driver.findElement(By.name("search_field"));
				   search.click();
					lib.select(search, "Organization Name");
					driver.findElement(By.name("search")).click();
					driver.findElement(By.linkText(OrgName)).click();
					lib.acceptAlert(driver);
					
					lib.getParentWindow(driver);
					Thread.sleep(1000);
				 WebElement sav = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
				 sav.click();
				 lib.waitForElementAndClick(driver,sav);
				 
					
					driver.findElement(By.xpath("//a[text()='Organizations']")).click();
			
					
					driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName2);
					WebElement search1 = driver.findElement(By.id("bas_searchfield"));
					search1.click();
					lib.select(search1, "Organization Name");
					
					driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();
					
					
					List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
					for(WebElement wb:list)
					{
						//System.out.println(wb.getText());
						if(wb.getText().equals(OrgName2))
						{
							System.out.println("Organization name is present");
						}
						else 
							System.out.println("Organization name is not present");
					}

		
		
	}

}
