package com.moodys.qats.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moodys.qats.page.QATS_HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QATS_LoginPage {
	
	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id='txtUserID']")
	WebElement Username;

	@FindBy(xpath = "//*[@id='txtPassword']")
	WebElement Password;

	@FindBy(xpath = "//*[@id='sub']")
	WebElement Login;

	public QATS_LoginPage(WebDriver driver){
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
	}

	public String LoginPageTitle() {

		return driver.getTitle();

	}

	public QATS_HomePage Login(WebDriver driver, String username, String password) throws InterruptedException, IOException {

		Username.sendKeys(username);
		Password.sendKeys(password);

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sub']")));
		Login.click();
		
		return new QATS_HomePage(driver);
		
	}

}
