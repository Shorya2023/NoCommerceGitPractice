package com.Cucumber.oneCommercePages;

import org.openqa.selenium.WebDriver;

import com.CucmberOneCommerce.Steps.TestContext;

import WebDriverManager.WebdriverManager;
import io.opentelemetry.context.Context;

public class LoginPageJava {

//*******************************************************	
public WebdriverManager app;
public TestContext context;

public LoginPageJava(WebdriverManager app)
{
	this.app=app;
	System.out.println("LoginPageJava Construtor");
}


	public void launch_url(String url) throws InterruptedException
	{
		app.Open_Browser();
		app.navigate_url(url);		
	}
	
	
	public void EnterUsername(String locator)
	{
		app.IsElementPresent(locator, 30);
		app.TypeInTextField(locator);
	}

	public void EnterPassword(String locator)
	{
		app.IsElementPresent(locator, 30);
		app.TypeInTextField(locator);
	}

	
	public void ClickLoginButton(String locator)
	{
		System.out.println(locator+"*********************to click");
	//	app.IsElementPresent(locator, 30);
		app.Click(locator);
		
	}

	
	public void CloseTheBrowser()
	{
		context.driver.quit();
	}

     
	public  void verifyPagetitle(String title)
	{
			//	app.WaitForElement(title, 0);
	/*	if( app.VerifyTitle(title))
		{
			context.log("title passed"+title);
		}
		else
		{
			//context.Fail("title not as Expected", false);
			context.Fail(title+"-------"+"not displayed");

		}*/
				if (app.IsElementPresent("Dashboard_Logo_Text_xpath",24))
				{
					context.Pass("Dashboard_Logo_Text_ Present");
				}
				else
				{
					context.Fail("Dashboard_Logo_Text_ not displayed");
				}
	}

}
	
	


