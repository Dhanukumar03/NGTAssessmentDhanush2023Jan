package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPage {
  WebDriver driver;
  
  public ProductsPage(WebDriver driver) {
	  this.driver=driver;
  }
  
  public void verifyPageTitle(String expectedPageTitle) {
	  String actualPageTitle=driver.getTitle();
	  Assert.assertEquals(actualPageTitle, expectedPageTitle,"No product found");
	  System.out.println("Products found ");
  }
}
