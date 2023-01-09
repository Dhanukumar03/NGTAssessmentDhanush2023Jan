package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void launchBrowser(String Url) {
		driver.get(Url);
		
		
	}
	
	public void searchProduct(String Product) {
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys(Product);
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")).click();
		
	}
	
}
