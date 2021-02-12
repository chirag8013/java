package com.moodys.qats.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AdminUtils_MaintainQATSValue {
	
	WebDriver driver;
	Actions act;

	public AdminUtils_MaintainQATSValue(WebDriver driver) {

		this.driver = driver;

	}
	
	
	
	public void selectqatsvalueandmakeactiveorinactiveandsubmit(String qatsvalue) throws InterruptedException{
		
		
		driver.findElement(By.xpath("//div[text()='QATS Value']/parent::div/following-sibling::span/a[@id='pui_filter']")).click();
		Thread.sleep(3500);
		
		driver.findElement(By.xpath("//label[text()='Search Text']/following-sibling::div/span/input")).sendKeys(qatsvalue);
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		Thread.sleep(3500);
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Yes' or text()='No']"))).doubleClick().build().perform();
		Thread.sleep(3500);
		
		String status = driver.findElement(By.xpath("//span[text()='Yes' or text()='No']")).getText();
		
		Thread.sleep(3500);
		Select sel = new Select(driver.findElement(By.xpath("//label[text()='Active']/following-sibling::div/select")));
		
		if(status.equals("Yes")){
			sel.selectByVisibleText("No");
		}else{
			sel.selectByVisibleText("Yes");
		}
		
		
		
		 driver.findElement(By.xpath("//span[text()='Country']/parent::label/following-sibling::div/span/input")).clear();
		  driver.findElement(By.xpath("//label[text()='Region']/following-sibling::div/span/input")).clear();
		
		 driver.findElement(By.xpath("//span[text()='Country']/parent::label/following-sibling::div/span/input")).sendKeys("US");
		  driver.findElement(By.xpath("//label[text()='Region']/following-sibling::div/span/input")).sendKeys("MA");
		  
		  Thread.sleep(3500);
		  
		
		driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
		driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
		
		Thread.sleep(3500);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
public void selectqatsvalueandmakeactiveorinactiveregionandsubmit(String qatsvalue) throws InterruptedException{
		
		
		driver.findElement(By.xpath("//div[text()='QATS Value']/parent::div/following-sibling::span/a[@id='pui_filter']")).click();
		Thread.sleep(3500);
		
		driver.findElement(By.xpath("//label[text()='Search Text']/following-sibling::div/span/input")).sendKeys(qatsvalue);
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		Thread.sleep(3500);
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Yes' or text()='No']"))).doubleClick().build().perform();
		Thread.sleep(3500);
		
		String status = driver.findElement(By.xpath("//span[text()='Yes' or text()='No']")).getText();
		
		Thread.sleep(3500);
		Select sel = new Select(driver.findElement(By.xpath("//label[text()='Active']/following-sibling::div/select")));
		
		if(status.equals("Yes")){
			sel.selectByVisibleText("No");
		}else{
			sel.selectByVisibleText("Yes");
		}
		
		
		
	
		  
		  Thread.sleep(3500);
		  
		
		//driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
		driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
		
		Thread.sleep(3500);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	public void selectdomain(String domainname) throws InterruptedException{
		Thread.sleep(3500);
		Select sel = new Select(driver.findElement(By.xpath("//label[contains(text(),'Domain Name')]/following-sibling::div/select")));
		sel.selectByVisibleText(domainname);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
	}
	
	
	public void selectdomainandclickonadd(String domainname){
		Select sel = new Select(driver.findElement(By.xpath("//label[contains(text(),'Domain Name')]/following-sibling::div/select")));
		sel.selectByVisibleText(domainname);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		driver.findElement(By.xpath("//a[text()='Add item']")).click();
	}
	
	public void addnewqatsvalueandsubmit(String qatsvalue) throws InterruptedException{
		
		for(int j=80;j<500;j++){
			try {
				String s=Integer.toString(j);
				driver.findElement(By.xpath("//label[text()='QATS Value']/following-sibling::div/span/input")).sendKeys(qatsvalue+" "+s);
				  
				  driver.findElement(By.xpath("//span[text()='Country']/parent::label/following-sibling::div/span/input")).sendKeys("US");
				  driver.findElement(By.xpath("//label[text()='Region']/following-sibling::div/span/input")).sendKeys("MA");
				  Thread.sleep(3500);
				  driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
				  driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
				  Thread.sleep(3500);
				  driver.findElement(By.xpath("//button[text()='Submit']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//label[text()='QATS Value']/following-sibling::div/span/input")).clear();
				 driver.findElement(By.xpath("//span[text()='Country']/parent::label/following-sibling::div/span/input")).clear();
				 driver.findElement(By.xpath("//label[text()='Region']/following-sibling::div/span/input")).clear();
				continue;
			}
			}
		
	}
	
public void addnewqatsvalueregionandsubmit(String qatsvalue) throws InterruptedException{
		
		for(int j=80;j<500;j++){
			try {
				String s=Integer.toString(j);
				driver.findElement(By.xpath("//label[text()='QATS Value']/following-sibling::div/span/input")).sendKeys(qatsvalue+" "+s);
				  
				  
				  Thread.sleep(3500);
				  driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
				 // driver.findElement(By.xpath("//button[@class='buttonTdButton' and contains(text(),'Submit')]")).click();
				  Thread.sleep(3500);
				  driver.findElement(By.xpath("//button[text()='Submit']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//label[text()='QATS Value']/following-sibling::div/span/input")).clear();
				
				continue;
			}
			}}
	
	

}
