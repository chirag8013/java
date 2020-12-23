package com.moodys.qats.step;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.moodys.qats.page.*;
import com.moodys.qats.utilities.TestBase;
import com.moodys.qats.utilities.Util;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Log4j2
public class Step {
	
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
	private Dashboard dashboard;
	private QualityReferenceSheet qrsheet;
	private TestBase base;
	String todaydate;
	int datetoday;
	

	@When("^User enter the valid credentials that maps to Admin role in QATS$")
	public void user_enter_the_valid_credentials_that_maps_to_Admin_role_in_QATS() throws Throwable {
		base = new TestBase();
		prop = base.initialization();

		driver = base.launchthebrowser();

		util = new Util(driver);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		todaydate = dateformat.format(date);
		log.info("Today is " + todaydate);
		//driver.get("https://pega-orp-qa-11.ad.moodys.net:8443/prweb/PRServlet/");
		driver.get("https://pega-orp-in-11.ad.moodys.net:8443/prweb/PRServlet");
	}

	@When("^is able to view the Admin Landing page$")
	public void is_able_to_view_the_Admin_Landing_page() throws Throwable {
		
		loginpage = new QATS_LoginPage(driver);
		log.info("----------------------------------");
		String title = loginpage.LoginPageTitle();
		log.info(title);
		Assert.assertEquals(title, "Welcome to PegaRULES");
		log.info("Login Page Title Verified as expected- " + title);
		log.info("----------------------------------");

	}
	
	@When("^I am able to login to QATS as an Admin$")
	public void i_am_able_to_login_to_QATS_as_an_Admin() throws Throwable {
		homepage = loginpage.Login(driver, prop.getProperty("AdminUserNameUAT"), prop.getProperty("AdminPasswordUAT"));

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

		//driver.get("https://pega-orp-qa-11.ad.moodys.net:8443/prweb/PRServlet/");
		driver.get("https://pega-orp-in-11.ad.moodys.net:8443/prweb/PRServlet");

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

		homepage = loginpage.Login(driver, prop.getProperty("ManagerUserNameUAT"), prop.getProperty("ManagerPasswordUAT"));

		Thread.sleep(4000);
		createcase = new CreateQAReviewManualCase(driver);
		mywork = new MyWork(driver);
		dashboard = new Dashboard(driver);
		qrsheet = new QualityReferenceSheet(driver);

	}

	@When("Admin enters Username and Password and click login")
	public void Admin_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(driver, prop.getProperty("AdminUserNameUAT"), prop.getProperty("AdminPasswordUAT"));

		Thread.sleep(4000);
		createcase = new CreateQAReviewManualCase(driver);
		mywork = new MyWork(driver);
		dashboard = new Dashboard(driver);
		qrsheet = new QualityReferenceSheet(driver);
		sourcevsqats = new AdminUtils_SourceVsQATSMapping(driver);
		maintainqats= new AdminUtils_MaintainQATSValue(driver);

	}

	@When("Reviewer enters Username and Password and click login")
	public void Reviewer_enters_Username_and_Password_and_click_login() throws InterruptedException, IOException {

		homepage = loginpage.Login(driver, prop.getProperty("ReviewerUserNameUAT"), prop.getProperty("ReviewerPasswordUAT"));

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
	
	
	@When("^manager clicks on Create Manual Case with the Rating Release Date four days before from current date with case id \"([^\"]*)\"$")
	public void manager_clicks_on_Create_Manual_Case_with_the_Rating_Release_Date_four_days_before_from_current_date_with_case_id(String ACTIONID) throws Throwable {
		createcase.clickoncreatemanualcase();
		String today = todaydate.split("/")[1];
		System.out.println(today);
		datetoday = Integer.parseInt(today);
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
		createcase.createmanualcasewithdate(ACTIONID, prop.getProperty("CaseDesc"),
				prop.getProperty("Sourcename"), prop.getProperty("LeadAnalyst"), fourdaysbeforedate);
		createcase.clickoncreatecase();
	}
	
	@Then("^manager with \"([^\"]*)\" searches the case available for Day(\\d+) Review$")
	public void manager_with_searches_the_case_available_for_Day_Review(String ActionID, int arg2) throws Throwable {
		homepage.gobacktoDay4Review(ActionID,"QualityReview");
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

		qrsheet.clickoncontinueconfirm();
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
	
	@When("^Admin chooses the option Mapping QATS to Source from Admin Utils Menu$")
	public void admin_chooses_the_option_Mapping_QATS_to_Source_from_Admin_Utils_Menu() throws Throwable {
		homepage.clickonadminutils();
		homepage.clickonmappingqatsvssource();
	}

	@When("^selects \"([^\"]*)\" and clicks on Search$")
	public void selects_and_clicks_on_Search(String DomainName) throws Throwable {
		homepage.selectDomainNameandclickonsearch(DomainName);
	}

	@When("^changes mapping of \"([^\"]*)\" with \"([^\"]*)\" and click submit to save changes$")
	public void changes_mapping_of_with_and_click_submit_to_save_changes(String sourcevalue, String qatsvalue) throws Throwable {
		sourcevsqats.mappingupdate(sourcevalue, qatsvalue);
		sourcevsqats.clickonsubmittosave();
	}

	@Then("^I Should Go back to the Create QA Review and Select Region as \"([^\"]*)\" and Create the case$")
	public void i_Should_Go_back_to_the_Create_QA_Review_and_Select_Region_as_and_Create_the_case(String sourcevalue) throws Throwable {
		homepage.clickonQAReview();
		Thread.sleep(3000);

		for (int y = 0; y < 20; y++) {
			try {

				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				//actionid = createcase.sortforregionandclickoncreatecase(sourcevalue);
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

	@Then("^check the QATSValue of created case as expected on Dashboard$")
	public void check_the_QATSValue_of_created_case_as_expected_on_Dashboard() throws Throwable {
		homepage.clickonDashboard();

		Thread.sleep(2000);

		mywork.displaynewlycreatedreviewcase(actionid);
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

	@Then("^after clicking the first record the Admin clicks on delete the mapping of record  with \"([^\"]*)\"and submit$")
	public void after_clicking_the_first_record_the_Admin_clicks_on_delete_the_mapping_of_record_with_and_submit(
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

	@Then("^after the Admin clicks on Add Item$")
	public void after_the_admin_clicks_on_Add_Item() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		sourcevsqats.clickonadditem();
	}

	@Then("^Admin selects \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\" and click on submit$")
	public void admin_selects_and_and_click_on_submit(String sourcevalue, String qatsvalue, String domainname)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		sourcevsqats.selectsourceandqatsvalue(sourcevalue, qatsvalue, domainname);
	}
	
	@When("^an Admin clicks Create QA Review$")
	public void an_Admin_clicks_Create_QA_Review() throws Throwable {
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

	
	@When("^Admin clicks on Create Manual Case with the Rating Release Date four days before from current date with ActionID \"([^\"]*)\"$")
	public void admin_clicks_on_Create_Manual_Case_with_the_Rating_Release_Date_four_days_before_from_current_date_with_ActionID(String ActionID) throws Throwable {
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
		createcase.createmanualcasewithdate(ActionID, prop.getProperty("CaseDesc"),
				prop.getProperty("Sourcename"), prop.getProperty("LeadAnalyst"), fourdaysbeforedate);
		createcase.clickoncreatecase();
	}
	
	@Then("^Admin with ActionID \"([^\"]*)\" searches the case available for Day(\\d+) Review$")
	public void admin_with_ActionID_searches_the_case_available_for_Day_Review(String Actionid, int arg2) throws Throwable {
		homepage.gobacktoDay4Review(Actionid,"QualityReview");
		
		
	}
	
	@Then("^Admin Searches for the case with ActionID \"([^\"]*)\" created in Dashboard and assign it to QATS User$")
	public void admin_Searches_for_the_case_with_ActionID_created_in_Dashboard_and_assign_it_to_QATS_User(String ACTIONID) throws Throwable {
		homepage.gobacktodashboardforbulkassignments();
		dashboard.clickonbulkassignments();
		Thread.sleep(2000);
		mywork.diaplaynewlycreatedcasebulkassignments(ACTIONID);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[@data-attribute-name='Select']/div/input[@data-ctl='Checkbox']")).click();
		driver.findElement(By.xpath("//label[text()='Assigned To']/following-sibling::div/input")).sendKeys("test@rqms");
		driver.findElement(By.xpath("//button[text()='Assign']")).click();
		Thread.sleep(4000);
		homepage.gobacktoDay4Review(ACTIONID,"Test@rqms");
		
	}
	

	@Then("^Admin send the Day(\\d+) Email from Day(\\d+) review after selecting the incomplete documents$")
	public void admin_send_the_Day_Email_from_Day_review_after_selecting_the_incomplete_documents(int arg1, int arg2) throws Throwable {
	   
	}


	@Then("^QATS User login into the application and searches for the case in Day(\\d+) Review$")
	public void qats_User_login_into_the_application_and_searches_for_the_case_in_Day_Review(int arg1) throws Throwable {
	   
	}

	@Then("^after selecting the incomplete documents QATS User Sends Day(\\d+) Email$")
	public void after_selecting_the_incomplete_documents_QATS_User_Sends_Day_Email(int arg1) throws Throwable {
	    
	}
	
	@When("^Admin clicks on Admin Utils and then Maintain QATS Value$")
	public void admin_clicks_on_Admin_Utils_and_then_Maintain_QATS_Value() throws Throwable {
	    homepage.clickonadminutils();
	    homepage.clickonmaintainqatsvalue();
	}

	@When("^After selecting \"([^\"]*)\" Admin clicks on Add Button by Admin$")
	public void after_selecting_Admin_clicks_on_Add_Button_by_Admin(String domainname) throws Throwable {
	   
		maintainqats.selectdomainandclickonadd(domainname);
		
	}

	@Then("^Admin Adds new \"([^\"]*)\" and submit$")
	public void admin_Adds_new_and_submit(String qatsvalue) throws Throwable {
		maintainqats.addnewqatsvalueandsubmit(qatsvalue);
		
	}
	
	@When("^Admin selects a \"([^\"]*)\"$")
	public void admin_selects_a(String domain) throws Throwable {
	   maintainqats.selectdomain(domain);
	}

	
	@Then("^Admin change the status of \"([^\"]*)\" Active or Inactive$")
	public void admin_change_the_status_of_Active_or_Inactive(String qatsvalue) throws Throwable {
		
		  maintainqats.selectqatsvalueandmakeactiveorinactiveandsubmit(qatsvalue);
	}
	
	@Given("^I have Logged into QATS Application as an Admin$")
	public void i_have_Logged_into_QATS_Application_as_an_Admin() throws Throwable {
	    
	}

	@Then("^Upon Occasion I Need to be able to ingest data from Pyramid for a given date$")
	public void upon_Occasion_I_Need_to_be_able_to_ingest_data_from_Pyramid_for_a_given_date() throws Throwable {
		int size=0;
		homepage.clickonadminutils();
		homepage.clickondataingestion();
		String today=todaydate.split("/")[1];
		datetoday=Integer.parseInt(today);
		int yesterday= datetoday-1;
		String Yesterday= Integer.toString(yesterday);
		String yesterdaydate= todaydate.split("/")[0]+"/"+Yesterday+"/"+todaydate.split("/")[2]; 
		dataingestion.ondemandataingestion("Pyramid", Yesterday);
		driver.switchTo().defaultContent();
		homepage.clickonQAReview();
		Thread.sleep(3500);
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
		List<WebElement> dateelement= driver.findElements(By.xpath("//td[@data-attribute-name='Rating Release Date']/span"));
		
		for(WebElement ele:dateelement){
			if(ele.getText().equals(yesterdaydate)){
				 size=size+1;
			}
			if(size==20){
		    driver.findElement(By.xpath("//a[@aria-label='Next Page']")).click();
		    Thread.sleep(3500);
			dateelement= driver.findElements(By.xpath("//td[@data-attribute-name='Rating Release Date']"));
			}
			
		}
		System.out.println("Size of the ingested data is: "+size);
		  
	   
	}

	@Then("^view the ingested data on Dashboard to support  creation of new QA reviews$")
	public void view_the_ingested_data_on_Dashboard_to_support_creation_of_new_QA_reviews() throws Throwable {
	
	}

	@Given("^As QATS Admin I will be needing to perform Periodic Questionnaire Maintainance$")
	public void as_QATS_Admin_I_will_be_needing_to_perform_Periodic_Questionnaire_Maintainance() throws Throwable {
		
		homepage.clickonadminutils();
		homepage.clickonaddquestions();
		addupdateques.addaquestion("Chair Approval", "D36", "Sample through automation", "SAMPLE OBSERVATION AUTOMATION");
		driver.switchTo().defaultContent();
		homepage.clickonadminutils();
		homepage.clickonupdatequestions();
		addupdateques.updateaquestion("Chair Approval","D36", "Sample through automation update", "SAMPLE OBSERVATION AUTOMATION UPDATE","Yes");
		
	   
	}

	@Then("^I Need to be able to add or remove questions$")
	public void i_Need_to_be_able_to_add_or_remove_questions() throws Throwable {
	   
	}

	@Then("^or change the Observations$")
	public void or_change_the_Observations() throws Throwable {
	    
	}

	@Then("^or change the wording of the questions$")
	public void or_change_the_wording_of_the_questions() throws Throwable {
	  
	}

	@Given("^As part of the Remediation Maintainance$")
	public void as_part_of_the_Remediation_Maintainance() throws Throwable {
		homepage.clickonadminutils();
		homepage.clickonaddremediation();
	    addupdateremediation.addremediation("Chair Approval", "Sample through automation update", "Kindly Upload");
	    driver.switchTo().defaultContent();
	    homepage.clickonadminutils();
	    homepage.clickonupdateremediation();
	    addupdateremediation.updateremediation("Chair Approval", "Sample through automation update","Kindly upload necessary documents");
	    driver.switchTo().defaultContent();
	    homepage.clickonadminutils();
		homepage.clickonupdatequestions();
		addupdateques.updateaquestion("Chair Approval","D36", "Sample through automation update", "SAMPLE OBSERVATION AUTOMATION UPDATE","No");
	}

	@Then("^I need to be able to add or remove Remediations$")
	public void i_need_to_be_able_to_add_or_remove_Remediations() throws Throwable {
	   
	}

	@Then("^change the wording of the Remediations$")
	public void change_the_wording_of_the_Remediations() throws Throwable {
	    
	}
	
	@Then("^Upon Occasion I Need to be able to ingest data from Accurate for a given date$")
	public void upon_Occasion_I_Need_to_be_able_to_ingest_data_from_Accurate_for_a_given_date() throws Throwable {
		int size=0;
		homepage.clickonadminutils();
		homepage.clickondataingestion();
		String today=todaydate.split("/")[1];
		datetoday=Integer.parseInt(today);
		int yesterday= datetoday-1;
		String Yesterday= Integer.toString(yesterday);
		String yesterdaydate= todaydate.split("/")[0]+"/"+Yesterday+"/"+todaydate.split("/")[2]; 
		dataingestion.ondemandataingestion("Accurate", Yesterday);
		driver.switchTo().defaultContent();
		homepage.clickonQAReview();
		Thread.sleep(3500);
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
		List<WebElement> dateelement= driver.findElements(By.xpath("//td[@data-attribute-name='Rating Release Date']/span"));
		
		for(WebElement ele:dateelement){
			if(ele.getText().equals(yesterdaydate)){
				 size=size+1;
			}
			if(size==20){
		    driver.findElement(By.xpath("//a[@aria-label='Next Page']")).click();
		    Thread.sleep(3500);
			dateelement= driver.findElements(By.xpath("//td[@data-attribute-name='Rating Release Date']"));
			}
			
		}
		System.out.println("Size of the ingested data is: "+size);
	}

	@Then("^Upon Occasion I Need to be able to ingest data from ORP for a given date$")
	public void upon_Occasion_I_Need_to_be_able_to_ingest_data_from_ORP_for_a_given_date() throws Throwable {
		int size=0;
		homepage.clickonadminutils();
		homepage.clickondataingestion();
		String today=todaydate.split("/")[1];
		datetoday=Integer.parseInt(today);
		int yesterday= datetoday-1;
		String Yesterday= Integer.toString(yesterday);
		String yesterdaydate= todaydate.split("/")[0]+"/"+Yesterday+"/"+todaydate.split("/")[2]; 
		dataingestion.ondemandataingestion("ORP", Yesterday);
		driver.switchTo().defaultContent();
		homepage.clickonQAReview();
		Thread.sleep(3500);
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
		List<WebElement> dateelement= driver.findElements(By.xpath("//td[@data-attribute-name='Rating Release Date']/span"));
		
		for(WebElement ele:dateelement){
			if(ele.getText().equals(yesterdaydate)){
				 size=size+1;
			}
			if(size==20){
		    driver.findElement(By.xpath("//a[@aria-label='Next Page']")).click();
		    Thread.sleep(3500);
			dateelement= driver.findElements(By.xpath("//td[@data-attribute-name='Rating Release Date']"));
			}
			
		}
		System.out.println("Size of the ingested data is: "+size);
	}




	@After
	public void teardown() throws InterruptedException {

		util.teardown();
	}

}