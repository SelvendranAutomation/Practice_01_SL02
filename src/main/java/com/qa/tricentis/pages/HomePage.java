package com.qa.tricentis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;



public class HomePage extends TestBase{
	
	private ElementUtil elementUtil;
	
	private By customerService_xpath = By.xpath( "//h3[text()='Customer service']");
	private By blogCustomerService_link = By.linkText( "Blog");
	private By blogArchiveCustomerService_css = By.cssSelector( "div[class*='archive']>div:nth-of-type(1)");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getRedirectedURL(){
		elementUtil = new ElementUtil(driver);
		elementUtil.waitForElementPresent(blogArchiveCustomerService_css, 30);
		return driver.getCurrentUrl();
	}
	
	public String getBlogArchiveText(){
		elementUtil = new ElementUtil(driver);
		elementUtil.getScreenshot();
		
		return driver.findElement(blogArchiveCustomerService_css).getText();
	}
	




	
	public void clickBlogLink(){
		
		driver.findElement(blogCustomerService_link).click();
	}
	



	
	public void scrollToViewCustomerService(){
		 
 		JavascriptExecutor js = ((JavascriptExecutor) driver);
 		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(customerService_xpath));
	
	}
	
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
}
