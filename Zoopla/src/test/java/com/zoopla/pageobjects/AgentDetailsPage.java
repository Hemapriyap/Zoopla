package com.zoopla.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AgentDetailsPage {
WebDriver ldriver;
	
	public AgentDetailsPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//h1[@class='bottom-half']//b[1]")
	WebElement Agentname;
	
	public String Agentname() throws Exception
	{
		String agntname=Agentname.getText();
		System.out.println("Agentname from agent details page "+agntname);
		return agntname;
		
	}
}
