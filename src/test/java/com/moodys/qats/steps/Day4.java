package com.moodys.qats.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.moodys.qats.page.Add_Update_Questions;
import com.moodys.qats.page.Add_Update_Remediation;
import com.moodys.qats.page.AdminUtils_MaintainQATSValue;
import com.moodys.qats.page.AdminUtils_SourceVsQATSMapping;
import com.moodys.qats.page.CreateQAReviewManualCase;
import com.moodys.qats.page.Dashboard;
import com.moodys.qats.page.Data_Ingestion;
import com.moodys.qats.page.MyWork;
import com.moodys.qats.page.QATS_HomePage;
import com.moodys.qats.page.QATS_LoginPage;
import com.moodys.qats.page.QualityReferenceSheet;
import com.moodys.qats.utilities.TestBase;
import com.moodys.qats.utilities.Util;
import com.moodys.qats.utilities.Util1;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Day4 {
	
	private AdminUtils_MaintainQATSValue maintainqats;
	private String actionid;
	private Actions act;
	private WebDriver driver;

	private Properties prop;

	private CreateQAReviewManualCase createcase;
	private Data_Ingestion dataingestion;

	private AdminUtils_SourceVsQATSMapping sourcevsqats;
	private Add_Update_Questions addupdateques;
	private Add_Update_Remediation addupdateremediation;

	private QATS_LoginPage loginpage;
	private QATS_HomePage homepage;
	private MyWork mywork;
	private Util util;
	private Util1 util1;
	private Dashboard dashboard;
	private QualityReferenceSheet qrsheet;
	private TestBase base;
	String todaydate,completedate;
	int datetoday;
	
	@When("^Log into QATS Application as an Admin to perform Day4$")
	public void log_into_QATS_Application_as_an_Admin_to_perform_Day4() throws Throwable {
		base = new TestBase();
		prop = base.initialization();

		driver = base.launchthebrowser();

		util = new Util(driver);
		util1= new Util1(driver);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat dateformat1 = new SimpleDateFormat("MMMM/dd/yyyy");
		todaydate = dateformat.format(date);
		 completedate= dateformat1.format(date);
		log.info("Today is " + todaydate);
		log.info("Today is " + completedate);
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("welcome"));


	loginpage = new QATS_LoginPage(driver);
		log.info("----------------------------------");
		String title = loginpage.LoginPageTitle();
		log.info(title);
		Assert.assertEquals(title, "Welcome to PegaRULES");
		log.info("Login Page Title Verified as expected- " + title);
		log.info("----------------------------------");


	homepage = loginpage.Login(driver, prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));
	homepage.switchtoAdministrator();

		Thread.sleep(4000);
		createcase = new CreateQAReviewManualCase(driver);
		mywork = new MyWork(driver);
		dashboard = new Dashboard(driver);
		qrsheet = new QualityReferenceSheet(driver);
		sourcevsqats = new AdminUtils_SourceVsQATSMapping(driver);
		maintainqats= new AdminUtils_MaintainQATSValue(driver);
		addupdateques= new Add_Update_Questions(driver);
		addupdateremediation= new Add_Update_Remediation(driver);
		dataingestion= new Data_Ingestion(driver);
	}
	
	@When("^I Create Manual Case with the Rating Release Date four days prior to current date with ActionID \"([^\"]*)\" and analystlocation \"([^\"]*)\"$")
	public void i_Create_Manual_Case_with_the_Rating_Release_Date_four_days_prior_to_current_date_with_ActionID_and_analystlocation(String ActionID, String analystloca) throws Throwable {
		homepage.clickonQAReview();
		driver.navigate().refresh();
		Thread.sleep(4000);

		util1.switchcreatemanualcase();
		Thread.sleep(3000);
		
		createcase.clickoncreatemanualcase();
		String fourdaysbeforedate=util1.fourdaysbefratingrelcalc(todaydate, analystloca, completedate);
		
		createcase.createmanualcasewithdate(ActionID, prop.getProperty("CaseDesc"),
				prop.getProperty("Sourcename"), prop.getProperty("LeadAnalyst"), fourdaysbeforedate,analystloca);
		createcase.clickoncreatecase();
	}


	@Then("^I should be able to search for the case with ActionID \"([^\"]*)\" on Day(\\d+) Review screen$")
	public void i_should_be_able_to_search_for_the_case_with_ActionID_on_Day_Review_screen(String Actionid, int arg2) throws Throwable {
		homepage.gobacktoDay4Review(Actionid,"QualityReview");
	}
	
	@Then("^I should be able to search for the case with ActionID \"([^\"]*)\" and assign it to QATS User and confirms the same in Day four Review$")
	public void i_should_be_able_to_search_for_the_case_with_ActionID_and_assign_it_to_QATS_User_and_confirms_the_same_in_Day_four_Review(String ACTIONID) throws Throwable {
		homepage.gobacktodashboardforbulkassignments();
		dashboard.clickonbulkassignments();
		Thread.sleep(2000);
		mywork.diaplaynewlycreatedcasebulkassignments(ACTIONID);
		Thread.sleep(4000);
		util1.assigncasetouser();
		homepage.gobacktoDay4Review(ACTIONID,"Test@rqms");
	}
	
	@After("@Day4Scenario")
	public void teardown() throws InterruptedException {

		util.teardown();
	}
	

}
