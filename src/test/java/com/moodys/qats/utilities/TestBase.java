package com.moodys.qats.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

	public Properties prop;

	public WebDriver driver;

	
	public  Properties initialization() throws Exception {
		String ENV_VAR1 = Optional.ofNullable(System.getProperty("ENV_VAR1")).orElseThrow(
				() -> new Exception("ENV_VAR1 is not set in the environment"));

		String path = "src/test/resources/"+ENV_VAR1+"/Config.Properties";
//		String path = "src/test/resources/Config.Properties";
		System.out.println(path);
		FileInputStream ip = new FileInputStream(
				path);
		prop = new Properties();

		prop.load(ip);
		return prop;

		
	}
	
	public WebDriver launchthebrowser(){
		
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/Driver/chromedriver.exe");
		/* Launching the browser? */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1920,1080");
		driver = new ChromeDriver(options);
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		return driver;
	}
}
