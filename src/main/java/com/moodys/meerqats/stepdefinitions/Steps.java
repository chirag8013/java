package com.moodys.meerqats.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import  io.restassured.RestAssured;
import io.restassured.response.Response;

public class Steps {

 Response pyramidresp,accurateresp;
 
	@When("Restcall is made for RatingRelInfoPyrmaid")
	public void Restcall_is_made_for_RatingRelInfoPyrmaid() {

		pyramidresp = RestAssured.given().auth().preemptive().basic("s_dev_rqms01", "webbe6Hanrybly").when()
				.get("http://ftc-lbdkrapp206.ad.moodys.net:1521/QATS/getRatingReleaseInfoPyramid/20200514/20200515");

	}
	
	@When("Restcall is made for RatingRelInfoAccurate")
	public void Restcall_is_made_for_RatingRelInfoAccurate(){
		
		accurateresp = RestAssured.given().auth().preemptive().basic("s_dev_rqms01", "webbe6Hanrybly").when()
				.get("http://ftc-lbdkrapp206.ad.moodys.net:1521/QATS/getRatingReleaseInfoAccurate/20200514/20200515");
		
	}

	@Then("Validate StatusLine and StatusCode Pyramid")
	public void Validate_StatusLine_and_StatusCode_Pyramid() {
		
		System.out.println("----------------------------------------------");

		System.out.println(pyramidresp.getStatusLine());
		System.out.println(pyramidresp.getStatusCode());
		System.out.println(pyramidresp.getContentType());
		
		
		
		System.out.println("----------------------------------------------");
		
	}
	
	@Then("Validate StatusLine and StatusCode Accurate")
	public void Validate_StatusLine_and_StatusCode_Accurate() {
		
		System.out.println("----------------------------------------------");

		System.out.println(accurateresp.getStatusLine());
		System.out.println(accurateresp.getStatusCode());
		System.out.println(accurateresp.getContentType());
		
		
		
		System.out.println("----------------------------------------------");
		
	}
	
	@Then("Validate Body Pyramid")
	public void Validate_Body_Pyramid(){
		
		System.out.println(pyramidresp.jsonPath().getList("").size());
		System.out.println(pyramidresp.jsonPath().getList("ratingActionName").get(0));
		System.out.println(pyramidresp.jsonPath().getList("ratingActionName"));
		System.out.println(pyramidresp.jsonPath().getList("").get(0));
		System.out.println(pyramidresp.jsonPath().getList("").isEmpty());
		System.out.println(pyramidresp.getBody().jsonPath().prettify().toString());
		
		
	}
	
	@Then("Validate Body Accurate")
	public void Validate_Body_Accurate(){
		
		System.out.println(accurateresp.jsonPath().getList("").size());
		System.out.println(accurateresp.jsonPath().getList("ratingActionName").get(0));
		System.out.println(accurateresp.jsonPath().getList("").get(0));
		System.out.println(accurateresp.jsonPath().getList("").isEmpty());
		
		
	}

}
