package com.moodys.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Add_Update_Remediation {
	
	WebDriver driver;
	
	public Add_Update_Remediation(WebDriver driver){
		
		this.driver=driver;
	}
	
	public void addremediation(String sectionname,String question,String remediation){
		
		driver.findElement(By.xpath("//a[text()='Add item']")).click();
		Select sel1 = new Select(driver.findElement(By.xpath("//td[@data-attribute-name='Section Name']/div/select")));
		sel1.selectByVisibleText(sectionname);
        Select sel2= new Select(driver.findElement(By.xpath("//td[@data-attribute-name='Question']/div/div/select")));
        sel2.selectByVisibleText(question);
        driver.findElement(By.xpath("//td[@data-attribute-name='Remediation']/div/span/span/textarea")).clear();
        driver.findElement(By.xpath("//td[@data-attribute-name='Remediation']/div/span/span/textarea")).sendKeys(remediation);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
	}
	
public void updateremediation(String sectionname, String question,String updatedremediationtext) throws InterruptedException{
		
		Select sel1 = new Select(driver.findElement(By.xpath("//label[text()='Section Name']/following-sibling::div/select")));
		sel1.selectByVisibleText(sectionname);
		Thread.sleep(3500);
		Select sel2= new Select(driver.findElement(By.xpath("//label[text()='Question']/following-sibling::div/select")));
		sel2.selectByVisibleText(question);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(3500);
		Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.xpath("//td[@data-attribute-name='Remediation']/div/span"))).doubleClick().build().perform();
	    Thread.sleep(3500);
	    driver.findElement(By.xpath("//label[text()='Enter Remediation Text']/following-sibling::div/span/span/textarea")).clear();
	    driver.findElement(By.xpath("//label[text()='Enter Remediation Text']/following-sibling::div/span/span/textarea")).sendKeys(updatedremediationtext);
        driver.findElement(By.xpath("//button[text()='  Submit ']")).click();
	}

}
