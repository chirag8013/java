package com.moodys.qats.utilities;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

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
	
	public String fourdaysbefratingrelcalc(String todaydate, String analystloca, String completedate){
		String today = todaydate.split("/")[1];
		System.out.println("Today is "+today);
		int datetoday = Integer.parseInt(today);
		int fourdaysbefore = datetoday - 4;
		Calendar calender = Calendar.getInstance(TimeZone.getDefault());
		
		
		//getting DayNumber of week like Sunday-1, Monday-2
		int dayofweek= calender.get(Calendar.DAY_OF_WEEK);
		System.out.println("Day of the week is "+dayofweek);
		int flag=0,rep=0;
		for(int d= dayofweek-1; d>=-4;d--){	
			flag++;
			if(d<=1){
				rep++; 
				fourdaysbefore=fourdaysbefore-1;			
			}
			if(flag==4&&d==1){
				fourdaysbefore=fourdaysbefore-1;
			}
			if(flag==4||rep==2){
				break;
			}
		}
		
		Reader read = new Reader();
		int holidaycount= read.getrowcount();
		List<Integer> dates = read.getholidaydates();
		List<String> months= read.getholidaymonths();
		List<String> years= read.getholidayyears();
		List<String> daysofweek= read.getholidaydayofweek();
		List<String> regionids= read.getregionid();
		List<String> countryids= read.getcountryid();
		
		
		
		LocalDate currentdate= LocalDate.now();
		Month month= currentdate.getMonth();
		int year= currentdate.getYear();
		int previousyear = year-1;
		String prevyear= Integer.toString(previousyear);
		Month previousmonth= month.minus(1);
		String prevmonth= previousmonth.toString();
		System.out.println("Prev month and year"+prevmonth+prevyear);
		String countryid = null,regionid = null;
		
		Reader2 read2= new Reader2();
		List<String> analystloc= read2.getanalystlocation();
		for(int i=0;i<read2.getrowcount()-1;i++){
			if(analystloc.get(i).equals(analystloca)){
				countryid=read2.getcountryid().get(i);
				regionid=read2.getregionid().get(i);
				break;
			}
		}
		
		System.out.println(countryid+" "+regionid);
		
		
		//read.readexcel();
		
		
	System.out.println("Four days before date with NO holiday in between-----------> "+fourdaysbefore);

	for(int i=2; i<holidaycount-2;i++){

		if(dates.get(i)==31&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&(years.get(i).contains(completedate.split("/")[2]))){
			
			
			fourdaysbefore=fourdaysbefore-1;
		
			

	}

	if(dates.get(i)==30&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}


	if(dates.get(i)==30&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}
	if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;
	}
	if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;
	}

	if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}
	if(dates.get(i)==25&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&!completedate.split("/")[0].equalsIgnoreCase("January")&&!completedate.split("/")[0].equalsIgnoreCase("March")&&years.get(i).contains(completedate.split("/")[2])){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}



		if(dates.get(i)==31&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&(years.get(i).contains(prevyear))){
			
			
			fourdaysbefore=fourdaysbefore-1;
		
			

	}

	if(dates.get(i)==30&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}


	if(dates.get(i)==30&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}
	if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;
	}
	if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;
	}

	if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}
	if(dates.get(i)==25&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("January")&&years.get(i).contains(prevyear)){
		
		
		fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==29&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){
		
		
		fourdaysbefore=fourdaysbefore-1;

		

	}

	if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=0&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}


	if(dates.get(i)==28&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}
	if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-1&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==27&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-2&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==26&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;
	}
	if(dates.get(i)==25&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-3&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;
	}

	if(dates.get(i)==25&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==24&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-4&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}

	if(dates.get(i)==24&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}
	if(dates.get(i)==23&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-5&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")&&completedate.split("/")[0].equalsIgnoreCase("March")){


	fourdaysbefore=fourdaysbefore-1;

	}
			
			//if((dates.get(i)==30||dates.get(i)==29)&&months.get(i).contains(prevmonth)&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&fourdaysbefore<=-1&&daysofweek.get(i)!="Sunday"&&daysofweek.get(i)!="Saturday"){
				//if(dates.get(i)>=fourdaysbefore&&((months.get(i).contains(completedate.split("/")[0])&&years.get(i).contains(completedate.split("/")[2]))||(months.get(i).contains(prevmonth)&&years.get(i).contains(prevyear))||(months.get(i).contains(prevmonth)&&years.get(i).contains(completedate.split("/")[2])))){
					//fourdaysbefore=fourdaysbefore-1;
				//}
				//fly=1;
				//break;
			//}
			
			
			
			
			if(dates.get(i)>=fourdaysbefore&&dates.get(i)<Integer.parseInt(completedate.split("/")[1])&&regionids.get(i).equalsIgnoreCase(regionid)&&countryids.get(i).equalsIgnoreCase(countryid)&&months.get(i).contains(completedate.split("/")[0])&&years.get(i).contains(completedate.split("/")[2])&&!daysofweek.get(i).equals("Sunday")&&!daysofweek.get(i).equals("Saturday")){
				fourdaysbefore=fourdaysbefore-1;
			}
			
			
			
			
				
		}

	if(dayofweek==6&&(Integer.parseInt(completedate.split("/")[1])-fourdaysbefore)>4){
		fourdaysbefore=fourdaysbefore-2;
	}

	if(dayofweek==2&&(Integer.parseInt(completedate.split("/")[1])-fourdaysbefore)>7){
		fourdaysbefore=fourdaysbefore-2;
	}
		
		

		String fourdaysbeforedate = Integer.toString(fourdaysbefore);
		
		
		
		
		
	 System.out.println("Four days before date with holiday in between-----------> "+fourdaysbefore);
	 return fourdaysbeforedate;
	}

}
