package com.moodys.qats.page;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.moodys.qats.utilities.ReviewDueDateCalculator;

public class MyWork {
    QATS_HomePage homepage;

    WebDriver driver;

    public MyWork(WebDriver driver) {

        this.driver = driver;


    }

    public void selectuploadvitalrecordsreviewcase() throws InterruptedException, IOException {


     
            for (int y = 0; y < 20; y++) {
                try {
                    driver.switchTo().frame("PegaGadget" + y + "Ifr");
                    driver.findElement(By.xpath("//div[text()='Assignment Task']/following::a[@id='pui_filter']")).click();

                    break;
                } catch (Exception e) {
                    driver.switchTo().defaultContent();
                    continue;
                }
            }
        

       
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
    
    public void diaplaynewlycreatedcasebulkassignments(String actionid) throws InterruptedException{
    	 for (int y = 0; y < 20; y++) {
             try {
                 driver.switchTo().frame("PegaGadget" + y + "Ifr");
                 driver.findElements(By.xpath("//div[contains(text(),'Action/Shell')]/following::a[@id='pui_filter']")).get(0)
                 .click();

                 break;
             } catch (Exception e) {
                 driver.switchTo().defaultContent();
                 continue;
             }
         }

        
         Thread.sleep(3000);

         if (driver.getTitle().equals("QA Admin")) {
             //driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).clear();
             //driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).sendKeys(actionid);
         	driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_AssignPage_pxResults_BulkReviewAssignments_1$ppyColumnFilterCriteria$gRatingActionID5$ppySearchText']")).clear();
         	driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_AssignPage_pxResults_BulkReviewAssignments_1$ppyColumnFilterCriteria$gRatingActionID5$ppySearchText']")).sendKeys(actionid);
         }
         if (driver.getTitle().equals("QA Manager")) {
             driver.findElement(By
                     .xpath("//input[@name='$PpyFilterCriteria_AssignPage_pxResults_BulkReviewAssignments_1$ppyColumnFilterCriteria$gRatingActionID5$ppySearchText']"))
                     .clear();
             driver.findElement(By
                     .xpath("//input[@name='$PpyFilterCriteria_AssignPage_pxResults_BulkReviewAssignments_1$ppyColumnFilterCriteria$gRatingActionID5$ppySearchText']")).sendKeys(actionid);
                    
         }
         if (driver.getTitle().equals("QA Reviewer")) {
             driver.findElement(By
                     .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBB_pxResults_Worklist_2$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                     .clear();
             driver.findElement(By
                     .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBB_pxResults_Worklist_2$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                     .sendKeys(actionid);
         }

         driver.findElement(By.xpath("//button[text()='Apply']")).click();
         Thread.sleep(3000);
        // Actions actions = new Actions(driver);
         //WebElement from= driver.findElements(By.xpath("//img[@src='webwb/px-explorer-drag-icon.png']")).get(0);
         //WebElement to =driver.findElement(By.xpath("//span[@data-name='Akanksha Sahu (User)']"));
        //actions.clickAndHold(from).moveToElement(to).pause(Duration.ofMillis(4000)).release().pause(Duration.ofMillis(2000)).build().perform();
       
        //actions.clickAndHold(driver.findElements(By.xpath("//img[@src='webwb/px-explorer-drag-icon.png']")).get(0)).moveToElement(driver.findElement(By.xpath("//span[@data-name='Akanksha Sahu (User)']"))).build().perform();
         
    }

    public void displaynewlycreatedreviewcase(String actionid) throws InterruptedException, IOException {
        //if (driver.getTitle().equals("QA Reviewer")) {
        	// driver.findElement(By.xpath("//span[text()='My Work']/parent::span/parent::a")).click();
        	 //Thread.sleep(2000);
        	//driver.switchTo().frame("PegaGadget2Ifr");
           
        //} else {
            //homepage = new QATS_HomePage(driver);
            //homepage.clickonDashboard();
        //}
        
        //for (int y = 0; y < 20; y++) {
          //  try {
            //    driver.switchTo().frame("PegaGadget" + y + "Ifr");
              //  driver.findElements(By.xpath("//div[contains(text(),'Action/Shell')]/following::a[@id='pui_filter']")).get(0)
                //.click();

               // break;
            //} catch (Exception e) {
              //  driver.switchTo().defaultContent();
                //continue;
            //}
        //}

       
        //Thread.sleep(4000);

        if (driver.getTitle().equals("QA Admin")) {
            driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).clear();
            driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).sendKeys(actionid);
        	//driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_AssignPage_pxResults_BulkReviewAssignments_1$ppyColumnFilterCriteria$gRatingActionID5$ppySearchText']")).clear();
        	//driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_AssignPage_pxResults_BulkReviewAssignments_1$ppyColumnFilterCriteria$gRatingActionID5$ppySearchText']")).sendKeys(actionid);
        }
        if (driver.getTitle().equals("QA Manager")) {
        	Thread.sleep(3500);
        	driver.navigate().refresh();
        	homepage = new QATS_HomePage(driver);
            homepage.clickonDashboard();
            Thread.sleep(3500);
        	driver.findElements(By.xpath("//div[contains(text(),'Action/Shell')]/following::a[@id='pui_filter']")).get(0)
            .click();
        	Thread.sleep(3500);
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']"))
                    .clear();
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).sendKeys(actionid);
                    
        }
        if (driver.getTitle().equals("QA Reviewer")) {
        	Thread.sleep(3500);
        	driver.navigate().refresh();
        	By mywork = By.xpath("//span[text()='My Work']");
        	driver.findElement(mywork).click();
        	Thread.sleep(3500);
        	driver.findElements(By.xpath("//div[contains(text(),'Action/Shell')]/following::a[@id='pui_filter']")).get(0)
            .click();
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBBB_pxResults_Worklist_3$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                    .clear();
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBBB_pxResults_Worklist_3$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                    .sendKeys(actionid);
           // driver.findElement(By
                    //.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBB_pxResults_Worklist_3$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                    //.sendKeys(actionid);
        }

        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        Thread.sleep(3000);
       // Actions actions = new Actions(driver);
        //WebElement from= driver.findElements(By.xpath("//img[@src='webwb/px-explorer-drag-icon.png']")).get(0);
        //WebElement to =driver.findElement(By.xpath("//span[@data-name='Akanksha Sahu (User)']"));
       //actions.clickAndHold(from).moveToElement(to).pause(Duration.ofMillis(4000)).release().pause(Duration.ofMillis(2000)).build().perform();
      
       //actions.clickAndHold(driver.findElements(By.xpath("//img[@src='webwb/px-explorer-drag-icon.png']")).get(0)).moveToElement(driver.findElement(By.xpath("//span[@data-name='Akanksha Sahu (User)']"))).build().perform();
        Thread.sleep(2000);

    }
    
    public void displaynewlycreatedreviewcasewithreviewduedateconfirmation(String actionid, String ratingactiondate, String analystloc) throws Exception {
        if (driver.getTitle().equals("QA Reviewer")) {
        	 driver.findElement(By.xpath("//span[text()='My Work']/parent::span/parent::a")).click();
        	 Thread.sleep(2000);
        	driver.switchTo().frame("PegaGadget2Ifr");
           
        } else {
            homepage = new QATS_HomePage(driver);
            homepage.clickonDashboard();
        }
        
        for (int y = 0; y < 20; y++) {
            try {
                driver.switchTo().frame("PegaGadget" + y + "Ifr");
                driver.findElements(By.xpath("//div[contains(text(),'Action/Shell')]/following::a[@id='pui_filter']")).get(0)
                .click();

                break;
            } catch (Exception e) {
                driver.switchTo().defaultContent();
                continue;
            }
        }

       
        Thread.sleep(4000);

        if (driver.getTitle().equals("QA Admin")) {
            driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).clear();
            driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']")).sendKeys(actionid);
        	//driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_AssignPage_pxResults_BulkReviewAssignments_1$ppyColumnFilterCriteria$gRatingActionID5$ppySearchText']")).clear();
        	//driver.findElement(By.xpath("//input[@name='$PpyFilterCriteria_AssignPage_pxResults_BulkReviewAssignments_1$ppyColumnFilterCriteria$gRatingActionID5$ppySearchText']")).sendKeys(actionid);
        }
        if (driver.getTitle().equals("QA Manager")) {
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']"))
                    .clear();
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionpyGroupBasketWorkB_pxResults_pyGroupBasketWork_1$ppyColumnFilterCriteria$gwrk_RatingActionID3$ppySearchText']"))
                    .sendKeys(actionid);
        }
        if (driver.getTitle().equals("QA Reviewer")) {
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBB_pxResults_Worklist_2$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                    .clear();
            driver.findElement(By
                    .xpath("//input[@name='$PpyFilterCriteria_pgRepPgSubSectionWorklistBB_pxResults_Worklist_2$ppyColumnFilterCriteria$gwrk_RatingActionID4$ppySearchText']"))
                    .sendKeys(actionid);
        }

        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        Thread.sleep(3000);
       // Actions actions = new Actions(driver);
        //WebElement from= driver.findElements(By.xpath("//img[@src='webwb/px-explorer-drag-icon.png']")).get(0);
        //WebElement to =driver.findElement(By.xpath("//span[@data-name='Akanksha Sahu (User)']"));
       //actions.clickAndHold(from).moveToElement(to).pause(Duration.ofMillis(4000)).release().pause(Duration.ofMillis(2000)).build().perform();
      
       //actions.clickAndHold(driver.findElements(By.xpath("//img[@src='webwb/px-explorer-drag-icon.png']")).get(0)).moveToElement(driver.findElement(By.xpath("//span[@data-name='Akanksha Sahu (User)']"))).build().perform();
        Thread.sleep(2000);
        
        ReviewDueDateCalculator calc = new ReviewDueDateCalculator();
       String revduedate=  calc.revduecalc(ratingactiondate,analystloc);
       
       driver.findElement(By.xpath("//span[text()='"+revduedate+"']")).getText();
        
        

    }
    
    

   

}