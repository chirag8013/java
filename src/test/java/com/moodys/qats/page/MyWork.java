package com.moodys.qats.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyWork {
    QATS_HomePage homepage;

    WebDriver driver;

    public MyWork(WebDriver driver) {

        this.driver = driver;


    }

    public void selectuploadvitalrecordsreviewcase() throws InterruptedException, IOException {


        if (driver.getTitle().equals("QA Manager")) {
            for (int y = 0; y < 20; y++) {
                try {
                    driver.switchTo().frame("PegaGadget" + y + "Ifr");
                    driver.findElement(By.xpath("//h1[text()='My Work']")).click();

                    break;
                } catch (Exception e) {
                    driver.switchTo().defaultContent();
                    continue;
                }
            }
        }

        driver.findElement(By.xpath("//div[text()='Assignment Task']/following::a[@id='pui_filter']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[contains(text(),' Upload Vital Records')]/parent::td/preceding-sibling::td//input[@type='checkbox']"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        Thread.sleep(3000);
        driver.findElements(By.xpath("//h1[text()='My Work']/following::td[@data-attribute-name='QRS ID']/div/span/a"))
                .get(0).click();
        Thread.sleep(6000);
    }

    public void displaynewlycreatedreviewcase(String actionid) throws InterruptedException, IOException {
        if (driver.getTitle().equals("Create Manual QA Review")) {
            driver.findElement(By.xpath("//span[text()='My Work']/parent::span/parent::a")).click();
        } else {
            homepage = new QATS_HomePage(driver);
            homepage.clickonDashboard();
        }

        List<WebElement> elems = driver.findElements(By.xpath("//div[contains(text(),'Action/Shell')]/following::a[@id='pui_filter']"));

        if(!elems.isEmpty()) {
            elems.get(0).click();
        }
        Thread.sleep(4000);

        if (driver.getTitle().equals("QA Admin")) {
            driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).clear();
            driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).sendKeys(actionid);
        }
        if (driver.getTitle().equals("QA Manager")) {
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']"))
                    .clear();
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']"))
                    .sendKeys(actionid);
        }
        if (driver.getTitle().equals("Case Worker Worklist")) {
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBB_pxResults_Worklist_2$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                    .clear();
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBB_pxResults_Worklist_2$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                    .sendKeys(actionid);
        }

        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        Thread.sleep(3000);
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//td[@data-attribute-name='Region']/div"))).doubleClick().build().perform();
        Thread.sleep(3000);
    }

}
