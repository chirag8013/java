package com.moodys.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AdminUtils_SourceVsQATSMapping {
	WebDriver driver;
	Actions act;

	public AdminUtils_SourceVsQATSMapping(WebDriver driver) {

		this.driver = driver;

	}

	public void deletemappingofrecord(String sourcevalue) throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Source Value']//parent::div/parent::div/span/a[@id='pui_filter']"))
				.click();
       Thread.sleep(4000);
		driver.findElement(By.xpath("//label[contains(text(),'" + sourcevalue+ "')]/parent::td/preceding-sibling::td//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(2000);
		act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'" + sourcevalue + "')]"))).doubleClick()
				.build().perform();
Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();

	}

	public void mappingupdate(String sourcevalue, String qatsvalue) throws InterruptedException {

		Thread.sleep(1000);
		act = new Actions(driver);
		act.moveToElement(driver
				.findElements(By
						.xpath("//div[text()='Source Value']/following::span[contains(text(),'" + sourcevalue + "')]"))
				.get(0)).doubleClick().build().perform();
		Thread.sleep(4000);
		Select sel = new Select(
				driver.findElement(By.xpath("//label[contains(text(),'QATS Value')]/following-sibling::div/select")));
		Thread.sleep(1000);
		sel.selectByVisibleText(qatsvalue);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
	}

	public void clickonsubmittosave() throws InterruptedException {
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}

	public void clickonadditem() {
		driver.findElement(By.xpath("//a[text()='Add item']")).click();
	}

	public void selectsourceandqatsvalue(String sourceval, String qatsval, String domainname)
			throws InterruptedException {
		Select selsourceval, selqatsval;

		selsourceval = new Select(
				driver.findElement(By.xpath("//label[contains(text(),'Source Value')]/following-sibling::div/select")));

		Thread.sleep(1000);
		selsourceval.selectByVisibleText(sourceval);

		selqatsval = new Select(
				driver.findElement(By.xpath("//label[contains(text(),'QATS Value')]/following-sibling::div/select")));

		Thread.sleep(1000);
		selqatsval.selectByVisibleText(qatsval);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();

	}

}
