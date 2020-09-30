package com.moodys.meerqats.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

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
				"D:\\Users/VermaC/Workspace1/MeerQATS_Cucumber_RestAssured/MeerQATS_Cucumber_RestAssured/Config.properties");
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

	@When("^Rest Get Call is made from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void rest_Get_Call_is_made_from_to(String startdate, String enddate) throws Throwable {
		ratingreldetailsresp = RestAssured.given().auth().preemptive()
				.basic(prop.getProperty("RestUsername"), prop.getProperty("RestPassword")).when()
				.get(prop.getProperty("ratingrelsummarybaseurl") + "/" + startdate + "/" + enddate + "");
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
	
	@Then("^Validate \"([^\"]*)\" and \"([^\"]*)\" for Accurate$")
	public void validate_and_for_Accurate(String statusline, String statuscode) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("----------------------------------------------");

		System.out.println(accurateresp.getStatusLine());
		System.out.println(accurateresp.getStatusCode());
		//Assert.assertEquals(Integer.parseInt(statuscode), accurateresp.getStatusCode());
	
		System.out.println(accurateresp.getContentType());
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

	@Then("^Validate Response Body from Pyramid and fetch record with ratingactionname \"([^\"]*)\"$")
	public void validate_Response_Body_from_Pyramid_and_fetch_record_with_ratingactionname(String ratingactionname)
			throws Throwable {
		int RespArraySize = pyramidresp.jsonPath().getList("").size();
		System.out.println("Size of the response array is " + RespArraySize);
		System.out.println();
		System.out.println("-------Below are the list of RatingActionNames------");
		System.out.println(pyramidresp.jsonPath().getList("ratingActionName"));
		System.out.println();

		util.getdetails(ratingactionname, RespArraySize, pyramidresp);

	}

	@Then("^Validate Response Body from Accurate and fetch record with ratingactionname \"([^\"]*)\"$")
	public void validate_Response_Body_from_Accurate_and_fetch_record_with_ratingactionname(String ratingactionname)
			throws Throwable {
		int RespArraySize = accurateresp.jsonPath().getList("").size();
		System.out.println("Size of the response array is " + RespArraySize);
		System.out.println();

		System.out.println(accurateresp.jsonPath().getList("ratingActionName"));
		System.out.println();

		util.getdetails(ratingactionname, RespArraySize, accurateresp);
	}

	
	@Then("^Validate Response from Accurate which includes Ratingactionid \"([^\"]*)\" and Analystlocation \"([^\"]*)\"$")
	public void validate_Response_from_Accurate_which_includes_Ratingactionid_or_Analystlocation(String ratingactionid, String analystlocation) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		int RespArraySize = accurateresp.jsonPath().getList("").size();
		System.out.println("Size of the response array is " + RespArraySize);
		System.out.println();

		System.out.println(accurateresp.jsonPath().getList("ratingActionName"));
		System.out.println();

		util.getdetailsbasedonratingactionid(ratingactionid,analystlocation,RespArraySize, accurateresp);
	}

	@Then("^Validate Response Body from ORP and fetch record with ratingactionname \"([^\"]*)\"$")
	public void validate_Response_Body_from_ORP_and_fetch_record_with_ratingactionname(String ratingactionname)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		int RespArraySize = orpresp.jsonPath().getList("").size();
		System.out.println("Size of the response array is " + RespArraySize);

		System.out.println();

		System.out.println(orpresp.jsonPath().getList("ratingActionName"));

		System.out.println();

		util.getdetails(ratingactionname, RespArraySize, orpresp);
	}

	@Then("^Validate Response Body and fetch record with sourcename \"([^\"]*)\"$")
	public void validate_Response_Body_and_fetch_record_with_sourcename(String sourcesystem) throws Throwable {
		int RespArraySize = ratingreldetailsresp.jsonPath().getList("").size();
		System.out.println("Size of the response array is " + RespArraySize);
		System.out.println();
		System.out.println(ratingreldetailsresp.jsonPath().getList("sourceSystem"));
		System.out.println();

		util.getdetails(sourcesystem, RespArraySize, ratingreldetailsresp);
	}

}
