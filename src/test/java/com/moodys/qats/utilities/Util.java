package com.moodys.qats.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {

	WebDriver driver;
	JavascriptExecutor Js;

	Boolean result = false;
	int limit = 0;

	public Util(WebDriver Driver) {
		this.driver = Driver;

	}

	public void teardown() throws InterruptedException {

		Thread.sleep(2000);

		if (driver.getTitle().equals("QA Manager")) {
			driver.switchTo().defaultContent();
		}
		if (driver.getTitle().equals("QA Admin")) {
			driver.switchTo().defaultContent();
		}

		driver.findElement(By.xpath(".//a[@class='Header_nav']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'Log of')]")).click();

		Thread.sleep(2000);

		driver.quit();
	}

	public void PerformQuestionnaire() throws InterruptedException {

		driver.switchTo().defaultContent();

		if (driver.getTitle().equals("QA Manager")) {
			driver.switchTo().frame("PegaGadget2Ifr");
		}

		for (int count = 0; count < 3; count++) {
			driver.findElements(By.xpath("//span[text()='Upload Vital Records']")).get(0).click();
			Thread.sleep(4000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					List<WebElement> ls1 = driver.findElements(By.xpath(
							"//span[text()='The Rating Committee Package was uploaded']//following::label[text()='Yes']"));

					for (int j = 0; j < ls1.size(); j++) {

						ls1.get(j).click();

					}
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
					break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					List<WebElement> ls2 = driver.findElements(By.xpath(
							"//span[contains(text(),'Rating Recommendation included')]//following::label[text()='Yes']"));

					for (int j = 0; j < ls2.size(); j++) {

						ls2.get(j).click();

					}
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);

			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
					break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					List<WebElement> ls3 = driver.findElements(By.xpath(
							"//span[contains(text(),'All Rating Committee participants are')]//following::label[text()='Yes']"));

					for (int j = 0; j < ls3.size(); j++) {

						ls3.get(j).click();

					}
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}

			Thread.sleep(2000);

			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
					break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					List<WebElement> ls4 = driver.findElements(By.xpath(
							"//span[contains(text(),'Methodology Rating Group approval email')]//following::label[text()='Yes']"));

					for (int j = 0; j < ls4.size(); j++) {

						ls4.get(j).click();

					}
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}

			Thread.sleep(2000);

			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
					break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					WebElement ls5=driver.findElement(By.xpath(
							"//span[contains(text(),'Rating Committee Chair eligible to chair per RPO RC Chair Approval list')]//following::label[text()='Yes']"));
					ls5.click();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}

			Thread.sleep(2000);
			
		

			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
					break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					List<WebElement> ls6 = driver.findElements(By.xpath(
							"//span[contains(text(),'Is the Lead Analyst correctly reflected')]//following::label[text()='Yes']"));

					for (int j = 0; j < ls6.size(); j++) {

						ls6.get(j).click();

					}
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}

			Thread.sleep(2000);

			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
					break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					continue;
				}
			}

			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					List<WebElement> ls7 = driver.findElements(By.xpath(
							"//span[contains(text(),'header and footer is unobstructed on Draft Press Release')]//following::label[text()='Yes']"));

					for (int j1 = 0; j1 < ls7.size(); j1++) {

						ls7.get(j1).click();

					}
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}

			Thread.sleep(2000);

			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
					break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					List<WebElement> ls8 = driver.findElements(By.xpath(
							"//span[contains(text(),'Key Factual Elements and Data Sources are present')]//following::label[text()='Yes']"));

					for (int j2 = 0; j2 < ls8.size(); j2++) {

						ls8.get(j2).click();

					}
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}

			Thread.sleep(2000);

			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					driver.findElement(By.xpath("//button[text()='Continue / Confirm']")).click();
					break;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					continue;
				}
			}
			Thread.sleep(2000);
			for (int repeat = 0; repeat < 1000; repeat++) {
				try {
					List<WebElement> ls9 = driver.findElements(By.xpath(
							"//span[contains(text(),'Final Rating Committee Outcome as noted')]//following::label[text()='Yes']"));

					for (int j = 0; j < ls9.size(); j++) {

						ls9.get(j).click();

					}
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					continue;
				}
			}

			Thread.sleep(2000);

		}

		for (int repeat = 0; repeat < 1000; repeat++) {
			try {
				driver.findElement(By.xpath("//button[text()='Complete Review']")).click();
				break;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				continue;
			}
		}

		Thread.sleep(4000);

	}
}
