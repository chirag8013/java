package com.moodys.qats.stepdefinitions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.moodys.qats.page.*;
import com.moodys.qats.utilities.TestBase;
import com.moodys.qats.utilities.Util;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Log4j2
public class Step {
	private String actionid;
	private Actions act;
	private WebDriver driver;

	private Properties prop;

	private CreateQAReviewManualCase createcase;

	private AdminUtils_SourceVsQATSMapping sourcevsqats;

	private QATS_LoginPage loginpage;
	private QATS_HomePage homepage;
	private MyWork mywork;
	private Util util;
	private Dashboard dashboard;
	private QualityReferenceSheet qrsheet;
	private TestBase base;
	String todaydate;

	@Given("User Launch Chrome Browser")
	public void User_Launch_Chrome_Browser() throws IOException {
		base = new TestBase();
		prop = base.initialization();

		driver = base.launchthebrowser();

		util = new Util(driver);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		todaydate = dateformat.format(date);
		log.info("Today is " + todaydate);

	}

	@When("User enter the the MeerQATS login page")
	public void User_enter_the_the_MeerQATS_login_page() {

		driver.get("https://pega-orp-qa-11.ad.moodys.net:8443/prweb/PRServlet/");

	}

	@When("After Verifying login page title")
	public void After_Verifying_login_page_title() {
		loginpage = new QATS_LoginPage(driver);
		log.info("----------------------------------");
		String title = loginpage.LoginPageTitle();
		log.info(title);
		Assert.assertEquals(title, "Welcome to PegaRULES");
		log.info("Login Page Title Verified as expected- " + title);
		log.info("----------------------------------");

	}

	@When("Manager enters Username and Password and click login")
	public void Manager_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(driver, prop.getProperty("ManagerUserName"), prop.getProperty("ManagerPassword"));

		Thread.sleep(4000);
		createcase = new CreateQAReviewManualCase(driver);
		mywork = new MyWork(driver);
		dashboard = new Dashboard(driver);
		qrsheet = new QualityReferenceSheet(driver);

	}

	@When("Admin enters Username and Password and click login")
	public void Admin_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(driver, prop.getProperty("AdminUserName"), prop.getProperty("AdminPassword"));

		Thread.sleep(4000);
		createcase = new CreateQAReviewManualCase(driver);
		mywork = new MyWork(driver);
		dashboard = new Dashboard(driver);
		qrsheet = new QualityReferenceSheet(driver);
		sourcevsqats = new AdminUtils_SourceVsQATSMapping(driver);

	}

	@When("Reviewer enters Username and Password and click login")
	public void Reviewer_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(driver, prop.getProperty("ReviewerUserName"), prop.getProperty("ReviewerPassword"));

		Thread.sleep(4000);
		createcase = new CreateQAReviewManualCase(driver);
		mywork = new MyWork(driver);

	}

	@Then("Manager enter MeerQATS HomePage")
	public void Manager_enter_MeerQATS_HomePage() {

		String homepagetitle = homepage.HomePageTitle();
		log.info("----------------------------------");
		log.info(homepage.HomePageTitle());
		Assert.assertEquals(homepagetitle, "QA Manager");
		log.info("HomePage Title Verified as expected- " + homepagetitle);
		log.info("----------------------------------");

	}

	@Then("Reviewer enter MeerQATS HomePage")
	public void Reviewer_enter_MeerQATS_HomePage() {

		String homepagetitle = homepage.HomePageTitle();
		log.info("----------------------------------");
		log.info(homepage.HomePageTitle());
		Assert.assertEquals(homepagetitle, "QA Reviewer");
		log.info("HomePage Title Verified as expected- " + homepagetitle);
		log.info("----------------------------------");

	}

	@When("a manager clicks Create QA Review")
	public void User_Clicks_Create_QA_Review() throws InterruptedException {

		homepage.clickonQAReview();
		driver.navigate().refresh();
		Thread.sleep(4000);

		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//button[text()='Create Manual Case']")).getText();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		Thread.sleep(3000);

	}

	@When("After clicking on Create Manual Case")
	public void After_clicking_on_Create_Manual_Case() {

		createcase.clickoncreatemanualcase();
	}

	@When("User Clicks Create Manual Case")
	public void User_Clicks_Create_Manual_Case() throws InterruptedException {

		homepage.clickonCreateManualCase();

		Thread.sleep(2000);

		driver.navigate().refresh();

		Thread.sleep(4000);

	}

	
	@When("^enters required fields \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enters_required_fields_and_and_and_and(String actionid, String CaseDesc, String sourcename, String leadanalyst, String ratingactiondate) throws Throwable {
		createcase.createmanualcasewithdate(actionid, CaseDesc, sourcename, leadanalyst, ratingactiondate);
	}
	

	 @When("clicks on Create Case")
	 public void click_on_create_case() throws InterruptedException {
	createcase.clickoncreatecase();
	 }

	 @Then("^searches for Case Id in My Work to validate successful case creation with \"([^\"]*)\"$")
	 public void searches_for_Case_Id_in_My_Work_to_validate_successful_case_creation_with(String actionid) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     mywork.displaynewlycreatedreviewcase(actionid);
	 }

	@When("selects Review Case")
	public void selects_review_case() throws InterruptedException {

		List<WebElement> ls = createcase.CreateCase_CheckBoxList();
		ls.get(0).click();

		actionid = createcase.getactionidoffirstcase();
		Thread.sleep(3000);

	}

	

	@Then("Manager Goes to Dashboard")
	public void Manager_Goes_to_Dashboard() throws InterruptedException {

		homepage.clickonDashboard();

		Thread.sleep(2000);
	}

	@Then("Manager can search for Case Id in Dashboard to validate successful case creation")
	public void Manager_clicks_on_Dashboard() throws InterruptedException, IOException {

		homepage.gobacktodashboard();

		Thread.sleep(2000);
		mywork.displaynewlycreatedreviewcase(actionid);
	}

	@Then("Validate the created case in Dashboard")
	public void Validate_the_created_case_in_Dashboard() throws InterruptedException, IOException {

		mywork.displaynewlycreatedreviewcase(actionid);

	}

	@When("Manager goes to MyWork and Search for Upload Vital Record Case")
	public void Manager_goes_to_MyWork_and_Search_for_Upload_Vital_Record_Case() throws InterruptedException {
		homepage.userclicksonmywork(driver);

	}

	@When("on Selecting a Review Case")
	public void on_Selecting_a_Review_Case() throws InterruptedException, IOException {

		mywork.selectuploadvitalrecordsreviewcase();
	}

	@Then("^Reviewer completes the Questionnaire Click on Submit Review$")
	public void reviewer_completes_the_Questionnaire_Click_on_Submit_Review() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		util.PerformQuestionnaire();
	}

	@Then("Manager completes the questionnaire under QRS and submit")
	public void Manager_completes_the_questionnaire_under_QRS_and_submit() throws InterruptedException {

		util.PerformQuestionnaire();
	}

	@When("Reviewer Clicks on My Work")
	public void Reviewer_Clicks_on_My_Work() throws InterruptedException {
		homepage.userclicksonmywork(driver);

	}
	
	@When("^manager clicks on Create Manual Case with the Rating Release Date four days before from current date$")
	public void manager_clicks_on_Create_Manual_Case_with_the_Rating_Release_Date_four_days_before_from_current_date() throws Throwable {
		createcase.clickoncreatemanualcase();
		String today = todaydate.split("/")[1];
		System.out.println(today);
		int datetoday = Integer.parseInt(today);
		int fourdaysbefore = datetoday - 4;
		Calendar calender = Calendar.getInstance(TimeZone.getDefault());
		//getting DayNumber of week like Sunday-1, Monday-2
		int dayofweek= calender.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayofweek);
		int flag=0,rep=0;
		for(int d= dayofweek-1; d>=-4;d--){	
			flag++;
			if(d<=1){
				rep++; 
				fourdaysbefore=fourdaysbefore-1;			
			}
			if(flag==4&&d==1){
				fourdaysbefore=fourdaysbefore-1;
			}
			if(flag==4||rep==2){
				break;
			}
		}
		String fourdaysbeforedate = Integer.toString(fourdaysbefore);
		
		
		
		System.out.println("four days before date is --------------------> " + fourdaysbeforedate);
		createcase.createmanualcasewithdate(prop.getProperty("ActionID"), prop.getProperty("CaseDesc"),
				prop.getProperty("Sourcename"), prop.getProperty("LeadAnalyst"), fourdaysbeforedate);
		createcase.clickoncreatecase();
	}

	@Then("^manager with Case Id searches the case available for Day(\\d+) Review$")
	public void manager_with_Case_Id_searches_the_case_available_for_Day_Review(int day) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   homepage.gobacktoDay4Review(prop.getProperty("ActionID"));
	}
	
	@When("^clicks on Create Manual Case with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void clicks_on_Create_Manual_Case_with_and_and_and_and(String actionid, String CaseDesc, String sourcename, String leadanalyst, String ratingactiondate) throws Throwable {
		createcase.clickoncreatemanualcase();
		createcase.createmanualcasewithdate(actionid, CaseDesc, sourcename, leadanalyst, ratingactiondate);
		createcase.clickoncreatecase();
	}
	
	
	@Then("^Search for Case Id in Dashboard to validate successful case creation with \"([^\"]*)\"$")
	public void search_for_Case_Id_in_Dashboard_to_validate_successful_case_creation_with(String ACTIONID) throws Throwable {
		homepage.clickonDashboard();
		mywork.displaynewlycreatedreviewcase(ACTIONID);
	}

	@When("^a reviewer clicks Create Manual Case$")
	public void a_reviewer_clicks_Create_Manual_Case() throws Throwable {
		homepage.clickonCreateManualCase();

		Thread.sleep(2000);

		driver.navigate().refresh();

		Thread.sleep(4000);
	}

	@Then("Manager click on Quality Review Work Queue and validate case status for any case")
	public void Manager_click_on_Quality_Review_Work_Queue_and_validate_case_status_for_any_case()
			throws InterruptedException {
		dashboard.clickonworkbasket("Quality Review Work Queue");
		Thread.sleep(1000);

		dashboard.clickonfirstcase();

		Thread.sleep(1000);
		qrsheet.clickonactionbutton();
		Thread.sleep(1000);

		qrsheet.clickonupdatecasestatus();
		Thread.sleep(2000);

		qrsheet.selectcasestatus("Pending-QAAllocation");

		qrsheet.clickonsubmit();
		Thread.sleep(2000);

	}

	@When("Admin clicks on configuration")
	public void Admin_clicks_on_configuration() throws InterruptedException {

		homepage.clickonconfiguration();
	}

	@Given("User clicks on Admin Utils and then Edit Review Date")
	public void User_clicks_on_Admin_Utils_and_then_Edit_Review_Date() throws InterruptedException {
		homepage.clickonadminutils();
		homepage.clickoneditreviewdate();

	}

	@When("^Admin clicks on Admin Utils and then Mapping QATS vs Source$")
	public void User_clicks_on_Admin_Utils_and_then_Mapping_QATS_vs_Source() throws InterruptedException {
		homepage.clickonadminutils();
		homepage.clickonmappingqatsvssource();

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and click on Submit Update$")
	public void user_enters_and_and_and_click_on_Submit_Update(String AnalystLocCode, String RatingDate,
			String NewReviewDate) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.Editreviewdatefields(AnalystLocCode, RatingDate, NewReviewDate);
	}

	@Then("Review Date is updated successfully for all the sorted cases")
	public void Review_Date_is_updated_successfully_for_all_the_sorted_cases() {

		log.info("Review date updated successfully");
	}

	@Then("^Admin selects \"([^\"]*)\" and clicks on Search$")
	public void admin_selects_and_clicks_on_Search(String DomainName) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homepage.selectDomainNameandclickonsearch(DomainName);

	}

	@Then("^After clicking the first record Admin clicks on delete the mapping of record  with \"([^\"]*)\"and submit$")
	public void after_clicking_the_first_record_Admin_clicks_on_delete_the_mapping_of_record_with_and_submit(
			String sourcevalue) throws Throwable {
		sourcevsqats.deletemappingofrecord(sourcevalue);

	}

	@Then("^After Clicking on the Source Value and QATS value mapped Record Admin update the mapping of \"([^\"]*)\" with \"([^\"]*)\" and click submit$")
	public void after_Clicking_on_the_Source_Value_and_QATS_value_mapped_Record_Admin_update_the_mapping_of_with_and_click_submit(
			String sourcevalue, String qatsvalue) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		sourcevsqats.mappingupdate(sourcevalue, qatsvalue);
	}

	@Then("^Admin clicks on submit on QATS vs Source Mapping Page to save the changes$")
	public void admin_clicks_on_submit_on_QATS_vs_Source_Mapping_Page_to_save_the_changes() throws Throwable {
		sourcevsqats.clickonsubmittosave();
	}

	@Then("^Go back to the Create QA Review and Select Region as \"([^\"]*)\" and Create the case$")
	public void go_back_to_the_Create_QA_Review_and_Select_Region_as_and_Create_the_case(String sourcevalue)
			throws Throwable {
		homepage.clickonQAReview();
		Thread.sleep(3000);

		for (int y = 0; y < 20; y++) {
			try {

				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//button[text()='Create Manual Case']")).getText();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();

				continue;
			}
		}

		Thread.sleep(3000);

		actionid = createcase.sortforregionandclickoncreatecase(sourcevalue);

	}

	@Then("^Go back to Dashboard and check the QATSValue of created case as expected$")
	public void go_back_to_Dashboard_and_check_the_QATSValue_of_created_case_as_expected() throws Throwable {
		homepage.clickonDashboard();

		Thread.sleep(2000);

		mywork.displaynewlycreatedreviewcase(actionid);

	}

	@Then("^Admin clicks on Add Item$")
	public void admin_clicks_on_Add_Item() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		sourcevsqats.clickonadditem();
	}

	@Then("^Admin selects \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\" and click on submit$")
	public void admin_selects_and_and_click_on_submit(String sourcevalue, String qatsvalue, String domainname)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		sourcevsqats.selectsourceandqatsvalue(sourcevalue, qatsvalue, domainname);
	}

	@After
	public void teardown() throws InterruptedException {

		util.teardown();
	}

}
