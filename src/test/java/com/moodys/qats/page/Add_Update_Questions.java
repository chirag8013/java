package com.moodys.qats.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Add_Update_Questions {
	
	WebDriver driver;
	public Add_Update_Questions(WebDriver driver){
		
		this.driver=driver;
	}
	
	public void addaquestion(String sectionname,String questionid,String questiondescription,String observationtext) throws InterruptedException{
		
		driver.findElement(By.xpath("//a[text()='Add item']")).click();
		Select sel = new Select(driver.findElement(By.xpath("//td[@data-attribute-name='Section Name']/div/select")));
		sel.selectByVisibleText(sectionname);
		driver.findElement(By.xpath("//td[@data-attribute-name='Question ID']/div/span/input")).sendKeys(questionid);
		driver.findElement(By.xpath("//td[@data-attribute-name='Question Description']/div/span/span/textarea")).sendKeys(questiondescription);
		driver.findElement(By.xpath("//td[@data-attribute-name='Observation Text']/div/span/span/textarea")).sendKeys(observationtext);
		Thread.sleep(3500);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3500);
		
	}
	
	public void updateaquestion(String sectionname, String questionid,String updatedquesdesc,String updatedobservationtext,String activestatus) throws InterruptedException{
		
		Select sel1 = new Select(driver.findElement(By.xpath("//label[text()='Section Name']/following-sibling::div/select")));
		sel1.selectByVisibleText(sectionname);
		Thread.sleep(3500);
		Select sel2= new Select(driver.findElement(By.xpath("//label[text()='Question ID']/following-sibling::div/select")));
		sel2.selectByVisibleText(questionid);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(3500);
		Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.xpath("//td[@data-attribute-name='Question Description']/div/span"))).doubleClick().build().perform();
	    Thread.sleep(3500);
	    driver.findElement(By.xpath("//label[text()='QuestionDesc']/following-sibling::div/span/span/textarea")).clear();
	    driver.findElement(By.xpath("//label[text()='QuestionDesc']/following-sibling::div/span/span/textarea")).sendKeys(updatedquesdesc);
	    driver.findElement(By.xpath("//label[text()='Observation Text']/following-sibling::div/span/span/textarea")).clear();
	    driver.findElement(By.xpath("//label[text()='Observation Text']/following-sibling::div/span/span/textarea")).sendKeys(updatedobservationtext);
	    Select sel3= new Select(driver.findElement(By.xpath("//label[text()='Active Flag']/following-sibling::div/select")));
	    sel3.selectByVisibleText(activestatus);
	    Thread.sleep(3500);
	    driver.findElement(By.xpath("//button[text()='  Submit ']")).click();
	}

}
