package com.qa.tricentis.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.tricentis.pages.HomePage;
import com.qa.tricentis.pages.TestBase;



public class HomePageTest {
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public HomePage homePage;


	
	@BeforeTest
	public void setUp(){
		testBase = new TestBase();	
		prop = testBase.initProperty();
		driver = testBase.init(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		homePage =  new HomePage(driver);
		
	}
	


	
	@Test
	public void verifyCustomerServiceAndBlog(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, "Demo Web Shop");
		
		
		homePage.scrollToViewCustomerService();
		
		homePage.clickBlogLink();
		String currentURL =homePage.getRedirectedURL();
		System.out.println("New page currentURL is: "+ currentURL);
		Assert.assertEquals(currentURL, "https://demowebshop.tricentis.com/blog");
		String blogArchiveText =homePage.getBlogArchiveText();
		System.out.println("New page BlogArchiveText is: "+ blogArchiveText);	
		Assert.assertEquals(blogArchiveText, "BLOG ARCHIVE");
	}


	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
