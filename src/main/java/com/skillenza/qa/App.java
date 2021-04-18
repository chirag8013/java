package com.skillenza.qa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromee/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://return-order-app.herokuapp.com/";
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("1257945872");

		driver.findElement(By.xpath("//button[text()]")).click();
		Thread.sleep(3500);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scroll(0,4000)");

		Thread.sleep(3500);

		driver.findElement(By.xpath("//button[text()='Return This Product']")).click();
		driver.findElement(By.xpath("//button[text()='Return This Product']")).click();
		Thread.sleep(5000);

		WebElement result_div = driver.findElement(By.id("result"));

		String result_str = result_div.getText();

		try {
			FileWriter myWriter = new FileWriter("result.txt");
			myWriter.write(result_str);
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
