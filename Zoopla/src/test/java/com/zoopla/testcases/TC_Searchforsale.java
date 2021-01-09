package com.zoopla.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoopla.pageobjects.AgentDetailsPage;
import com.zoopla.pageobjects.HomePage;
import com.zoopla.pageobjects.ListingsPage;
import com.zoopla.pageobjects.PropertyDetailsPage;

public class TC_Searchforsale extends BaseClass{
  @Test
  public void searchlocation() throws Exception {
	  
	  logger.info("URL is opened");
	  //driver.get(baseURL);
	  HomePage hp=new HomePage(driver);
	 
	  hp.entercity(search);
	  logger.info("Serach City is entered");
	  hp.acptcookies();
	  logger.info("Accept cookies is clicked");
	 
	  
	  ListingsPage lp=hp.searchplaces();
	  logger.info("Search button is clicked");
	  logger.info("In the Listings page");
	  lp.sortdesc();
	  logger.info("Highest price is selected");
	  lp.getalllistings();
	  logger.info("All the listings are listed");
	  PropertyDetailsPage pp=lp.pickingfifthlisting();
	  logger.info("The the fifth listing agent is selected");
	  String agentdetails_propertypage=pp.getAgentname();
	  AgentDetailsPage ap=pp.clickagentname();
	   
	  String agentdetails_agentpage=ap.Agentname();
	 
	  Assert.assertEquals(agentdetails_propertypage, agentdetails_agentpage);
	  
  }
}
