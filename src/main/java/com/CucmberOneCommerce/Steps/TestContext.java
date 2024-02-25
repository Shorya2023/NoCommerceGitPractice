package com.CucmberOneCommerce.Steps;


import static org.testng.Assert.fail;

//import static org.junit.Assert.fail;

//import static org.testng.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.databind.JsonNode;
//import com.aventstack.extentreports.util.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestContext {
	public static WebDriver driver;
	public String sBrowser_type;
	public  TestContext context;
    public static ExtentReports  report;
    public static ExtentTest test;
    public ExtentSparkReporter sparkreport;
    public SoftAssert softAssert;

	public String Report_path="C:\\Users\\91869\\LocalProjectRepo\\GITCucumberOneCommerce\\Execution_Reports";

	public TestContext()
	{		
		System.out.println("Constructor TestContext");
		
		System.out.println("level 1 updated from user 2");
		System.out.println("user 3 has been updated from git hub");
	}

	
	@Before
	public void initialize(Scenario scenario)
	{
		System.out.println("initialize Scenario----"+scenario.getName());
		CreateExtentReport(scenario.getName().toUpperCase());
		System.out.println("before method completed");
	}

	
	@After
	public void teardown(Scenario scenario)
	{
		//driver=null;
		System.out.println("tear down method");
		log("End of scenarios----"+scenario.getName().toString());
		report.flush();
	}
	
	
    public void CreateExtentReport(String ScenarioName)
    {
    	
    	System.out.println("result folder started.....");
    	Date d= new Date();
    	String spath= d.toString().substring(0);
		String arr[]=(spath.split(" "));
		String newPath=(arr[0]+"_"+arr[1]+"_"+arr[2]+"_"+arr[4]+"_"+arr[5]);
		System.out.println(newPath);
		String newReportPath=Report_path+"\\"+newPath;
		File file= new File(newReportPath);
		System.out.println("Results file created.......");
		if (!file.exists())
		{	
			file.mkdir();	
		}
		 report = new ExtentReports();
		 int CurrentTime=(int) System.currentTimeMillis();
		 sparkreport = new ExtentSparkReporter(file+"\\"+"-"+ScenarioName+"-"+CurrentTime+".html");
		 report.attachReporter(sparkreport);
		System.out.println("Spark html ereport started");
		//test= report.createTest("Envrinmont--->"+env+"/n"+"FeaureFile---"+Featurefile+"/n"+"-----"+"Current Scenarios******"+"/n"+currentScenario+"On browser--->"+getJsonValueForKey("Config","Browser"));
		test= report.createTest(ScenarioName);

    }
    
    private String getFeatureFileNameFromScenarioId(Scenario scenario) {
        String featureName = "Feature ";
        String rawFeatureName = scenario.getId();
       // featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
        return rawFeatureName;
    }


    
    public static String getJsonValueForKey(String key) {
        try {
        	           // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();    
			com.fasterxml.jackson.databind.JsonNode rootNode = objectMapper.readTree(new File(".//JsonFiles//Locators.Json"));
            
            // Get value for the specified key
            com.fasterxml.jackson.databind.JsonNode valueNode = rootNode.get(key);

            // Check if the key exists in the JSON
            if (valueNode != null) {
           	 System.out.println("return json value");
                return (valueNode.asText()).toString();
                
            } else 
            {
                return "no value exists";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading JSON file";
        }
    }

    
	private static String getFeatureFileNameFromScenarioId(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	//json method to return string array for the corresponding key in json file
    public static String[] getJsonArraysValuesForKey(String key)
    {
    	try {
    			ObjectMapper objectMapper = new ObjectMapper();
    			JsonNode jsonNode = objectMapper.readTree(new File(".//JsonFiles//Locators.Json"));

        if (jsonNode.has(key) && jsonNode.get(key).isArray()) {
            int size = jsonNode.get(key).size();
            String[] values = new String[size];
            for (int i = 0; i < size; i++) {
                values[i] = jsonNode.get(key).get(i).asText();
            }
            return values;
        			}
    			} catch (Exception e) {
        e.printStackTrace();
    						}
    		return null;
    }

    
    public void log(String msg)
    {
    	test.log(Status.INFO, msg); 	
    }

    public void Pass(String msg)
    {
    	test.log(Status.PASS, msg); 
    }
    
    
    public void Fail(String msg)
    {
    	test.log(Status.FAIL, msg);
		/*if(Stopexecution)
		{
				test.fail("not displayed");
		}*/
    }
    
    
    public void Fail_Stop_Execution(String msg, boolean Stopexecution)
    {
    	test.log(Status.FAIL, msg);
		if(Stopexecution)
		{
				test.fail("not displayed");
				softAssert.assertAll();
		}
    }
	
	


}
