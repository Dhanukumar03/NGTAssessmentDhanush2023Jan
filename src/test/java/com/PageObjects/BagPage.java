package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BagPage {
  WebDriver driver;
  
  
  public BagPage(WebDriver driver) {
	  this.driver=driver;
  }
  
  public void check() throws InterruptedException {
	  driver.findElement(By.xpath("//span[.='Bag']")).click();
	  Thread.sleep(5000);
	  String noItem=driver.findElement(By.xpath("//div[contains(text(),'Hey, it feels so light!')]")).getText();
	  
  }
  
  public void cart() throws InterruptedException
  {
	  driver.findElement(By.xpath("//div[contains(text(),'ADD ITEMS FROM WISHLIST')]")).click();
	  driver.findElement(By.xpath("//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo']")).click();
	  driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Armani");
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")).click();
		driver.findElement(By.xpath("//img[@title='Armani Exchange Men Black Analogue Watch']")).click();
		String currentHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
		    if (!handle.equalsIgnoreCase(currentHandle)) {
		        driver.switchTo().window(handle);
		    }
		}

		 

		Thread.sleep(2000);
		//WebElement addToBagButton= driver.findElement(By.cssSelector("div.pdp-add-to-bag"));
		WebElement addToBagButton= driver.findElement(By.cssSelector("div.pdp-add-to-bag"));
		addToBagButton.click();
		Thread.sleep(2000);
		
	  
  }

	
}
