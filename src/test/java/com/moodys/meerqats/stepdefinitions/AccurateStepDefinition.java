package com.moodys.meerqats.stepdefinitions;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

import  io.restassured.response.*;
//import utilities.utilities;
import cucumber.api.java.en.*;


public class AccurateStepDefinition {
	Response response;
	
	 Properties prop;
	 //utilities util;
	
	String ENDPOINT_URL="http://ftc-lbdkrapp206.ad.moodys.net:1521/QATS/getRatingReleaseInfoAccurate/";
	
	
	@Given("^web service returns rating actions for RatingRelInfoAccurate between dates (\\d+) and (\\d+)$")
	public void web_service_returns_rating_actions_for_RatingRelInfoAccurate_between_dates_and(int startdate, int enddate) throws Throwable {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"D:\\Users/VermaC/Workspace1/MeerQATS_Cucumber_RestAssured/MeerQATS_Cucumber_RestAssured/Config.properties");
	//	util = new utilities();
		prop.load(ip);
	   response= given().auth().preemptive().basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when().get(ENDPOINT_URL+startdate+"/"+enddate);
		
	}

	@When("^a user requests for rating release data for Accurate by Dates$")
	public void a_user_requests_for_rating_release_data_for_Accurate_by_Dates() throws Throwable {
	 System.out.println(response.prettyPrint());   
	}

	@Then("^the status code is (\\d+)$")
	public void the_status_code_is(int StatusCODE) throws Throwable {
	  response.then().statusCode(StatusCODE);
	}

	@Then("^response includes the following$")
	public void response_includes_the_following(Map<String,String> expected) throws Throwable {
		for(Map.Entry<String, String> entry:expected.entrySet()){
			response.then().body(entry.getKey(), hasItem(entry.getValue()));
		
		}
	    
	}
	    
	    
	


}