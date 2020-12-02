package com.moodys.qats.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateQAReviewManualCase {
	WebDriver driver;

	public CreateQAReviewManualCase(WebDriver driver) {

		this.driver = driver;

	}

	public void clickoncreatecase() throws InterruptedException  {


		Thread.sleep(3500);

		driver.findElement(By.xpath("//button[text()='Create Case']")).click();

		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		
		
		
	}

	public void clickoncreatemanualcase() {
		driver.findElement(By.xpath("//button[text()='Create Manual Case']")).click();
	}
	
	public void createmanualcasewithdate(String actid, String CaseDesc, String Source, String Leadanalystname, String todaydate)
			throws InterruptedException {
		
		

			driver.switchTo().defaultContent();
			for (int y = 0; y < 20; y++) {
				try {
					driver.switchTo().frame("PegaGadget" + y + "Ifr");
					driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pManualRatingAction$l1$pRatingActionID']"))
					.sendKeys(actid);

					break;
				} catch (Exception e) {
					driver.switchTo().defaultContent();
				}
			}
			Thread.sleep(2000);


	

		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pManualRatingAction$l1$pRatingActionDesc']"))
				.sendKeys(CaseDesc);

		Thread.sleep(1000);

		Select sel = new Select(driver
				.findElement(By.xpath("//select[@name='$PpyDisplayHarness$pManualRatingAction$l1$pSourceName']")));

		sel.selectByVisibleText(Source);

		System.out.println(Integer.parseInt(todaydate));
		driver.findElement(By.xpath("//label[contains(text(),'Rating Release Date')]/following-sibling::div//img"))
				.click();
		
		Thread.sleep(3500);
		
		if(Integer.parseInt(todaydate)==-1){
			driver.findElement(By.xpath("//span[@id='monthSpinner']/span/button[@class='spin-button spin-down']")).click();
			try {
				driver.findElement(By.xpath("//a[@data-day='31']")).getText();
					driver.findElement(By.xpath("//a[@data-day='30']")).click();
				
				} catch (Exception e) {
				driver.findElement(By.xpath("//a[@data-day='29']")).click();
			}
	}
		
		if(Integer.parseInt(todaydate)==-2){
			
			driver.findElement(By.xpath("//span[@id='monthSpinner']/span/button[@class='spin-button spin-down']")).click();
			try {
				driver.findElement(By.xpath("//a[@data-day='31']")).getText();
					driver.findElement(By.xpath("//a[@data-day='29']")).click();
				
				} catch (Exception e) {
				driver.findElement(By.xpath("//a[@data-day='28']")).click();
			}
	}
		
		if(Integer.parseInt(todaydate)==-3){
			
			driver.findElement(By.xpath("//span[@id='monthSpinner']/span/button[@class='spin-button spin-down']")).click();
			try {
				driver.findElement(By.xpath("//a[@data-day='31']")).getText();
					driver.findElement(By.xpath("//a[@data-day='28']")).click();
				
				} catch (Exception e) {
				driver.findElement(By.xpath("//a[@data-day='27']")).click();
			}
	}
		
		if(Integer.parseInt(todaydate)==-4){
			
			driver.findElement(By.xpath("//span[@id='monthSpinner']/span/button[@class='spin-button spin-down']")).click();
			try {
				driver.findElement(By.xpath("//a[@data-day='31']")).getText();
					driver.findElement(By.xpath("//a[@data-day='27']")).click();
				
				} catch (Exception e) {
				driver.findElement(By.xpath("//a[@data-day='26']")).click();
			}}
			
		
				
		if(Integer.parseInt(todaydate)==-5){
				
				driver.findElement(By.xpath("//span[@id='monthSpinner']/span/button[@class='spin-button spin-down']")).click();
				Thread.sleep(3500);
				try {
					driver.findElement(By.xpath("//a[@data-day='31']")).getText();
						driver.findElement(By.xpath("//a[@data-day='26']")).click();
					
					} catch (Exception e) {
					driver.findElement(By.xpath("//a[@data-day='25']")).click();
				}
				}
	
		
		if(Integer.parseInt(todaydate)>0){
			driver.findElement(By.xpath("//a[@data-day='"+todaydate+"']")).click();
		}
		
		
		driver.findElement(By.xpath("//label[text()='Lead Analyst Name']/following-sibling::div/input[@type='text']"))
		.sendKeys(Leadanalystname);
		//driver.findElement(By.xpath("//a[@class='today-link']")).click();

		
		}

	

	public void createmanualcase(String actid, String CaseDesc, String Source, String Leadanalystname)
			throws InterruptedException {
		if (driver.getTitle().equals("QA Manager")) {

			driver.switchTo().defaultContent();
			for (int y = 0; y < 20; y++) {
				try {
					driver.switchTo().frame("PegaGadget" + y + "Ifr");
					driver.findElement(By.xpath("//h2[text()='Create QA Review Case']")).click();

					break;
				} catch (Exception e) {
					driver.switchTo().defaultContent();
				}
			}
			Thread.sleep(2000);
		}

		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pManualRatingAction$l1$pRatingActionID']"))
				.sendKeys(actid);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@name='$PpyDisplayHarness$pManualRatingAction$l1$pRatingActionDesc']"))
				.sendKeys(CaseDesc);

		Thread.sleep(1000);

		Select sel = new Select(driver
				.findElement(By.xpath("//select[@name='$PpyDisplayHarness$pManualRatingAction$l1$pSourceName']")));

		sel.selectByVisibleText(Source);

		driver.findElement(By.xpath("//label[contains(text(),'Rating Release Date')]/following-sibling::div//img"))
				.click();

		driver.findElement(By.xpath("//a[@class='today-link']")).click();

		driver.findElement(By.xpath("//label[text()='Lead Analyst Name']/following-sibling::div/input[@type='text']"))
				.sendKeys(Leadanalystname);

		Thread.sleep(2000);
	}

	public List<WebElement> CreateCase_CheckBoxList() {
		// List<WebElement> ls=
		// driver.findElements(By.xpath("//input[@type='checkbox']//following::input[@type='checkbox']"));
		// return ls;
		return driver.findElements(By.xpath("//input[@type='checkbox']//following::input[@type='checkbox']"));
	}

	public String getactionidoffirstcase() throws InterruptedException {
		WebElement actionidwebelement = driver
				.findElements(By
						.xpath("//div[@class='gridHeaderLabel ']/following::td[@data-attribute-name='Action/Shell/RTG ID']/span"))
				.get(0);
		Actions act = new Actions(driver);
		act.moveToElement(actionidwebelement).doubleClick().build().perform();
		Thread.sleep(2000);
		return actionidwebelement.getText();

	}

	public String sortforregionandclickoncreatecase(String sourcevalue) throws InterruptedException {
		CreateQAReviewManualCase createcase = new CreateQAReviewManualCase(driver);

		driver.findElement(By.xpath("//div[@class='gridHeaderLabel ' and contains(text(),'Region')]//a[@role='menu']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Apply filter']")).click();
		Thread.sleep(1000);
		driver.findElement(By
				.xpath("//div[contains(text(),'" + sourcevalue + "')]/preceding-sibling::div//input[@type='checkbox']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Apply']")).click();

		Thread.sleep(3000);
		List<WebElement> ls = createcase.CreateCase_CheckBoxList();
		ls.get(0).click();

		String actionid = createcase.getactionidoffirstcase();
		Thread.sleep(3000);
		createcase.clickoncreatecase();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		return actionid;
	}

}
