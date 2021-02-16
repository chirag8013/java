package com.moodys.qats.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Reviewer {
	
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
	
	@When("^Log into QATS Application as a Reviewer$")
	public void log_into_QATS_Application_as_a_Reviewer() throws Throwable {
		base = new TestBase();
		prop = base.initialization();

		driver = base.launchthebrowser();

		util = new Util(driver);
		util1= new Util1(driver);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		
		todaydate = dateformat.format(date);
		
		log.info("Today is " + todaydate);
		
		
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("welcome"));
				
				loginpage = new QATS_LoginPage(driver);
				log.info("----------------------------------");
				String title = loginpage.LoginPageTitle();
				log.info(title);
				Assert.assertEquals(title, "Welcome to PegaRULES");
				log.info("Login Page Title Verified as expected- " + title);
				log.info("----------------------------------");
				
				homepage = loginpage.Login(driver, prop.getProperty("ReviewerUserName"), prop.getProperty("ReviewerPassword"));

				Thread.sleep(4000);
				createcase = new CreateQAReviewManualCase(driver);
				mywork = new MyWork(driver);
	}
	
	@Given("^access MeerQATS HomePage$")
	public void access_MeerQATS_HomePage() throws Throwable {
		String homepagetitle = homepage.HomePageTitle();
		log.info("----------------------------------");
		log.info(homepage.HomePageTitle());
		Assert.assertEquals(homepagetitle, "QA Reviewer");
		log.info("HomePage Title Verified as expected- " + homepagetitle);
		log.info("----------------------------------");
	}
	
	@When("^As a Reviewer I choose Create Manual Case option from menu$")
	public void as_a_Reviewer_I_choose_Create_Manual_Case_option_from_menu() throws Throwable {
		homepage.clickonCreateManualCase();

		Thread.sleep(2000);

		driver.navigate().refresh();

		Thread.sleep(4000);
	}


	@Given("^enter required fields actionid \"([^\"]*)\" and CaseDesc \"([^\"]*)\" and sourcename \"([^\"]*)\" and leadanalyst \"([^\"]*)\" and ratingactiondate \"([^\"]*)\"$")
	public void enter_required_fields_actionid_and_CaseDesc_and_sourcename_and_leadanalyst_and_ratingactiondate(String actionid, String CaseDesc, String sourcename, String leadanalyst, String ratingactiondate) throws Throwable {
		createcase.createmanualcasewithdate(actionid, CaseDesc, sourcename, leadanalyst, ratingactiondate,prop.getProperty("analystloc"));

	}

	@Given("^save by clicking on Create Case$")
	public void save_by_clicking_on_Create_Case() throws Throwable {
		createcase.clickoncreatecase();
	}
	
	@Then("^I should be able to find the newly created case on <My Work> and validate successful case creation with actionid \"([^\"]*)\"$")
	public void i_should_be_able_to_find_the_newly_created_case_on_My_Work_and_validate_successful_case_creation_with_actionid(String actionid) throws Throwable {
		 mywork.displaynewlycreatedreviewcase(actionid);
	}
	
	@When("^Reviewer confirms the case in Day four Review with ActionID \"([^\"]*)\"$")
	public void reviewer_confirms_the_case_in_Day_four_Review_with_ActionID(String ACTIONID) throws Throwable {
		util.teardown();
		base = new TestBase();
		prop = base.initialization();

		driver = base.launchthebrowser();

		util = new Util(driver);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		todaydate = dateformat.format(date);
		log.info("Today is " + todaydate);
		
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("welcome"));
				
				loginpage = new QATS_LoginPage(driver);
				log.info("----------------------------------");
				String title = loginpage.LoginPageTitle();
				log.info(title);
				Assert.assertEquals(title, "Welcome to PegaRULES");
				log.info("Login Page Title Verified as expected- " + title);
				log.info("----------------------------------");
				
				homepage = loginpage.Login(driver, prop.getProperty("ReviewerUserName"), prop.getProperty("ReviewerPassword"));

				Thread.sleep(4000);
				createcase = new CreateQAReviewManualCase(driver);
				mywork = new MyWork(driver);
		homepage.gobacktoDay4Review(ACTIONID,"Test@rqms");
	}
	
	
	@Then("^I should be able to search for the case with ActionID \"([^\"]*)\" and assign it to QATS User$")
	public void i_should_be_able_to_search_for_the_case_with_ActionID_and_assign_it_to_QATS_User(String ACTIONID) throws Throwable {
		homepage.gobacktodashboardforbulkassignments();
		dashboard.clickonbulkassignments();
		Thread.sleep(2000);
		mywork.diaplaynewlycreatedcasebulkassignments(ACTIONID);
		Thread.sleep(4000);
		util1.assigncasetouser();
		
		
	}
	
	@When("^Reviewer confirms the case in My Work with ActionID \"([^\"]*)\"$")
	public void reviewer_confirms_the_case_in_My_Work_with_ActionID(String ACTIONID) throws Throwable {
		util.teardown();
		base = new TestBase();
		prop = base.initialization();

		driver = base.launchthebrowser();

		util = new Util(driver);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		todaydate = dateformat.format(date);
		log.info("Today is " + todaydate);
		
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("welcome"));
				
				loginpage = new QATS_LoginPage(driver);
				log.info("----------------------------------");
				String title = loginpage.LoginPageTitle();
				log.info(title);
				Assert.assertEquals(title, "Welcome to PegaRULES");
				log.info("Login Page Title Verified as expected- " + title);
				log.info("----------------------------------");
				
				homepage = loginpage.Login(driver, prop.getProperty("ReviewerUserName"), prop.getProperty("ReviewerPassword"));

				Thread.sleep(4000);
				createcase = new CreateQAReviewManualCase(driver);
				mywork = new MyWork(driver);
	    homepage.gobacktoMyWork(ACTIONID, "Test@rqms");
	}

	
	@Then("^I should be able to search for the case with ActionID <actionid> and assign it to QATS User$")
	public void i_should_be_able_to_search_for_the_case_with_ActionID_actionid_and_assign_it_to_QATS_User() throws Throwable {
		homepage.gobacktodashboardforbulkassignments();
		dashboard.clickonbulkassignments();
		Thread.sleep(2000);
		mywork.diaplaynewlycreatedcasebulkassignments(actionid);
		Thread.sleep(4000);
		util1.assigncasetouser();
		
	}
	
	@When("^Reviewer confirms the case in My Work with ActionID <actionid>$")
	public void reviewer_confirms_the_case_in_My_Work_with_ActionID_actionid() throws Throwable {
		util.teardown();
		base = new TestBase();
		prop = base.initialization();

		driver = base.launchthebrowser();

		util = new Util(driver);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		todaydate = dateformat.format(date);
		log.info("Today is " + todaydate);
		
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("welcome"));
				
				loginpage = new QATS_LoginPage(driver);
				log.info("----------------------------------");
				String title = loginpage.LoginPageTitle();
				log.info(title);
				Assert.assertEquals(title, "Welcome to PegaRULES");
				log.info("Login Page Title Verified as expected- " + title);
				log.info("----------------------------------");
				
				homepage = loginpage.Login(driver, prop.getProperty("ReviewerUserName"), prop.getProperty("ReviewerPassword"));

				Thread.sleep(4000);
				createcase = new CreateQAReviewManualCase(driver);
				mywork = new MyWork(driver);
		homepage.gobacktoMyWork(actionid, "Test@rqms");
	}
	
	@When("^As a Reviewer I choose <My Work> And chooseReview a case by clicking on to <Review Case> otopn$")
	public void as_a_Reviewer_I_choose_My_Work_And_chooseReview_a_case_by_clicking_on_to_Review_Case_otopn() throws Throwable {
		homepage.userclicksonmywork(driver);
		mywork.selectuploadvitalrecordsreviewcase();
	}

	@Then("^I complete the questionnaire by tabbing through nine sections$")
	public void i_complete_the_questionnaire_by_tabbing_through_nine_sections() throws Throwable {
		util.PerformQuestionnaire();
	}

	@Then("^completes the questionnaire by answering all the questions$")
	public void completes_the_questionnaire_by_answering_all_the_questions() throws Throwable {
		
	}

	@Then("^Submit it for Review by clicking on <Submit> button$")
	public void submit_it_for_Review_by_clicking_on_Submit_button() throws Throwable {
	    
	}
	
	@When("^I as QATS User Create Manual Case with the Rating Release Date four days prior to current date with ActionID \"([^\"]*)\" and analystlocation \"([^\"]*)\"$")
	public void i_as_QATS_User_Create_Manual_Case_with_the_Rating_Release_Date_four_days_prior_to_current_date_with_ActionID_and_analystlocation(String ActionID, String analystloca) throws Throwable {
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

	@Then("^I as QATS User should be able to search for the case with ActionID \"([^\"]*)\" and assign it to QATS User and confirms the same in Day four Review$")
	public void i_as_QATS_User_should_be_able_to_search_for_the_case_with_ActionID_and_assign_it_to_QATS_User_and_confirms_the_same_in_Day_four_Review(String ACTIONID) throws Throwable {
		homepage.gobacktodashboardforbulkassignments();
		dashboard.clickonbulkassignments();
		Thread.sleep(2000);
		mywork.diaplaynewlycreatedcasebulkassignments(ACTIONID);
		Thread.sleep(4000);
		util1.assigncasetouser();
		homepage.gobacktoDay4Review(ACTIONID,"Test@rqms");
	}

	@Given("^First Log into QATS Application as a Manager$")
	public void first_Log_into_QATS_Application_as_a_Manager() throws Throwable {
		base = new TestBase();
		prop = base.initialization();

		driver = base.launchthebrowser();

		util = new Util(driver);
		util1= new Util1(driver);

		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		todaydate = dateformat.format(date);
		log.info("Today is " + todaydate);
		
		
		
		driver.get(prop.getProperty("url"));
		log.info(prop.getProperty("welcome"));
				
				loginpage = new QATS_LoginPage(driver);
				log.info("----------------------------------");
				String title = loginpage.LoginPageTitle();
				log.info(title);
				Assert.assertEquals(title, "Welcome to PegaRULES");
				log.info("Login Page Title Verified as expected- " + title);
				log.info("----------------------------------");

				homepage = loginpage.Login(driver, prop.getProperty("ManagerUserName"), prop.getProperty("ManagerPassword"));

				Thread.sleep(4000);
				createcase = new CreateQAReviewManualCase(driver);
				mywork = new MyWork(driver);
				dashboard = new Dashboard(driver);
				qrsheet = new QualityReferenceSheet(driver);
	}

	@When("^a manager go to Create QA Review$")
	public void a_manager_go_to_Create_QA_Review() throws Throwable {
		homepage.clickonQAReview();
		driver.navigate().refresh();
		Thread.sleep(9000);

		util1.switchcreatemanualcase();
		Thread.sleep(3000);
	}

	@When("^Creates Manual Case with actionid \"([^\"]*)\" and CaseDesc \"([^\"]*)\" and sourcename \"([^\"]*)\" and leadanalyst \"([^\"]*)\" and ratingactiondate \"([^\"]*)\"$")
	public void creates_Manual_Case_with_actionid_and_CaseDesc_and_sourcename_and_leadanalyst_and_ratingactiondate(String actionid, String CaseDesc, String sourcename, String leadanalyst, String ratingactiondate) throws Throwable {
		createcase.clickoncreatemanualcase();
		createcase.createmanualcasewithdate(actionid, CaseDesc, sourcename, leadanalyst, ratingactiondate,prop.getProperty("analystloc"));
		createcase.clickoncreatecase();
	}

	@When("^selects A Review Case$")
	public void selects_A_Review_Case() throws Throwable {
		List<WebElement> ls = createcase.CreateCase_CheckBoxList();
		ls.get(0).click();

		actionid = createcase.getactionidoffirstcase();
		Thread.sleep(3000);

	}

	@When("^Creates Case$")
	public void creates_Case() throws Throwable {
		createcase.clickoncreatecase();
	}

	@After("@Reviewer")
	public void teardown() throws InterruptedException {

		util.teardown();
	}
	
	

}
