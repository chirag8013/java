package com.moodys.meerqats.stepdefinitions;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.moodys.meerqats.utilities.utilities;

import  io.restassured.response.*;
//import utilities.utilities;
import cucumber.api.java.en.*;


public class PyramidStepDefinition {
	Response response;
	
	 Properties prop;
	 utilities util;
		
	@Given("^web service returns rating actions for RatingRelInfoPyramid between dates (\\d+) and (\\d+)$")
	public void web_service_returns_rating_actions_for_RatingRelInfoPyramid_between_dates_and(int startdate, int enddate) throws Throwable {
		prop = new Properties();

		InputStream is = getClass().getResourceAsStream("/Config.properties");
		String ENDPOINT_URL= prop.getProperty("ratingrelinfobaseurl");
		util = new utilities();
		prop.load(is);
	   response= given().auth().preemptive().basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when().get(ENDPOINT_URL+startdate+"/"+enddate);
		
	}

	@When("^a user requests for rating release data for Pyramid by Dates$")
	public void a_user_requests_for_rating_release_data_for_Pyramid_by_Dates() throws Throwable {
	 System.out.println(response.prettyPrint());   
	}
	
	@Then("^the status code for Pyramid is (\\d+)$")
	public void the_status_code_for_Pyramid_is(int StatusCODE) throws Throwable {
	  response.then().statusCode(StatusCODE);
	}
	

	@Then("^response for Pyramid includes the following$")
	public void response_for_Pyramid_includes_the_following(Map<String,String> expected) throws Throwable {
		for(Map.Entry<String, String> entry:expected.entrySet()){
			response.then().body(entry.getKey(), hasItem(entry.getValue()));
		
		}
	    
	}
	    
	    
	


}
