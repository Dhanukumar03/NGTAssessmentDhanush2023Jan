package com.appTests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObjects.BagPage;
import com.PageObjects.HomePage;
import com.PageObjects.LoginPage;
//changes
public class Apptest2 {
	WebDriver driver;
	  HomePage home;
	  LoginPage login;
	  BagPage bag;
	  Properties property= new Properties();
	  
	  @BeforeMethod
	  public void setup() throws Exception, Exception {
		  System.out.println("Script started");
			String rootFolder = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", rootFolder + "//src//test//resources//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			home = new HomePage(driver);
			login = new LoginPage(driver);
			bag = new BagPage(driver);
			property.load(new FileInputStream(rootFolder+"//src//test//resources//Properties//bag.properties"));
			String Url = property.getProperty("appURL");
			Thread.sleep(2000);
			driver.manage().window().maximize();
			
	  }
	  @AfterMethod
	  public void teardown() {
		  driver.quit();
	  }
	  @Test
	  public void login() throws Exception {
		  String url = property.getProperty("appUrl");
		  String mailId=property.getProperty("mailId");
		  String passwd=property.getProperty("password");
		  home.launchBrowser(url);
		  login.Login(mailId, passwd);
		  
		  bag.check();
		  
			  bag.cart();
		  
	  
		  
		  WebElement count=driver.findElement(By.xpath("//span[@data-reactid=\"904\"]"));
	      String actualCount=count.getText();
	      Assert.assertEquals(actualCount, "1");

}}
