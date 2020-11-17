package com.moodys.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class QualityReferenceSheet {

	WebDriver driver;

	public QualityReferenceSheet(WebDriver driver) {

		this.driver = driver;
	}

	public void clickonactionbutton() {
		driver.findElement(By.xpath("//img[@alt='Actions']")).click();
	}

	public void clickonupdatecasestatus() {
		driver.findElement(By.xpath("//span[text()='Update Case Status']")).click();
	}

	public void selectcasestatus(String casestatus) {

		Select sel = new Select(driver.findElement(By.xpath("//select[@name='$PpyWorkPage$pStatusList']")));
		sel.selectByVisibleText(casestatus);
	}

	public void clickoncontinueconfirm() {
		driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
	}
	
	public void clickonsubmit() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

}
