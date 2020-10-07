package com.moodys.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
	WebDriver driver;

	public Dashboard(WebDriver driver) {

		this.driver = driver;
	}

	public void clickonworkbasket(String workbasket) throws InterruptedException {
Thread.sleep(2000);		
WebDriverWait wait= new WebDriverWait(driver,10);
WebElement Workbasket=driver.findElement(By.xpath("//span[@data-name='" + workbasket + "']"));
wait.until(ExpectedConditions.elementToBeClickable(Workbasket));
Workbasket.click();


	}

	public void clickonfirstcase() throws InterruptedException {
	

		driver.findElements(By.xpath("//div[text()='QRS ID']//following::a[contains(text(),'QRS')]")).get(0).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		for(int y=0;y<20;y++){
			try {
				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				driver.findElement(By.xpath("//h1[text()='Quality Reference Sheet']")).click();
				
				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		
	}
}
