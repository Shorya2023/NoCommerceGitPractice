package com.Cucumber.oneCommercePages;

import com.CucmberOneCommerce.Steps.TestContext;

public class PageManager {
	
	private LoginPageJava loginpage;
	//private HomePageJava homepage;
	private CustomerPagejava customerpage;
	private TestContext context;

	
	public PageManager(TestContext context)
	{
		this.context=context;		
	}

}
