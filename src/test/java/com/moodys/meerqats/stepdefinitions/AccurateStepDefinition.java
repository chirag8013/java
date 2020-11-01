package com.moodys.meerqats.stepdefinitions;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.testng.Assert;

import com.moodys.meerqats.utilities.utilities;

import  io.restassured.response.*;
import cucumber.api.java.en.*;


public class AccurateStepDefinition {
	Response openshiftresponse,dockerresponse;
	Response response;
	int dockerfieldlistsize,openshiftfieldlistsize;
	int Responsearraysize,dockerResponsearraysize,openshiftResponsearraysize;
	 Properties prop;
	utilities util;
	Set<String> dockerfieldlist,openshiftfieldlist;
	
	@Given("^web service returns rating actions for RatingRelInfoAccurate between dates (\\d+) and (\\d+)$")
	public void web_service_returns_rating_actions_for_RatingRelInfoAccurate_between_dates_and(int startdate, int enddate) throws Throwable {
		prop = new Properties();

		InputStream is = getClass().getResourceAsStream("/Config.properties");
		util = new utilities();
		prop.load(is);
		String ENDPOINT_URL= prop.getProperty("ratingrelinfobaseurl");
	   response= given().auth().preemptive().basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when().get(ENDPOINT_URL+"Accurate/"+startdate+"/"+enddate);
		
	}

	@When("^a user requests for rating release data for Accurate by Dates$")
	public void a_user_requests_for_rating_release_data_for_Accurate_by_Dates() throws Throwable {

	 System.out.println(response.prettyPrint());
		List<String> addendum= response.jsonPath().getList("addendumEmail");
		Set<String> uniqueaddendum = new HashSet<String>(addendum);
		for(String addend:uniqueaddendum){
			System.out.println(addend);
		}
	 System.out.println("----------------------------------------------------------------");
      Responsearraysize = response.jsonPath().getList("").size();
	 System.out.println("SIZE OF RESPONSE ARRAY IS "+ Responsearraysize);
	}
	

@Given("^web service returns rating actions for RatingRelInfoAccurate between dates (\\d+) and (\\d+) for Openshift$")
public void web_service_returns_rating_actions_for_RatingRelInfoAccurate_between_dates_and_for_Openshift(int startdate, int enddate) throws Throwable {
	prop = new Properties();

	InputStream is = getClass().getResourceAsStream("/Config.properties");
	util = new utilities();
	prop.load(is);
	String ENDPOINT_URL= prop.getProperty("ratingrelinfobaseurlopenshift");
   openshiftresponse= given().auth().preemptive().basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when().get(ENDPOINT_URL+"Accurate/"+startdate+"/"+enddate);
}

@Given("^web service returns rating actions for RatingRelInfoAccurate between dates (\\d+) and (\\d+) for Docker$")
public void web_service_returns_rating_actions_for_RatingRelInfoAccurate_between_dates_and_for_Docker(int startdate, int enddate) throws Throwable {
	prop = new Properties();

	InputStream is = getClass().getResourceAsStream("/Config.properties");
	util = new utilities();
	prop.load(is);
	String ENDPOINT_URL= prop.getProperty("ratingrelinfobaseurldocker");
   dockerresponse= given().auth().preemptive().basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when().get(ENDPOINT_URL+"Accurate/"+startdate+"/"+enddate);
}

@When("^a user requests for rating release data for Accurate by Dates for Openshift and fetch \"([^\"]*)\"$")
public void a_user_requests_for_rating_release_data_for_Accurate_by_Dates_for_Openshift_and_fetch(String field) throws Throwable {
	//System.out.println(openshiftresponse.prettyPrint());
		List<String> Openshiftfield1= openshiftresponse.jsonPath().getList(field);
		openshiftfieldlist = new HashSet<String>(Openshiftfield1);
		 openshiftfieldlistsize= openshiftfieldlist.size();
		for(String Openshiftfield:openshiftfieldlist
				){
			System.out.println(field+" from Openshift---- "+Openshiftfield);
		}
		 System.out.println("----------------------------------------------------------------");
	     openshiftResponsearraysize = openshiftresponse.jsonPath().getList("").size();
		 System.out.println("SIZE OF RESPONSE ARRAY FROM OPENSHIFT IS "+ openshiftResponsearraysize);
}

@When("^a user requests for rating release data for Accurate by Dates for Docker and fetch \"([^\"]*)\"$")
public void a_user_requests_for_rating_release_data_for_Accurate_by_Dates_for_Docker_and_fetch(String field) throws Throwable {
	 //System.out.println(dockerresponse.prettyPrint());
	List<String> Dockerfield1= dockerresponse.jsonPath().getList(field);
	 dockerfieldlist = new HashSet<String>(Dockerfield1);
	dockerfieldlistsize= dockerfieldlist.size();
	for(String Dockerfield:dockerfieldlist){
		System.out.println(field+" from Docker---- "+Dockerfield);
	}
	 System.out.println("----------------------------------------------------------------");
      dockerResponsearraysize = dockerresponse.jsonPath().getList("").size();
	 System.out.println("SIZE OF RESPONSE ARRAY FROM DOCKER IS "+ dockerResponsearraysize);
}





@Then("^validate the Accurate response from Openshift and docker$")
public void validate_the_Accurate_response_from_Openshift_and_docker() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
     try {
		Assert.assertEquals(dockerResponsearraysize, openshiftResponsearraysize);
		Assert.assertEquals(openshiftfieldlistsize, dockerfieldlistsize);
		Assert.assertTrue(openshiftfieldlist.containsAll(dockerfieldlist));
		System.out.println("Openshift and Docker response matched and response array size is "+ openshiftResponsearraysize );
	} catch (Exception e) {
		// TODO Auto-generated catch block
	System.out.println("Openshift and Docker response not mateched");
	}
    	 
    	 
    
}

	@Then("^the status code for Accurate is (\\d+)$")
	public void the_status_code_for_Accurate_is(int StatusCODE) throws Throwable {
	  response.then().statusCode(StatusCODE);
	}

	@Then("^response for Accurate includes the following$")
	public void response_for_Accurate_includes_the_following(Map<String,String> expected) throws Throwable {
		for(Map.Entry<String, String> entry:expected.entrySet()){
			response.then().body(entry.getKey(), hasItem(entry.getValue()));
		
		}
	    
	}
	    
	    
	


}
