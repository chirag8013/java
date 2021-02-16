package com.moodys.qats.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

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
import com.moodys.qats.utilities.Reader;
import com.moodys.qats.utilities.TestBase;
import com.moodys.qats.utilities.Util;
import com.moodys.qats.utilities.Util1;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Manager {
	
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
	
	@When("^Log into QATS Application as a Manager$")
	public void log_into_QATS_Application_as_a_Manager() throws Throwable {
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
	
	@Then("^Manager enter MeerQATS HomePage$")
	public void manager_enter_MeerQATS_HomePage() throws Throwable {
		String homepagetitle = homepage.HomePageTitle();
		log.info("----------------------------------");
		log.info(homepage.HomePageTitle());
		Assert.assertEquals(homepagetitle, "QA Manager");
		log.info("HomePage Title Verified as expected- " + homepagetitle);
		log.info("----------------------------------");
	}
	
	@When("^a manager goes to Create QA Review$")
	public void a_manager_goes_to_Create_QA_Review() throws Throwable {
		homepage.clickonQAReview();
		driver.navigate().refresh();
		Thread.sleep(9000);

		util1.switchcreatemanualcase();
		Thread.sleep(3000);
	}

	@When("^selects Review Case$")
	public void selects_Review_Case() throws Throwable {
		List<WebElement> ls = createcase.CreateCase_CheckBoxList();
		ls.get(0).click();

		actionid = createcase.getactionidoffirstcase();
		Thread.sleep(3000);

	}

	@When("^Create Case$")
	public void Create_Case() throws Throwable {
		createcase.clickoncreatecase();
	}

	@Then("^Manager can search for Case Id in Dashboard to validate successful case creation$")
	public void manager_can_search_for_Case_Id_in_Dashboard_to_validate_successful_case_creation() throws Throwable {
		homepage.gobacktodashboard();

		Thread.sleep(2000);
		mywork.displaynewlycreatedreviewcase(actionid);
	}
	
	@When("^Create Manual Case with actionid \"([^\"]*)\" and CaseDesc \"([^\"]*)\" and sourcename \"([^\"]*)\" and leadanalyst \"([^\"]*)\" and ratingactiondate \"([^\"]*)\"$")
	public void Create_Manual_Case_with_actionid_and_CaseDesc_and_sourcename_and_leadanalyst_and_ratingactiondate(String actionid, String CaseDesc, String sourcename, String leadanalyst, String ratingactiondate) throws Throwable {
		createcase.clickoncreatemanualcase();
		createcase.createmanualcasewithdate(actionid, CaseDesc, sourcename, leadanalyst, ratingactiondate,prop.getProperty("analystloc"));
		createcase.clickoncreatecase();
	}
	
	@Then("^Search for Case Id in Dashboard to validate successful case creation with actionid \"([^\"]*)\" and confirms the correct review due date for ratingactiondate \"([^\"]*)\" and analystlocation \"([^\"]*)\"$")
	public void search_for_Case_Id_in_Dashboard_to_validate_successful_case_creation_with_actionid_and_confirms_the_correct_review_due_date_for_ratingactiondate_and_analystlocation(String ACTIONID, String ratingactiondate, String analystloc) throws Throwable {
		homepage.clickonDashboard();
		mywork.displaynewlycreatedreviewcasewithreviewduedateconfirmation(ACTIONID, ratingactiondate,analystloc);
	}
	
	@When("^Manager Goes to Dashboard$")
	public void manager_Goes_to_Dashboard() throws Throwable {
		homepage.clickonDashboard();

		Thread.sleep(2000);
	}

	@Then("^Manager goes to Quality Review Work Queue and validate case status for any case$")
	public void manager_goes_to_Quality_Review_Work_Queue_and_validate_case_status_for_any_case() throws Throwable {
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
	
	@When("^manager Create Manual Case with the Rating Release Date four days before from current date with case id \"([^\"]*)\"$")
	public void manager_Create_Manual_Case_with_the_Rating_Release_Date_four_days_before_from_current_date_with_case_id(String ACTIONID) throws Throwable {
		createcase.clickoncreatemanualcase();
		String today = todaydate.split("/")[1];
		System.out.println("Today is "+today);
		datetoday = Integer.parseInt(today);
		int fourdaysbefore = datetoday - 4;
		Calendar calender = Calendar.getInstance(TimeZone.getDefault());
		
		//getting DayNumber of week like Sunday-1, Monday-2
		int dayofweek= calender.get(Calendar.DAY_OF_WEEK);
		System.out.println("Day of the week is "+dayofweek);
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
		
		Reader read = new Reader();
		int holidaycount= read.getrowcount();
		List<Integer> dates = read.getholidaydates();
		List<String> months= read.getholidaymonths();
		List<String> years= read.getholidayyears();
		
		System.out.println("Four days before date with no holiday "+fourdaysbefore);
		
		//for(int i=1; i<=holidaycount;i++){
			//if(Integer.parseInt(dates.get(i))>=fourdaysbefore&&Integer.parseInt(completedate.split("/")[1])>Integer.parseInt(dates.get(i))&&months.get(i).equals(completedate.split("/")[0])&&years.get(i).equals(completedate.split("/")[2])&&dayofweek!=1&&dayofweek!=7){
				//fourdaysbefore=fourdaysbefore-1;
			//}
		//}
		
		String fourdaysbeforedate = Integer.toString(fourdaysbefore);
		
		
		
		System.out.println("four days before date is --------------------> " + fourdaysbeforedate);
		createcase.createmanualcasewithdate(ACTIONID, prop.getProperty("CaseDesc"),
				prop.getProperty("Sourcename"), prop.getProperty("LeadAnalyst"), fourdaysbeforedate,prop.getProperty("analystloc"));
		createcase.clickoncreatecase();
				
	}

	@Then("^manager with CaseId \"([^\"]*)\" searches the case available for Day(\\d+) Review$")
	public void manager_with_CaseId_searches_the_case_available_for_Day_Review(String ActionID, int arg2) throws Throwable {
		homepage.gobacktoDay4Review(ActionID,"QualityReview");
	}
	
	@When("^Manager goes to MyWork and Search for Upload Vital Record Case$")
	public void manager_goes_to_MyWork_and_Search_for_Upload_Vital_Record_Case() throws Throwable {
		homepage.userclicksonmywork(driver);
	}

	@When("^on Selecting a Review Case$")
	public void on_Selecting_a_Review_Case() throws Throwable {
		mywork.selectuploadvitalrecordsreviewcase();
	}

	@Then("^Manager completes the questionnaire under QRS and submit$")
	public void manager_completes_the_questionnaire_under_QRS_and_submit() throws Throwable {
		util.PerformQuestionnaire();
	}
	
	@Then("^Search for Case Id in Dashboard to validate successful case creation with actionid \"([^\"]*)\"$")
	public void search_for_Case_Id_in_Dashboard_to_validate_successful_case_creation_with_actionid(String ACTIONID) throws Throwable {
		homepage.clickonDashboard();
		mywork.displaynewlycreatedreviewcase(ACTIONID);
	}
	
	@When("^Create Manual Case with actionid \"([^\"]*)\" and CaseDesc \"([^\"]*)\" and sourcename \"([^\"]*)\" and leadanalyst \"([^\"]*)\" and completeratingactiondate \"([^\"]*)\" and analystlocation \"([^\"]*)\"$")
	public void create_Manual_Case_with_actionid_and_CaseDesc_and_sourcename_and_leadanalyst_and_completeratingactiondate_and_analystlocation(String actionid, String CaseDesc, String sourcename, String leadanalyst, String ratingactiondate, String analystloca) throws Throwable {
		createcase.clickoncreatemanualcase();
		createcase.createmanualcasewithcompletedate(actionid, CaseDesc, sourcename, leadanalyst, ratingactiondate,analystloca);
		createcase.clickoncreatecase();
	}
	
	@After("@Manager")
	public void teardown() throws InterruptedException {

		util.teardown();
	}
	
	




}
