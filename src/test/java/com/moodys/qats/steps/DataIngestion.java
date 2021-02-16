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
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DataIngestion{
	
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
	
	@When("^Log into QATS Application as an Admin to perform DataIngestion$")
	public void log_into_QATS_Application_as_an_Admin_to_perform_DataIngestion() throws Throwable {
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
	
	@When("^I should to be able to ingest data from Pyramid for a given date$")
	public void i_should_to_be_able_to_ingest_data_from_Pyramid_for_a_given_date() throws Throwable {
		
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
		util1.switchcreatemanualcase();
		util1.sizeofingesteddata(yesterdaydate);
	}

	@When("^view the ingested data on Dashboard to support  creation of new QA reviews$")
	public void view_the_ingested_data_on_Dashboard_to_support_creation_of_new_QA_reviews() throws Throwable {
	 
	}

	@When("^I should to be able to ingest data from Accurate for a given date$")
	public void i_should_to_be_able_to_ingest_data_from_Accurate_for_a_given_date() throws Throwable {
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
		util1.switchcreatemanualcase();
		util1.sizeofingesteddata(yesterdaydate);
	}

	@When("^I should to be able to ingest data from ORP for a given date$")
	public void i_should_to_be_able_to_ingest_data_from_ORP_for_a_given_date() throws Throwable {
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
		util1.switchcreatemanualcase();
		util1.sizeofingesteddata(yesterdaydate);
	}
	
	@After("@DataIngestion")
	public void teardown() throws InterruptedException {

		util.teardown();
	}

	
	
	

}