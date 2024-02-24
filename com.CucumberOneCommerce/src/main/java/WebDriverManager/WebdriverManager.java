package WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CucmberOneCommerce.Steps.TestContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebdriverManager {
	//private HomePageJava homepage;
	public  TestContext context;
	public  WebdriverManager app;

	
	public WebdriverManager(TestContext context)
	{
		this.context=context;
		System.out.println("WEebdriver Construtor");
	}
	
	
public void Open_Browser(){	
  	    System.out.println("in open broswer");

		String sBrowser_type= TestContext.getJsonValueForKey("Browser");
		//String sBrowser_type= System.getProperty("Browser");
	   if (context.driver==null)
	   {
			System.out.println(sBrowser_type+"-------------------------Openeing up");
			if (sBrowser_type.equals("edge"))
			{
				System.out.println("opening edge.........");	
				context.driver = new EdgeDriver();				
			}else if(sBrowser_type.equals("chrome"))
			{	System.out.println("open chrome.........");	
					context.driver = new ChromeDriver();
			}	else if(sBrowser_type.equals("firefox"))
			{
					System.out.println("open firefox.........");	
					context.driver = new FirefoxDriver();
			}
	   }	
}
	
	
	public void navigate_url(String value) throws InterruptedException
	{
		context.driver.get(TestContext.getJsonValueForKey(value));
		context.driver.manage().window().maximize();
		context.log(value+"____________opened successfully.........");
		Thread.sleep(5000);
	}
	
	
	public void Click(String locator)
	{	
		System.out.println(locator+"****************inside click");
		FindWebElement(locator).click();
		/*String xpathOfLocator= (TestContext.getJsonValueForKey(locator)).trim();
		System.out.println("xpath from json locator---"+xpathOfLocator);

		context.driver.findElement(By.xpath(xpathOfLocator)).click();*/
		context.log(locator+"______________Clicked successfully.........");		
	}

	
	//Json value fetching from .json files under C:\Users\91869\eclipse-workspace\com.CucumberZoho\Json
	public void type(String value,String locator)
	{
		System.out.println("type*******"+value+" in input box");
		FindWebElement(locator).clear();
		FindWebElement(locator).sendKeys(TestContext.getJsonValueForKey(value));
		context.log(locator+"______Value set on"+locator+ "______________text filed.........");

	}
	
	//type in input text field
	//pass locatorkey defined in locators jsonn file 
	public void TypeInTextField(String locatorkey)
	{
		System.out.println("IN"+locatorkey+" input box");
		String values[]=TestContext.getJsonArraysValuesForKey(locatorkey);
		FindWebElement(locatorkey).clear();
		FindWebElement(locatorkey).sendKeys(values[1].trim());
		context.log(locatorkey+"______Value set on"+values[1]+ "______________text filed.........");
	}
	
	
	//javascriptexecuter to check page is loaded or not
	
	
	
	
	
	
  // webdriver wait for specific elements   
    public void WaitForElement(String Locatorvalue,int timeinSeconds)
    {
    	
		 WebDriverWait wait = new WebDriverWait(context.driver,Duration.ofSeconds(timeinSeconds));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(Locatorvalue));
    }

    
   //find webelemet via getlocator function 
    public WebElement FindWebElement(String Locatorvalue)
    {
    	WebElement e=null;
    	By sLocator =getLocator(Locatorvalue);
    	try {
    		System.out.println("loactor element found");
    		  e=context.driver.findElement(sLocator);
		 	}
    	catch(Exception ex)
    		{
    		context.Fail("Element not found");
    		System.out.println("not found");
    		}
		return e;
    }
    
    
  //  
    public By getLocator(String Locator)
    {
    	if (Locator.endsWith("_xpath")){
    		String values[]=TestContext.getJsonArraysValuesForKey(Locator);
    	  	System.out.println("xpath inside getlocator------>>"+values[0]);
    		return By.xpath(values[0]);
    	}else if(Locator.endsWith("_className"))
    	{
    		String values1[]=TestContext.getJsonArraysValuesForKey(Locator);
    	  	return By.className(values1[0]);
    	}
    	else if(Locator.endsWith("_id"))
    	{
    		String values_id[]=TestContext.getJsonArraysValuesForKey(Locator);
    	  	System.out.println("id inside getlocator------>>"+values_id[0]);
    	  	return By.id(values_id[0]);
    	}
    	else if(Locator.endsWith("_name"))
    	{
    		String values2[]=TestContext.getJsonArraysValuesForKey(Locator);
    	  	System.out.println("name inside getlocator------>>"+values2[0]);
    	  	return By.name(values2[0]);

    	}else if(Locator.endsWith("_linkText"))
    	{     String values3[]=TestContext.getJsonArraysValuesForKey(Locator); 	  
    		return By.linkText(values3[0]);
  		
    	}else if(Locator.endsWith("_tagName"))
    	{
    		String values4[]=TestContext.getJsonArraysValuesForKey(Locator);
	    	  	return By.tagName(values4[0]);

    	}else if(Locator.endsWith("_partialLinkText"))
    	{
    		String values5[]=TestContext.getJsonArraysValuesForKey(Locator);
    	  	return By.partialLinkText(values5[0]);

    	}
    	System.out.println("incorrect locator by missing ");
		return null;
    	
    }

   
    //Pass the left side menu item to click on it
   public void ClickSideMenuItem(String MenuItem)
      {
	   
    	  String xpath_sidemenu="//a[@href='#']//p[contains(text(),'"+MenuItem+"')]";
    	//  WebElement e=null;
    	  Click(xpath_sidemenu);
      }     
      
   
   
   //Pass the left side sub menu item and submenu index number to click on it 
   public void ClickSubMenuItem(String MenuItem, int subMenuItem)
   {
 	  String xpath_submenu="//a[@href='#']//p[contains(text(),'"+MenuItem+"')]//following::p["+subMenuItem+"]";
 	 // WebElement e=null;
 	  Click(xpath_submenu);
   }     
     
 //*************************VAlidation Functions****************************************
    public boolean VerifyTitle(String Expectedtitle)
    {
    	String Actualtitle=context.driver.getTitle();
    	System.out.println(Actualtitle);
    	System.out.println(Expectedtitle);

    	if(Actualtitle.contentEquals(Expectedtitle))
    	{   context.log(Actualtitle+"--------"+"displayed");
    		return true;
    	}
    	else {
    		context.log(Actualtitle+"--------"+"Not displayed");
    		return false;
    	}   	
    }
    
    
   //validating element is present or not 
    public boolean IsElementPresent(String locator, int DurationinSeconds)
    {
    	WebElement e= null;
    	By Locator = getLocator(locator);  	
        WebDriverWait wait = new WebDriverWait(context.driver,Duration.ofSeconds(DurationinSeconds));
    	 e=wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
    	 if (e.isEnabled())
    	 {	
    		 context.log(locator+"________"+"is present and enabled");
    		 return true;
    	 }
    	 else 
    	 {
    		 context.Fail(locator+"________"+"not present");;
    		 return false;
    	 }
    	
    }
    
    
    
    
    
    
    
}
