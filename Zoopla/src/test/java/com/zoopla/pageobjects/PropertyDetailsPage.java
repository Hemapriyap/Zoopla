package com.zoopla.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PropertyDetailsPage {
WebDriver ldriver;
	
	public PropertyDetailsPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//h4[@class='ui-agent__name']")
	WebElement Agentdetails;
	public String getAgentname() throws Exception
	{
		String getagntname=Agentdetails.getText();
		System.out.println("Agentname from agent details page "+getagntname);
		return getagntname;
		
	}
	public AgentDetailsPage clickagentname() throws Exception
	{
		Agentdetails.click();
		return new AgentDetailsPage(ldriver);
		
	}
}
