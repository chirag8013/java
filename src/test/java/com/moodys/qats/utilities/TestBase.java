package com.moodys.qats.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public Properties prop;

	public WebDriver driver;

	public  Properties initialization() throws IOException{
		FileInputStream ip = new FileInputStream(
				"src/test/resources/Config.Properties");
		prop = new Properties();

		prop.load(ip);
		return prop;
	}
	
	public WebDriver launchthebrowser(){
		
		//System.setProperty("webdriver.chrome.driver",
				//System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
		/* Launching the browser? */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless", "window-size=1920,1080");

		driver = new ChromeDriver(options);

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		return driver;
	}
}
