package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPage {
  WebDriver driver;
  
  public ProductsPage(WebDriver driver) {
	  this.driver=driver;
  }
  
  public String verifyPageTitle(String expectedPageTitle) {
	  String actualPageTitle=driver.getTitle();
	  return actualPageTitle;
	  
	  
  }
}
