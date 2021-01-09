package com.zoopla.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.zoopla.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	 ReadConfig readconfig=new ReadConfig();
		
		public String baseURL=readconfig.getApplicationURL();
		public String search=readconfig.getsearch();
		
		public static WebDriver driver;
		public static Logger logger;
		//@Parameters("browser")
		  @BeforeClass
	  //public void setup(String br) {
			  public void setup() {
			logger = Logger.getLogger("Zooplahomes");
			PropertyConfigurator.configure("Log4j.properties");
//			if(br.equals("chrome"))
//			{
//		  WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			}else if(br.equals("edge")) {
//			 WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseURL);
	  }
	  @AfterClass
	  public void teardown() {
		  driver.quit();
	  }
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}

}
