package com.datadriven.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class RegisterPage extends com.datadriven.utility.TestExecutor{
	
	
	public static String firstname = "//input[@placeholder='First Name']";
	public static By lastname = By.xpath("");
	public static By eemail = By.xpath("//input[@ng-model='EmailAdress']");
	public static By addr = By.tagName("textarea");
	public static By phoneeNum = By.xpath("//input[@ng-model='Phone']");
	
	
	
	public void enterFirstName() throws IOException
	{
		com.entervalue(By.xpath(firstname),getData("FirstName"),"FirstName");
	}
	
	public void enterLastName() throws IOException
	{
	 com.entervalue(lastname,getData("LastName"),"LastName" ); 
	}
	
	public void enterAddress() throws IOException
	{
		com.entervalue(addr,getData("Address"), "Address");
	}
	
	public void enterEmail() throws IOException
	{
		com.entervalue(eemail, getData("EmailAddress"),"Email");
	}
	
	public void enterPhone() throws IOException
	{
		com.entervalue(phoneeNum, getData("PhoneNumber"),"PhoneNumber");
	}
	
	public void verifyPageTitle() throws IOException
	{
		
		com.verifyPageTitle(getData("PageTitle"));
		 
	}

}
