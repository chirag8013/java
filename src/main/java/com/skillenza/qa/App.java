package com.skillenza.qa;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App
{
    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver","/path/to/chrome_driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://return-order-app.herokuapp.com/";
        driver.get(baseUrl);



        WebElement result_div=driver.findElement(By.id("result"));

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
