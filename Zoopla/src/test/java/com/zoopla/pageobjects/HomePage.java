package com.zoopla.pageobjects;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class HomePage {
	
WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="search-input-location")
	WebElement txtsearchbox;
	
	@FindBy(xpath="//button[@class='ui-button-primary']")
	WebElement acpcookies;
	
	@FindBy(id="search-submit")
	WebElement btnsearch;
	
	
	public void entercity(String datatosearch) throws Exception
	{
		txtsearchbox.sendKeys(datatosearch);
		ldriver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		ldriver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		
	}
	
	public void acptcookies() throws Exception
	{
//		String parentHandle = ldriver.getWindowHandle();       
//        
//        Set<String> handles = ldriver.getWindowHandles();       
//
//        for (String handle1 : ldriver.getWindowHandles()) {               
//        	  ldriver.switchTo().window(handle1);
//        }       
//        
//        ldriver.switchTo().window(parentHandle);	
	
	}
	public ListingsPage searchplaces() throws Exception
	{
		
		btnsearch.click();	
		return new ListingsPage(ldriver);
			
	}
}
