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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Admin {
	
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
	
	@Then("^new QATSValueforRegion \"([^\"]*)\" is created$")
	public void new_QATSValueforRegion_is_created(String qatsvalue) throws Throwable {
		//maintainqats.addnewqatsvalueandsubmit(qatsvalue);
		maintainqats.addnewqatsvalueregionandsubmit(qatsvalue);
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

@Then("^I Should be able to start using the newly mapped QATSValue with SourceValue \"([^\"]*)\" on new case creation$")
public void i_Should_be_able_to_start_using_the_newly_mapped_QATSValue_on_new_case_creation(String sourcevalue) throws Throwable {
	homepage.clickonQAReview();
	Thread.sleep(3000);
	util1.switchcreatemanualcase();

	

	Thread.sleep(3000);

	actionid = createcase.sortforregionandclickoncreatecase(sourcevalue);
	
	homepage.clickonDashboard();

	Thread.sleep(2000);

	mywork.displaynewlycreatedreviewcase(actionid);

}

@Then("^Admin change the status of Region QATSValue \"([^\"]*)\" Active or Inactive$")
public void admin_change_the_status_of_Region_QATSValue_Active_or_Inactive(String qatsvalue) throws Throwable {
	maintainqats.selectqatsvalueandmakeactiveorinactiveregionandsubmit(qatsvalue);
}


}
