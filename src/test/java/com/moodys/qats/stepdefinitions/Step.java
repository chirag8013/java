package com.moodys.qats.stepdefinitions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.moodys.qats.page.*;
import com.moodys.qats.utilities.Reader;
import com.moodys.qats.utilities.Reader2;
import com.moodys.qats.utilities.TestBase;
import com.moodys.qats.utilities.Util;
import com.moodys.qats.utilities.date_time;

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
	String todaydate,completedate;
	int datetoday;



@When("^Log into QATS Application as an Admin$")
public void log_into_QATS_Application_as_an_Admin() throws Throwable {
	base = new TestBase();
	prop = base.initialization();

	driver = base.launchthebrowser();

	util = new Util(driver);

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

@When("^I choose the Mapping QATS to Source from Admin Utils Menu$")
public void i_choose_the_Mapping_QATS_to_Source_from_Admin_Utils_Menu() throws Throwable {
	homepage.clickonadminutils();
	homepage.clickonmappingqatsvssource();
}

@When("^select DomainName \"([^\"]*)\" and click on Search button$")
public void select_DomainName_and_click_on_Search_button(String DomainName) throws Throwable {
	homepage.selectDomainNameandclickonsearch(DomainName);
}

@When("^change mapping of SourceValue \"([^\"]*)\" with QATSValue \"([^\"]*)\" and save changes$")
public void change_mapping_of_SourceValue_with_QATSValue_and_save_changes(String sourcevalue, String qatsvalue) throws Throwable {
	sourcevsqats.mappingupdate(sourcevalue, qatsvalue);
	sourcevsqats.clickonsubmittosave();
}




@When("^add a new source to qats mapping value by clicking on Add Item and selecting sourcevalue \"([^\"]*)\" and qatsvalue \"([^\"]*)\" for DomainName \"([^\"]*)\" from dropdown values$")
public void add_a_new_source_to_qats_mapping_value_by_clicking_on_Add_Item_and_selecting_sourcevalue_and_qatsvalue_for_DomainName_from_dropdown_values(String sourcevalue, String qatsvalue, String domainname) throws Throwable {
	sourcevsqats.clickonadditem();
	sourcevsqats.selectsourceandqatsvalue(sourcevalue, qatsvalue, domainname);
}

@When("^save the changes$")
public void save_the_changes() throws Throwable {
	sourcevsqats.clickonsubmittosave();
}

@Then("^I should be able to start using the newly created <QATSValue> on new cases$")
public void i_should_be_able_to_start_using_the_newly_created_QATSValue_on_new_cases() throws Throwable {
    
}


@When("^delete the first record with sourcevalue \"([^\"]*)\"$")
public void delete_the_first_record_with_sourcevalue(String sourcevalue) throws Throwable {
	sourcevsqats.deletemappingofrecord(sourcevalue);
}

@Then("^I should not be able to view QATSValue on new cases$")
public void i_should_not_be_able_to_view_QATSValue_on_new_cases() throws Throwable {
   
}

@Then("^I Should be able to start using the newly mapped QATSValue with SourceValue \"([^\"]*)\" on new case creation$")
public void i_Should_be_able_to_start_using_the_newly_mapped_QATSValue_on_new_case_creation(String sourcevalue) throws Throwable {
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
	
	homepage.clickonDashboard();

	Thread.sleep(2000);

	mywork.displaynewlycreatedreviewcase(actionid);

}


@When("^I choose menu option Maintain QATS Value from Admin Utilities$")
public void i_choose_menu_option_Maintain_QATS_Value_from_Admin_Utilities() throws Throwable {
    homepage.clickonadminutils();
    homepage.clickonmaintainqatsvalue();
}

@When("^Add DomainName \"([^\"]*)\" Click on Add Button$")
public void add_DomainName_Click_on_Add_Button(String domainname) throws Throwable {
	maintainqats.selectdomainandclickonadd(domainname);
}

@Then("^new QATSValue \"([^\"]*)\" is created$")
public void new_QATSValue_is_created(String qatsvalue) throws Throwable {
	maintainqats.addnewqatsvalueandsubmit(qatsvalue);
}

@When("^Admin clicks on Admin Utils and then Maintain QATS Value$")
public void admin_clicks_on_Admin_Utils_and_then_Maintain_QATS_Value() throws Throwable {
    homepage.clickonadminutils();
    homepage.clickonmaintainqatsvalue();
}

@When("^Admin selects a DomainName \"([^\"]*)\"$")
public void admin_selects_a_DomainName(String domain) throws Throwable {
	 maintainqats.selectdomain(domain);
}

@Then("^Admin change the status of QATSValue \"([^\"]*)\" Active or Inactive$")
public void admin_change_the_status_of_QATSValue_Active_or_Inactive(String qatsvalue) throws Throwable {
	maintainqats.selectqatsvalueandmakeactiveorinactiveandsubmit(qatsvalue);
}

@Given("^I am able to access the Edit Review Date button from Admin Utils Page$")
public void i_am_able_to_access_the_Edit_Review_Date_button_from_Admin_Utils_Page() throws Throwable {
	homepage.clickonadminutils();
	homepage.clickoneditreviewdate();
}

@Given("^Provide the AnalystLocation \"([^\"]*)\" and RatingDate \"([^\"]*)\" and NewReviewDate \"([^\"]*)\" and save changes$")
public void provide_the_AnalystLocation_and_RatingDate_and_NewReviewDate_and_save_changes(String AnalystLocCode, String RatingDate, String NewReviewDate) throws Throwable {
	homepage.Editreviewdatefields(AnalystLocCode, RatingDate, NewReviewDate);
}

@Then("^Review Date is updated to \"([^\"]*)\" for all the sorted cases$")
public void review_Date_is_updated_to_for_all_the_sorted_cases(String arg1) throws Throwable {
	log.info("Review date updated successfully");
}

@When("^I should to be able to ingest data from Pyramid for a given date$")
public void i_should_to_be_able_to_ingest_data_from_Pyramid_for_a_given_date() throws Throwable {
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
	System.out.println("Yesterday date was "+yesterdaydate);
	
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

@When("^I Create Manual Case with the Rating Release Date four days prior to current date with ActionID \"([^\"]*)\"$")
public void i_Create_Manual_Case_with_the_Rating_Release_Date_four_days_prior_to_current_date_with_ActionID(String ActionID) throws Throwable {
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
	
	createcase.clickoncreatemanualcase();
	String today = todaydate.split("/")[1];
	System.out.println("Today is "+today);
	int datetoday = Integer.parseInt(today);
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
	List<String> daysofweek= read.getholidaydayofweek();
	List<String> regionids= read.getregionid();
	List<String> countryids= read.getcountryid();
	
	
	
	LocalDate currentdate= LocalDate.now();
	Month month= currentdate.getMonth();
	int year= currentdate.getYear();
	int previousyear = year-1;
	String prevyear= Integer.toString(previousyear);
	Month previousmonth= month.minus(1);
	String prevmonth= previousmonth.toString();
	System.out.println("Prev month and year"+prevmonth+prevyear);
	String countryid = null,regionid = null;
	
	Reader2 read2= new Reader2();
	List<String> analystloc= read2.getanalystlocation();
	for(int i=2;i<read2.getrowcount()-1;i++){
		if(analystloc.get(i).equals(prop.getProperty("analystloc"))){
			countryid=read2.getcountryid().get(i);
			regionid=read2.getregionid().get(i);
			break;
		}
	}
	
	System.out.println(countryid+" "+regionid);
	
	
	//read.readexcel();
	
	
System.out.println("Four days before date with NO holiday in between-----------> "+fourdaysbefore);

for(int i=2; i<holidaycount-2;i++){

	if(dates.get(i)==31&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&(years.get(i).contains(completedate.split("/")[2]))){
		
		
		fourdaysbefore=fourdaysbefore-1;
	
		

}

if(dates.get(i)==30&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}


if(dates.get(i)==30&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}
if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;
}
if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;
}

if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}
if(dates.get(i)==25&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
	
	
	fourdaysbefore=fourdaysbefore-1;

}



	if(dates.get(i)==31&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&(years.get(i).contains(prevyear))){
		
		
		fourdaysbefore=fourdaysbefore-1;
	
		

}

if(dates.get(i)==30&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}


if(dates.get(i)==30&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}
if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;
}
if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;
}

if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}
if(dates.get(i)==25&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
	
	
	fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){
	
	
	fourdaysbefore=fourdaysbefore-1;

	

}

if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}


if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}
if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;
}
if(dates.get(i)==25&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;
}

if(dates.get(i)==25&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==24&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}

if(dates.get(i)==24&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}
if(dates.get(i)==23&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


fourdaysbefore=fourdaysbefore-1;

}
		
		//if((dates.get(i)==30||dates.get(i)==29)&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore==-1&&daysofweek.get(i)!="Sunday"&&daysofweek.get(i)!="Saturday"){
			//if(dates.get(i)>=fourdaysbefore&&((months.get(i).contains(completedate.split("/")[0])&&years.get(i).contains(completedate.split("/")[2]))||(months.get(i).contains(prevmonth)&&years.get(i).contains(prevyear))||(months.get(i).contains(prevmonth)&&years.get(i).contains(completedate.split("/")[2])))){
				//fourdaysbefore=fourdaysbefore-1;
			//}
			//fly=1;
			//break;
		//}
		
		
		
		
		if(dates.get(i)>=fourdaysbefore&&dates.get(i)<Integer.parseInt(completedate.split("/")[1])&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&months.get(i).contains(completedate.split("/")[0])&&years.get(i).contains(completedate.split("/")[2])&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&fourdaysbefore>0){
			fourdaysbefore=fourdaysbefore-1;
		}
	}
	
	

	String fourdaysbeforedate = Integer.toString(fourdaysbefore);
	
	
	
	
	
 System.out.println("Four days before date with holiday in between-----------> "+fourdaysbefore);
	createcase.createmanualcasewithdate(ActionID, prop.getProperty("CaseDesc"),
			prop.getProperty("Sourcename"), prop.getProperty("LeadAnalyst"), fourdaysbeforedate,prop.getProperty("analystloc"));
	createcase.clickoncreatecase();
}


@Then("^I should be able to search for the case with ActionID \"([^\"]*)\" on Day(\\d+) Review screen$")
public void i_should_be_able_to_search_for_the_case_with_ActionID_on_Day_Review_screen(String Actionid, int arg2) throws Throwable {
	homepage.gobacktoDay4Review(Actionid,"QualityReview");
}

@Then("^I should be able to search for the case with ActionID \"([^\"]*)\" and assign it to QATS User$")
public void i_should_be_able_to_search_for_the_case_with_ActionID_and_assign_it_to_QATS_User(String ACTIONID) throws Throwable {
	homepage.gobacktodashboardforbulkassignments();
	dashboard.clickonbulkassignments();
	Thread.sleep(2000);
	mywork.diaplaynewlycreatedcasebulkassignments(ACTIONID);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//td[@data-attribute-name='Select']/div/input[@data-ctl='Checkbox']")).click();
	driver.findElement(By.xpath("//label[text()='Assigned To']/following-sibling::div/input")).sendKeys("Test@rqms");
	driver.findElement(By.xpath("//button[text()='Assign']")).click();
	Thread.sleep(4000);
	
}

@When("^Log into QATS Application as a Manager$")
public void log_into_QATS_Application_as_a_Manager() throws Throwable {
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

@Then("^Search for Case Id in Dashboard to validate successful case creation with actionid \"([^\"]*)\"$")
public void search_for_Case_Id_in_Dashboard_to_validate_successful_case_creation_with_actionid(String ACTIONID) throws Throwable {
	homepage.clickonDashboard();
	mywork.displaynewlycreatedreviewcase(ACTIONID);
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

@When("^Log into QATS Application as a Reviewer$")
public void log_into_QATS_Application_as_a_Reviewer() throws Throwable {
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

@When("^Log off$")
public void log_off() throws Throwable {

	util.teardown();
}

@Then("^Manager assigns the case created to Reviewer$")
public void manager_assigns_the_case_created_to_Reviewer() throws Throwable {
    
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

@Then("^I should be able to search for the case with ActionID \"([^\"]*)\" and assign it to QATS User and confirms the same in Day four Review$")
public void i_should_be_able_to_search_for_the_case_with_ActionID_and_assign_it_to_QATS_User_and_confirms_the_same_in_Day_four_Review(String ACTIONID) throws Throwable {
	homepage.gobacktodashboardforbulkassignments();
	dashboard.clickonbulkassignments();
	Thread.sleep(2000);
	mywork.diaplaynewlycreatedcasebulkassignments(ACTIONID);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//td[@data-attribute-name='Select']/div/input[@data-ctl='Checkbox']")).click();
	driver.findElement(By.xpath("//label[text()='Assigned To']/following-sibling::div/input")).sendKeys("Test@rqms");
	driver.findElement(By.xpath("//button[text()='Assign']")).click();
	Thread.sleep(4000);
	homepage.gobacktoDay4Review(ACTIONID,"Test@rqms");
}

@Then("^I should be able to search for the case with ActionID <actionid> and assign it to QATS User$")
public void i_should_be_able_to_search_for_the_case_with_ActionID_actionid_and_assign_it_to_QATS_User() throws Throwable {
	homepage.gobacktodashboardforbulkassignments();
	dashboard.clickonbulkassignments();
	Thread.sleep(2000);
	mywork.diaplaynewlycreatedcasebulkassignments(actionid);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//td[@data-attribute-name='Select']/div/input[@data-ctl='Checkbox']")).click();
	driver.findElement(By.xpath("//label[text()='Assigned To']/following-sibling::div/input")).sendKeys("Test@rqms");
	driver.findElement(By.xpath("//button[text()='Assign']")).click();
	Thread.sleep(4000);
	
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



@After
public void teardown() throws InterruptedException {

	util.teardown();
}



}


