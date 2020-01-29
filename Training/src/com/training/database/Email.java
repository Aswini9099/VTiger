package com.training.database;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Email {
	
		static
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			
		}
		
		
		public static void main(String[] args) throws InterruptedException
		
		{
			WebDriver driver =  new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://accounts.google.com/");
			WebElement un = driver.findElement(By.xpath("//input[@type='email']"));
	      	un.sendKeys("swathisatyappa@gmail.com");
	      	
	      	WebDriverWait wait=new WebDriverWait(driver,10);
	      	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	      	driver.findElement(By.xpath("//span[text()='Next']")).click();
	      	
	      	WebElement pd = driver.findElement(By.name("password"));
	      	pd.sendKeys("96324952");
	      	
	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	      
	      driver.findElement(By.xpath("//span[text()='Next']")).click();
	      Thread.sleep(1000);
	      
	     List<WebElement> ele = driver.findElements(By.xpath("//table[@class='F cf zt']/tbody/tr[*]/td[6]/div"));
	   for(WebElement el : ele)
		   
	   {
		   el.click();
		   String s=el.getText();
		   System.out.println("-------------");
		   if(s.equals("Facebook"))
		   {
			   System.out.println(s);
		   }
			   else
				   System.out.println("Facebook mess is not available");
			   
		   }
	   }
			
					
	}


