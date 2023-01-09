package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Login(String mailId,String passwd) throws InterruptedException {
		driver.findElement(By.id("mobileNumberPass")).sendKeys(mailId);;
		driver.findElement(By.xpath("//input[@class='form-control has-feedback']")).sendKeys(passwd);
		driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
	}

}
