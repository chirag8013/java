package com.moodys.qats.page;

import java.io.IOException;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

@Log4j2
public class QATS_HomePage {

	WebDriver driver;
	Dashboard dashboard;

	public QATS_HomePage(WebDriver driver) throws IOException {
		this.driver = driver;

		// TODO Auto-generated constructor stub
	}

	public String HomePageTitle() {

		return driver.getTitle();
	}

	public void clickonQAReview() {

		// old WebElement to click Create QA Review-not working now
		// driver.findElement(By.xpath("//span[text()='Create QA
		// Review']")).click();

		// new WebElement
		driver.findElement(By.xpath("//span[text()='Create QA Review']/parent::span/parent::a")).click();
		

	}

	public void clickonCreateManualCase() {

		driver.findElement(By.xpath("//span[text()='Create Manual Case']/parent::span/parent::a")).click();
	}

	public void clickonconfiguration() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Configuration']")).click();
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//div[text()='Application configuration']")).click();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}

		driver.findElement(By.xpath("//div[text()='Edit']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");

				break;
			} catch (Exception e) {
				continue;
			}
		}
		String text = driver.findElement(By.xpath("//nobr[text()='B1']//following::nobr")).getText();
		log.info(text);

	}

	public void clickonadminutils() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Admin Utils']/parent::span/parent::a")).click();
		Thread.sleep(3500);
	}

	public void clickoneditreviewdate() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Edit Review Date']/parent::span/parent::a")).click();
		Thread.sleep(2000);
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//label[text()='Analyst Location Code']")).click();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}

	}

	public void clickonmappingqatsvssource() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Mapping  QATS vs Source']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='Mapping  QATS vs Source']")).click();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}

	}
	
	public void clickonupdatequestions() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Update Questions']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='Search Questions']")).getText();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
		Thread.sleep(4000);

	}
	
	public void clickonupdateremediation() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Update Remediation']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='Search Remediation']")).getText();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
		Thread.sleep(4000);

	}
	
	public void clickonaddremediation() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Add Remediation']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='Add Remediation']")).click();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
		Thread.sleep(4000);

	}
	
	public void clickondataingestion() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Data Ingestion']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='On Demand Data Ingestion']")).getText();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
		Thread.sleep(4000);

	}
	
	
	public void clickonaddquestions() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Add Questions']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='Add Questions']")).click();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
		Thread.sleep(4000);

	}
	

	
	public void clickonmaintainqatsvalue() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Maintain QATS Values']")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='Maintain QATS Values']")).click();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
		Thread.sleep(4000);

	}

	public void selectDomainNameandclickonsearch(String domainName) throws InterruptedException {
		Thread.sleep(4000);

		driver.findElement(By.xpath("//h2[text()='Mapping  QATS vs Source']")).click();
		Thread.sleep(4000);

		Select sel = new Select(driver.findElement(By.name("$PpyDisplayHarness$pMappingAttribute")));
		sel.selectByVisibleText(domainName);

		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(2000);

	}

	public void clickonDashboard() throws InterruptedException {

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//span[text()='Dashboard']/parent::span/parent::a")).click();
		Thread.sleep(3000);

	driver.switchTo().frame(1);
	

		Thread.sleep(1000);
	}
	
	public void gobacktodashboardforbulkassignments() throws InterruptedException{
		
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//span[text()='Dashboard']/parent::span/parent::a")).click();
		Thread.sleep(2000);
		
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='Work baskets']")).click();
				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
		Thread.sleep(1000);
		
	}
	
public void gobacktodashboard() throws InterruptedException{
		
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//span[text()='Dashboard']/parent::span/parent::a")).click();
		Thread.sleep(2000);
		
		for (int y = 0; y < 20; y++) {
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h2[text()='Work baskets']")).getText();
				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
		Thread.sleep(1000);
		
	}
	

@SuppressWarnings("deprecation")
public void gobacktoDay4Review(String actionid, String user) throws Exception{
		
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//span[text()='Day 4 Review']/parent::span/parent::a")).click();
		Thread.sleep(2000);

		for (int y = 0; y < 20; y++) {
			try {

				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElements(By.xpath("//td[@data-attribute-name='Action ID']")).get(0).getText();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}

		Thread.sleep(1000);
		
		List<WebElement> actionids=driver.findElements(By.xpath("//td[@data-attribute-name='Action ID']"));
		List<WebElement> caseids= driver.findElements(By.xpath("//td[@data-attribute-name='Case ID']"));
		List<WebElement> assignedto = driver.findElements(By.xpath("//td[@data-attribute-name='Assigned To']"));
		for(int i=0;i<actionids.size();i++){
			
			if(actionids.get(i).getText().equals(actionid)){
				
				System.out.println("---------------Case is present in Day 4 review with QRS ID "+ caseids.get(i).getText()+ " and assigned to "+assignedto.get(i).getText()+" ------------------");		
			    Assert.assertEquals(assignedto.get(i).getText(), user);
			    
			}
			
			
		}
	}

	public void userclicksonmywork(WebDriver driver) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 10);

//		log.info(driver.findElement(By.xpath("//span[text()='My Work']")));

//		if(driver.findElements(By.xpath("//span[text()='My Work']")).size() == 0) {
//			log.info("my work isn't here ");
//			driver.navigate().refresh();
//		}

//		if(driver.findElement(By.xpath("//span[text()='My Work']")) != null) {
//			log.info("yes------------");
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//span[text()='My Work']")).click();
//		} else {
//			log.info("---------no");
//		}

//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Work']"))).click();


//		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='My Work']/parent::span/parent::a")).click();
//		Thread.sleep(2000);

		Thread.sleep(2000);
	}

	public void Editreviewdatefields(String AnalystLocCode, String RatingDate, String NewReviewDate)
			throws InterruptedException {

		driver.findElement(By.xpath("//input[@data-primary-value='.AnalystLocCode']")).click();
		driver.findElement(By.xpath("//input[@data-primary-value='.AnalystLocCode']")).sendKeys(AnalystLocCode);
		driver.findElement(By.xpath("//span[text()='" + AnalystLocCode + "']")).click();
		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pOldReviewDate2']")).sendKeys(RatingDate);
		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pNewReivewDate2']")).sendKeys(NewReviewDate);
		driver.findElement(By.xpath("//button[text()='Submit Update']")).click();
		Thread.sleep(7000);

	}

}
