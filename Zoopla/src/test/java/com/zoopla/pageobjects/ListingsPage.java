package com.zoopla.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ListingsPage {
WebDriver ldriver;
	
	public ListingsPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="sort-order-dropdown")
	WebElement seldescending;
	
	@FindBy(xpath="//div[@class='css-8jz4jb-SearchResultsLayoutGroup es0c9wm2']//div[@class='css-1e28vvi-PriceContainer e2uk8e8']")
	List<WebElement> getalllistings;
	
	@FindBy(xpath="//div[@class='css-kdnpqc-ListingsContainer earci3d2']//div[5]")
	WebElement fifthlisting;
	
	
	public void sortdesc() throws Exception
	{
		Select sort=new Select(seldescending);
		sort.selectByVisibleText("Highest price");
		Thread.sleep(2000);
		
	}
	
	public void getalllistings() throws Exception
	{
		System.out.println("All the listings of the page are"+getalllistings.size());
		
		for (int i=0;i<getalllistings.size();i++) {
			System.out.println("The Property price in descending are "+ getalllistings.get(i).getText());
		}
		
	}
	public PropertyDetailsPage pickingfifthlisting() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", fifthlisting);
		fifthlisting.click();
		return new PropertyDetailsPage(ldriver);
	}
}
