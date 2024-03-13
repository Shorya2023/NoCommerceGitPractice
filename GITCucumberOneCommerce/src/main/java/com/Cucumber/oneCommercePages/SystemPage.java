package com.Cucumber.oneCommercePages;

import com.CucmberOneCommerce.Steps.TestContext;

import WebDriverManager.WebdriverManager;

public class SystemPage {
	
	public WebdriverManager app;
	public TestContext context;
	public SystemPage(WebdriverManager app)
	{
		this.app=app;
		System.out.println("SystemPage Construtor");
	}


	//click on system 	
	public void clickOnSystemLink(String locator)
	{
		System.out.println("customer menu ----"+locator);
		app.Click(locator);
	}
	
	//click on systeminformation submenus
	public void clickONSubmenu(String locator)
	{
		System.out.println("systeinfo......"+ locator);
		app.Click(locator);
	}
	
	public verify_Todaysdate(string locator)
	
	{
		
		app.validate
	}
	
	
	
	

}
