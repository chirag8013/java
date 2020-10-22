package com.moodys.meerqats.stepdefinitions;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.moodys.meerqats.utilities.utilities;

import  io.restassured.response.*;
import cucumber.api.java.en.*;


public class ORPStepDefinition {
	Response response;
	
	 Properties prop;
	 utilities util;
	
	
	@Given("^web service returns rating actions for RatingRelInfoORP between dates (\\d+) and (\\d+)$")
	public void web_service_returns_rating_actions_for_RatingRelInfoORP_between_dates_and(int startdate, int enddate) throws Throwable {
		prop = new Properties();

		InputStream is = getClass().getResourceAsStream("/Config.properties");
		util = new utilities();
		prop.load(is);
		String ENDPOINT_URL= prop.getProperty("ratingrelinfobaseurl");
	   response= given().auth().preemptive().basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when().get(ENDPOINT_URL+"ORP/"+startdate+"/"+enddate);
		
	}

	@When("^a user requests for rating release data for ORP by Dates$")
	public void a_user_requests_for_rating_release_data_for_ORP_by_Dates() throws Throwable {
	 System.out.println(response.prettyPrint());   
	 System.out.println("----------------------------------------------------------------");
	 System.out.println("SIZE OF RESPONSE ARRAY IS "+response.jsonPath().getList("").size());
	}
	
	@Then("^the status code for ORP is (\\d+)$")
	public void the_status_code_for_ORP_is(int StatusCODE) throws Throwable {
	  response.then().statusCode(StatusCODE);
	}
	

	@Then("^response for ORP includes the following$")
	public void response_for_ORP_includes_the_following(Map<String,String> expected) throws Throwable {
		for(Map.Entry<String, String> entry:expected.entrySet()){
			response.then().body(entry.getKey(), hasItem(entry.getValue()));
		}
	    
	}
	    
	    
	


}
