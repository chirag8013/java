package com.moodys.meerqats.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.utilities;

public class Steps {

	Response pyramidresp, accurateresp, orpresp, ratingreldetailsresp;
	Properties prop;
	utilities util;

	@When("Basic Setup")
	public void Basic_Setup() throws IOException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"D:\\Users/VermaC/Workspace1/MeerQATS_Cucumber_RestAssured/Config.properties");
		util = new utilities();
		prop.load(ip);

	}

	@When("^Restcall is made for RatingRelInfoORP from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void restcall_is_made_for_RatingRelInfoORP_from_to(String startdate, String enddate) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		orpresp = RestAssured.given().auth().preemptive()
				.basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when()
				.get(prop.getProperty("ratingrelinfobaseurl") + "ORP/" + startdate + "/" + enddate);
	}

	@When("^Restcall is made for RatingRelInfoPyramid from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void restcall_is_made_for_RatingRelInfoPyramid_from_to(String startdate, String enddate) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		pyramidresp = RestAssured.given().auth().preemptive()
				.basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when()
				.get(prop.getProperty("ratingrelinfobaseurl") + "Pyramid/" + startdate + "/" + enddate);
	}

	@When("^Restcall is made for RatingRelInfoAccurate from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void restcall_is_made_for_RatingRelInfoAccurate_from_to(String startdate, String enddate) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		accurateresp = RestAssured.given().auth().preemptive()
				.basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when()
				.get(prop.getProperty("ratingrelinfobaseurl") + "Accurate/" + startdate + "/" + enddate);
	}

	@When("Rest Get Call is made for the mentioned date")
	public void Rest_Get_Call_is_made_for_the_mentioned_date() {

		ratingreldetailsresp = RestAssured.given().auth().preemptive()
				.basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when()
				.get(prop.getProperty("ratingrelsummarybaseurl") + "/20200505/20200506");

	}

	@Then("Validate Status Line and Status Code for rating release")
	public void Validate_Status_Line_and_Status_Code_for_rating_release() {

		System.out.println("----------------------------------------------");

		System.out.println(ratingreldetailsresp.getStatusLine());
		System.out.println(ratingreldetailsresp.getStatusCode());
		System.out.println(ratingreldetailsresp.getContentType());

		System.out.println("----------------------------------------------");

	}

	@Then("Validate StatusLine and StatusCode for Pyramid")
	public void Validate_StatusLine_and_StatusCode_for_Pyramid() {

		System.out.println("----------------------------------------------");

		System.out.println(pyramidresp.getStatusLine());
		System.out.println(pyramidresp.getStatusCode());
		System.out.println(pyramidresp.getContentType());

		System.out.println("----------------------------------------------");

	}

	@Then("Validate StatusLine and StatusCode for ORP")
	public void Validate_StatusLine_and_StatusCode_for_ORP() {

		System.out.println("----------------------------------------------");

		System.out.println(orpresp.getStatusLine());
		System.out.println(orpresp.getStatusCode());
		System.out.println(orpresp.getContentType());

		System.out.println("----------------------------------------------");

	}

	@Then("Validate StatusLine and StatusCode for Accurate")
	public void Validate_StatusLine_and_StatusCode_for_Accurate() {

		System.out.println("----------------------------------------------");

		System.out.println(accurateresp.getStatusLine());
		System.out.println(accurateresp.getStatusCode());
		System.out.println(accurateresp.getContentType());

		System.out.println("----------------------------------------------");

	}

	@Then("Validate Body for Pyramid")
	public void Validate_Body_for_Pyramid() {

		System.out.println(pyramidresp.jsonPath().getList("ratingActionName"));

		int RespArraySize = pyramidresp.jsonPath().getList("").size();
		System.out.println(RespArraySize);

		util.getdetails("Blue Ridge (NC) 2020 SALE", RespArraySize, pyramidresp);


	}

	@Then("Validate Body for ORP")
	public void Validate_Body_for_ORP() {

		System.out.println(orpresp.jsonPath().getList("ratingActionName"));

		int RespArraySize = orpresp.jsonPath().getList("").size();
		System.out.println(RespArraySize);

		util.getdetails("Association to RTG-733", RespArraySize, orpresp);

	}

	@Then("Validate Body for rating release details")
	public void Validate_Body_for_rating_release_details() {

		
		System.out.println(ratingreldetailsresp.jsonPath().getList("sourceSystem"));
		int RespArraySize = ratingreldetailsresp.jsonPath().getList("").size();
		System.out.println(RespArraySize);

		util.getdetails("ACCURATE", RespArraySize, ratingreldetailsresp);

		

	}

	@Then("Validate Body for Accurate")
	public void Validate_Body_for_Accurate() {

		System.out.println(accurateresp.jsonPath().getList("").size());
		System.out.println(accurateresp.jsonPath().getList("ratingActionName").get(0));
		System.out.println(accurateresp.jsonPath().getList("").get(0));
		System.out.println(accurateresp.jsonPath().getList("").isEmpty());

	}

}
