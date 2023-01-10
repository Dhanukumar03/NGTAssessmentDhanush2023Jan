package com.appTests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;
import com.PageObjects.ProductsPage;


public class AppTests {
  WebDriver driver;
  HomePage home;
  ProductsPage product;
  Properties property = new Properties();
  
  @BeforeMethod
  public void setup() throws Exception {
	  System.out.println("Script started");
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootFolder + "//src//test//resources//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		home = new HomePage(driver);
		product = new ProductsPage(driver);
		
		property.load(new FileInputStream(rootFolder+"//src//test//resources//Properties//launch.properties"));
		String Url = property.getProperty("appURL");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
  }
  
  @Test
  public void verifySearchResult() {
	  String Url = property.getProperty("appURL");
	  String pageTitle = property.getProperty("pageTitle");
	  String productName = property.getProperty("appProduct");
	  home.launchBrowser(Url);
	  home.searchProduct(productName);
	  String pgTitle=product.verifyPageTitle(pageTitle);
	  Assert.assertEquals(pgTitle, pageTitle,"No product found");
  }
  
  @AfterMethod
  public void teardown() {
	  driver.quit();
  }
  
  
  
  
}
