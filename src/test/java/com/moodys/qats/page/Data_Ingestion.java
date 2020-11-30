package com.moodys.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Data_Ingestion {

	WebDriver driver;

	public Data_Ingestion(WebDriver driver) {

		this.driver = driver;
	}

	public void ondemandataingestion(String sourcesystem, String daybeforetodaydate) throws InterruptedException {

		Select sel = new Select(
				driver.findElement(By.xpath("//label[text()='Source System']/following-sibling::div/select")));
		sel.selectByVisibleText(sourcesystem);
		driver.findElement(By.xpath("//label[text()='Rating Release Date']/following-sibling::div/span/img")).click();
		Thread.sleep(3500);
		driver.findElement(By.xpath("//a[@data-day='" + daybeforetodaydate + "']")).click();
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(3500);
		for (int i = 1; i < 500; i++) {

			try {
				if (driver.findElement(By.xpath("//span[text()='Data ingestion has been completed']")).isDisplayed()) {

					break;

				}
			} catch (Exception e) {
				if (driver
						.findElement(By.xpath("//span[text()='Data has been already ingested for the selected date']"))
						.isDisplayed()) {
					break;
				} else {
					Thread.sleep(3500);
					continue;
				}
			}

		}

	}
}
