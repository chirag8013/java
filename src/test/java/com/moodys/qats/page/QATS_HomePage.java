package com.moodys.qats.page;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		System.out.println(text);

	}

	public void clickonadminutils() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Admin Utils']/parent::span/parent::a")).click();
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

	public void selectDomainNameandclickonsearch(String domainName) throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//h2[text()='Mapping  QATS vs Source']")).click();
		Thread.sleep(2000);

		Select sel = new Select(driver.findElement(By.name("$PpyDisplayHarness$pMappingAttribute")));
		sel.selectByVisibleText(domainName);

		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(2000);

	}

	public void clickonDashboard() throws InterruptedException {

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//span[text()='Dashboard']/parent::span/parent::a")).click();
		Thread.sleep(3000);

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

		Thread.sleep(2000);
	}

	public void userclicksonmywork(WebDriver driver) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 10);

//		System.out.println(driver.findElement(By.xpath("//span[text()='My Work']")));

//		if(driver.findElements(By.xpath("//span[text()='My Work']")).size() == 0) {
//			System.out.println("my work isn't here ");
//			driver.navigate().refresh();
//		}

//		if(driver.findElement(By.xpath("//span[text()='My Work']")) != null) {
//			System.out.println("yes------------");
//			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//span[text()='My Work']")).click();
//		} else {
//			System.out.println("---------no");
//		}

//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Work']"))).click();


//		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//span[text()='My Work']/parent::span/parent::a")).click();
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
