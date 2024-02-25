package com.CucmberOneCommerce.Steps;


import com.Cucumber.oneCommercePages.CustomerPagejava;
import com.Cucumber.oneCommercePages.LoginPageJava;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	public TestContext context;
	public LoginPageJava loginpage;
	public CustomerPagejava customerpage;

	
	public Steps(TestContext context,LoginPageJava loginpage, CustomerPagejava customerpage)
	{
		 this.context=context;
		 this.loginpage=loginpage;
		 this.customerpage=customerpage;
		System.out.println("Steps Construtor");
	}
	//************************data values from files********************************
	//String URL=TestContext.getJsonValueForKey("Config", "URL");
	//String username=TestContext.getJsonValueForKey("Config", "username");
	//String password=TestContext.getJsonValueForKey("Config", "password");
	//String input_Username_xpath =TestContext.getJsonValueForKey("Locators", "input_Username_xpath");
	//String input_password_xpath =TestContext.getJsonValueForKey("Locators", "input_password_xpath");
//	String btn_LogIN_xpath=TestContext.getJsonValueForKey("Locators", "btn_LogIN_xpath");

	//************************************************************************************	
		

	
	@Given("User launch URL")
	public void user_launch_specified_browser() throws InterruptedException {	 
		System.out.println("***********launch url*******");
		loginpage.launch_url("URL");
		
	}


	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password() {
		loginpage.EnterUsername("input_Username_xpath");
		loginpage.EnterPassword("input_password_xpath");

	}

	@When("User click on Login")
	public void user_click_on_login() throws InterruptedException {
		loginpage.ClickLoginButton("btn_LogIN_xpath");
		Thread.sleep(9000);
	}
	
	@Then("User able to login successfully and verify home page title")
	public void User_able_to_login_successfully_and_verify_home_page_title() throws InterruptedException 
	{
		Thread.sleep(9000);
		loginpage.verifyPagetitle();
	}

	
	//Customer steps
	@When("User clicks on customer Menu")
	public void user_clicks_on_customer_menu() {
		System.out.println("***********customer menu*******");
	customerpage.ClickCustomerMenu("link_Customers_xpath");
		context.log("click on customer menu");
	}

	@When("Click on customer SubMenu Item")
	public void click_on_customer_submenu_item() {
		System.out.println("***********customer submenu*******");
		customerpage.ClickCustomerSubMenu("link_SubMenuCustomers_xpath");
		context.log("click on customer Submenu");

	}

	@When("Click on Add new customer")
	public void click_on_add_new_customer() {
		System.out.println("***********new cut menu*******");
		customerpage.clickAddCustomer("btn_Add_new_xpath");
		context.log("click on add newcustomer ");

	}

	@Then("User can see customer page")
	public void user_can_see_customer_page() {
		System.out.println("**************customer see pages fields");
		customerpage.CustomerInfoDisplayed();
		context.log("User see on customer details");

	}

	@When("User enter customer informaton")
	public void user_enter_customer_informaton() {
		System.out.println("*************************customer enters  fields");
		customerpage.EnterCustomerDetails();
		context.log("enters  customer info");

	}

	@When("User click on save button")
	public void user_click_on_save_button() {
		System.out.println("save button  fields");
		customerpage.clickSaveCustomerDeatils("btn_Savebtn_xpath");
		context.log("click on save ");
	}


	@Then("User can see confirmation message {string}")
	public void user_can_see_confirmation_message(String string) {
		System.out.println("save confirm msssg  fields");
		customerpage.Customer_Confirmation_message();
		context.log("confirm message displayed menu");
	}

	
	@Then("Close the browser")
	public void close_the_browser() {
		//loginpage.CloseTheBrowser();
		System.out.println("close the browser");
		context.driver.quit();
		context.log("close browser");


	}



}
