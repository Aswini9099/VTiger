package com.training.generic;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWUtills {
	
	public static int ranDomNum()
	{
		Random ran=new Random();
		
		return ran.nextInt(1000);
		
	}
	
	public void waitForElementToClick(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	
	public void waitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public void waitForElementTitle(WebDriver driver, String exptitle )
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(exptitle));	
	}
	public void  waitForElementAndClick(WebDriver driver, WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<20)
			try
			{
			element.click();
			break;
			}
		catch(Throwable e)
		{
			Thread.sleep(1000);
			count++;
		}
		
	}
	
	public void select( WebElement  element,String option )
	{
		Select s=new Select(element );
		s.selectByVisibleText(option);
		
	}
	public void select ( WebElement  element,int index )
	{
		Select s=new Select(element );
		s.selectByIndex(index);
		
	}
	public void selectByValue( WebElement  element,String Value )
	{
		Select s=new Select(element );
		s.selectByValue(Value);
		
	}
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
				
	}
	public void contextClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	public void TakesScreenshot(WebDriver driver,String path)
	{
		try
		{
			TakesScreenshot ts= (TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des= new File(path);
		FileUtils.copyFile(src,des);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	static  String parentWinId;
	static String  childWinId;
	
	public void getChildWindow(WebDriver driver)
	{
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		 parentWinId= it.next();
		 childWinId= it.next();
		
		driver.switchTo().window(childWinId);
	}
	
	public void getParentWindow(WebDriver driver)
	{
		
		
		driver.switchTo().window(parentWinId);
	}
	
	public static String read_XL_Data(String path,String sheet,int row,int cell) throws EncryptedDocumentException, FileNotFoundException, IOException 
	{
		String data="";
		
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		data=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		
		
		return data;
	}
	
	/**
	 * This method is used to read the number of DATA rows/RowCount
	 * @param path
	 * @param sheet
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 */
	
	public static int read_XL_RowCount(String path,String sheet) throws EncryptedDocumentException, FileNotFoundException, IOException 
	{
		int rc=0;
		
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		rc=wb.getSheet(sheet).getLastRowNum();
		
		return rc;
	}
	
	/**
	 * This method is used to write the  DATA into excel
	 * @param path
	 * @param sheet
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 */
	
	public static int  write_XL_Data(String path,String sheet,int row,int cell,int v) throws EncryptedDocumentException, FileNotFoundException, IOException 
	{
		
		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(v);
		wb.write(new FileOutputStream(path));
		return v;
	}
	
	
	
	
	
	
	

}
