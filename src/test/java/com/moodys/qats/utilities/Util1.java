package com.moodys.qats.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util1 {
	WebDriver driver;
	public Util1(WebDriver driver){
		this.driver=driver;
	}
	
	public void switchcreatemanualcase(){
		for (int y = 0; y < 20; y++) {
			try {

				driver.switchTo().frame("PegaGadget" + y + "Ifr");
				//actionid = createcase.sortforregionandclickoncreatecase(sourcevalue);
				driver.findElement(By.xpath("//button[text()='Create Manual Case']")).getText();

				break;
			} catch (Exception e) {
				driver.switchTo().defaultContent();

				continue;
			}
		}
		
	}
	
	public void sizeofingesteddata(String yesterdaydate) throws InterruptedException{
		int size=0;
		List<WebElement> dateelement= driver.findElements(By.xpath("//td[@data-attribute-name='Rating Release Date']/span"));
		
		for(WebElement ele:dateelement){
			if(ele.getText().equals(yesterdaydate)){
				 size=size+1;
			}
			if(size==20){
		    driver.findElement(By.xpath("//a[@aria-label='Next Page']")).click();
		    Thread.sleep(3500);
			dateelement= driver.findElements(By.xpath("//td[@data-attribute-name='Rating Release Date']"));
			}
			
		}
		System.out.println("Size of the ingested data is: "+size);
	}
	
	public void assigncasetouser() throws InterruptedException{
		driver.findElement(By.xpath("//td[@data-attribute-name='Select']/div/input[@data-ctl='Checkbox']")).click();
		driver.findElement(By.xpath("//label[text()='Assigned To']/following-sibling::div/input")).sendKeys("Test@rqms");
		driver.findElement(By.xpath("//button[text()='Assign']")).click();
		Thread.sleep(4000);
		
	}

}
