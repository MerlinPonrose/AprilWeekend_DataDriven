package com.datadriven.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.datadriven.utility.TestExecutor;

public class Registration extends TestExecutor{
	
	@Test
	public void validateTextField() throws IOException
	{
		test = report.createTest("Text Field Validation");
		/*test.log(Status.PASS, "Test case passed");
        test.log(Status.FAIL, "Test Case fail");
        test.log(Status.INFO, "test case information");
		*/
		try
		{
			reg.enterFirstName();
			reg.enterLastName();
			reg.enterAddress();
			reg.enterEmail();
			reg.enterPhone();
			reg.verifyPageTitle();
			test.log(Status.PASS, "Test case passed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Test case failed");
		}
	}
	
	
	/*@Test
	public void validateFirstName() throws IOException
	{
		test = report.createTest("Validate FirstName");
		reg.enterFirstName();
	}*/
}
