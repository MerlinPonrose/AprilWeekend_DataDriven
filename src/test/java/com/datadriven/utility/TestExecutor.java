package com.datadriven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.datadriven.pages.RegisterPage;

public class TestExecutor {
	
	public static WebDriver driver;
	public static Common com = new Common();
	public static RegisterPage reg = new RegisterPage();
	public static HashMap<String,String> map = new HashMap();
	public static DataFormatter formatter = new DataFormatter();
	
	public static ExcelRead excel = new ExcelRead();
	
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	
	@BeforeTest
	public void createReport()
	{
		reporter = new ExtentHtmlReporter("C:\\neworkspace\\DataDriven\\Reports\\extentreport.html");
		report = new ExtentReports();
		report.attachReporter(reporter);
	}
	
	
	@BeforeMethod
	public void launchbrowser() throws IOException
	{
		
		File f = new File("C:\\neworkspace\\DataDriven\\src\\test\\java\\com\\datadriven\\config\\environmentdetails.properties");
		FileInputStream fis = new FileInputStream(f);
		
		Properties prop = new Properties();
		prop.load(fis);
		
	String url = 	prop.getProperty("URL");
	
	String Browser = prop.getProperty("browser");
	
	if(Browser.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\neworkspace\\DataDriven\\exe\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
	}
	else if(Browser.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\neworkspace\\DataDriven\\exe\\chromedriver.exe");
		
		driver = new FirefoxDriver();
	}
		
			driver.manage().window().maximize();
			
		
			
			
			
			driver.get(url); // to open URL
			
		}
	
	
	public String getData(String key) throws IOException
	{
		return excel.getMapValue(key);
	}
	
	@AfterMethod
	public void endreport()
	{
		report.flush();
	}

}

