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
	public void clickOnSystemLink()
	{
		System.out.println("System menu ----");
		app.Click("link_System_xpath");
	}
	
	//click on systeminformation submenus
	public void clickONSubmenu()
	{
		System.out.println("systeinfo......");
		app.Click("link_SubMenuSystem_xpath");
	}
	
	
	public void verify_ServerInfo()
	{
		String TodaysDate= app.getTodaysDate();
		app.validateDateExists("Todays_servertime_xpath",TodaysDate);
			
	}
	
	
	
	

}
