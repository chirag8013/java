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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class QuestionRemediationObservation {
	
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
	
	@When("^Log into QATS Application as an Admin to perform QuestionRemediation$")
	public void log_into_QATS_Application_as_an_Admin_to_perform_QuestionRemediation() throws Throwable {
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
	
	@After("@QuesRemed")
	public void teardown() throws InterruptedException {

		util.teardown();
	}

}
