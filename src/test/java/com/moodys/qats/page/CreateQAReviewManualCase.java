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

	public void clickoncreatecase()  {

		driver.findElement(By.xpath("//button[text()='Create Case']")).click();
	}

	public void clickoncreatemanualcase() {
		driver.findElement(By.xpath("//button[text()='Create Manual Case']")).click();
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
