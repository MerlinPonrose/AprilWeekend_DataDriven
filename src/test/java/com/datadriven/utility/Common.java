package com.datadriven.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;



public class Common extends com.datadriven.utility.TestExecutor{
	
	
	public void clickElement(By loc)
	{
		
			WebElement ele = driver.findElement(loc);
			ele.click();
			
		
	}
	
	public void entervalue(By loc,String value,String field) throws IOException
	{
		try
		{
			WebElement ele = driver.findElement(loc);
			ele.click();
			ele.clear();
			ele.sendKeys(value);
			test.log(Status.PASS,  "Value entered successfully in"+field+ " "+"field");
		}
		catch(Exception e)
		{
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			
			File src  = takescreenshot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, new File("C:\\neworkspace\\DataDriven\\screenshots\\error.png"));
			
			test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath("C:\\\\neworkspace\\\\DataDriven\\\\screenshots\\\\error.png"));

			
						
			test.log(Status.FAIL, "Value not entered successfully in"+field+" "+ "field");

			//test.log(Status.FAIL, "Value not entered successfully in"+field+" "+ "field");
		}
	}
	
	public void verifyPageTitle(String ExpectedTitle)
	{
		String currentTitle = 	driver.getTitle();
		if(currentTitle.equalsIgnoreCase(ExpectedTitle))
		{
			System.out.println("Page title is as expected");
		}
		else
		{
			System.out.println("Page title is not as expected");
		}
	}
	
	public void ClickOkInAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void clickCancelInAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

}
