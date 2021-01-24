package com.moodys.qats.utilities;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Properties;
import com.moodys.qats.utilities.*;



public class ReviewDueDateCalculator{
	
	String countryid,regionid;
	

	
    
	public String revduecalc(String ratingreldate,String analystloca) throws Exception{
		String ratingreleasedate= ratingreldate;
		
		String yeastr=ratingreleasedate.split("/")[2];
		
		
		int yea= Integer.parseInt(ratingreleasedate.split("/")[2]);
		int mon= Integer.parseInt(ratingreleasedate.split("/")[0]);
		int dat= Integer.parseInt(ratingreleasedate.split("/")[1]);
		
		String nextyear= Integer.toString(yea+1);

		date_time datetime= new date_time();
		int dow=datetime.getdayofweek(yea, mon, dat);
		int lastdateofmonth= datetime.getlastdayofmonth(yea, mon, dat);


			
			int reviewduedate= dat+5;
			int reviewduemonth=mon;
			
			if(dow==1){
				reviewduedate=reviewduedate+3;
			}
			
			if(dow==2||dow==3||dow==4||dow==5||dow==6){
				reviewduedate=reviewduedate+2;
			}
			
			if(dow==7){
				reviewduedate=reviewduedate+4;
			}
			
			Reader read = new Reader();
			int holidaycount= read.getrowcount();
			List<Integer> dates = read.getholidaydates();
			List<String> months= read.getholidaymonths();
			List<String> years= read.getholidayyears();
			List<String> daysofweek= read.getholidaydayofweek();
			List<String> regionids= read.getregionid();
			List<String> countryids= read.getcountryid();
			
			
			
			//TestBase base = new TestBase();
			//Properties prop = base.initialization();
			
			Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\Users/VermaC/Documents/ui/src/test/resources/qa/Config.Properties");
		prop.load(ip);
		
			
			
			Reader2 read2= new Reader2();
			List<String> analystloc= read2.getanalystlocation();
			for(int i=0;i<read2.getrowcount();i++){
				if(analystloc.get(i).equals(analystloca)){
					 countryid=read2.getcountryid().get(i);
					 regionid=read2.getregionid().get(i);
					break;
				}
			}
			
			System.out.println(countryid+" "+regionid);
			
			String monstr = null,nextmonth = null;
			
			if(mon==1){
				 monstr= "January";
				 nextmonth="February";
			}
			
			if(mon==2){
				 monstr= "February";
				 nextmonth="March";
			}
			
			if(mon==3){
				 monstr= "March";
				 nextmonth="April";
			}
			
			if(mon==4){
				 monstr= "April";
				 nextmonth="May";
			}
			
			if(mon==5){
				 monstr= "May";
				 nextmonth="February";
			}
			
			if(mon==6){
				 monstr= "June";
				 nextmonth="July";
			}
			
			if(mon==7){
				 monstr= "July";
				 nextmonth="August";
			}
			
			if(mon==8){
				 monstr= "August";
				 nextmonth="September";
			}
			
			if(mon==9){
				 monstr= "September";
				 nextmonth="October";
			}
			
			if(mon==10){
				 monstr= "October";
				 nextmonth="November";
			}
			
			if(mon==11){
				 monstr= "November";
				 nextmonth="December";
			}
			
			if(mon==12){
				 monstr= "December";
				 nextmonth="January";
			}
			
			for(int i=0;i<read.getrowcount()-10;i++){
				if(dates.get(i)>dat&&dates.get(i)<=reviewduedate&&reviewduedate<=30&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(monstr)&&!monstr.equalsIgnoreCase("February")&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)){
					reviewduedate=reviewduedate+1;
				}
				
if(dates.get(i)>dat&&dates.get(i)<=reviewduedate&&reviewduedate<=28&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(monstr)&&monstr.equalsIgnoreCase("February")&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&mon==2){
	reviewduedate=reviewduedate+1;
				}

if(dates.get(i)==31&&reviewduedate==31&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(monstr)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}


if(dates.get(i)==1&&reviewduedate==31&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==30){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==1&&reviewduedate==32&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==2&&reviewduedate==32&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==30){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==2&&reviewduedate==33&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==3&&reviewduedate==33&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==30){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==3&&reviewduedate==34&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==4&&reviewduedate==34&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==30){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==4&&reviewduedate==35&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==5&&reviewduedate==35&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==30){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==5&&reviewduedate==36&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==6&&reviewduedate==36&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==30){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==6&&reviewduedate==37&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==7&&reviewduedate==37&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==30){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==7&&reviewduedate==38&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&!(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==29&&reviewduedate==29&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(monstr)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==29){
	reviewduedate=reviewduedate+1;
}


if(dates.get(i)==1&&reviewduedate==29&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==28){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==1&&reviewduedate==30&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==29){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==2&&reviewduedate==30&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==28){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==2&&reviewduedate==31&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==29){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==3&&reviewduedate==31&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==28){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==3&&reviewduedate==32&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==29){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==4&&reviewduedate==32&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==28){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==4&&reviewduedate==33&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==29){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==5&&reviewduedate==33&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==28){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==5&&reviewduedate==34&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==29){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==6&&reviewduedate==34&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==28){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==6&&reviewduedate==35&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==29){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==7&&reviewduedate==35&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==28){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==7&&reviewduedate==36&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&(mon==2)&&!(mon==12)&&lastdateofmonth==29){
	reviewduedate=reviewduedate+1;
}

if(dates.get(i)==31&&reviewduedate==31&&years.get(i).contains(yeastr)&&months.get(i).equalsIgnoreCase(monstr)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}




if(dates.get(i)==1&&reviewduedate==32&&years.get(i).contains(nextyear)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}



if(dates.get(i)==2&&reviewduedate==33&&years.get(i).contains(nextyear)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}



if(dates.get(i)==3&&reviewduedate==34&&years.get(i).contains(nextyear)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}



if(dates.get(i)==4&&reviewduedate==35&&years.get(i).contains(nextyear)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}



if(dates.get(i)==5&&reviewduedate==36&&years.get(i).contains(nextyear)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}



if(dates.get(i)==6&&reviewduedate==37&&years.get(i).contains(nextyear)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}



if(dates.get(i)==7&&reviewduedate==38&&years.get(i).contains(nextyear)&&months.get(i).equalsIgnoreCase(nextmonth)&&countryids.get(i).equalsIgnoreCase(countryid)&&regionids.get(i).equalsIgnoreCase(regionid)&&!daysofweek.get(i).equalsIgnoreCase("Sunday")&&!daysofweek.get(i).equalsIgnoreCase("Saturday")&&!(mon==2)&&(mon==12)&&lastdateofmonth==31){
	reviewduedate=reviewduedate+1;
}









			}
			
			if(dow==6&&(reviewduedate-dat)>7){
				reviewduedate=reviewduedate+2;
			}
			
			if(dow==5&&(reviewduedate-dat)>8){
				reviewduedate=reviewduedate+2;
			}
			
			if(dow==4&&(reviewduedate-dat)>9){
				reviewduedate=reviewduedate+2;
			}
			
			if(dow==3&&(reviewduedate-dat)>10){
				reviewduedate=reviewduedate+2;
			}
			
			if(dow==2&&(reviewduedate-dat)>11){
				reviewduedate=reviewduedate+2;
			}
			
			if(dow==1&&(reviewduedate-dat)>12){
				reviewduedate=reviewduedate+2;
			}
			
			if(dow==7&&(reviewduedate-dat)>13){
				reviewduedate=reviewduedate+2;
			}
			
			
			
			
			
		
			if(reviewduedate==31&&lastdateofmonth==30&&!(mon==2)&&!(mon==12)){
				reviewduedate=1;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==32&&lastdateofmonth==30&&!(mon==2)&&!(mon==12)){
				reviewduedate=2;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==32&&lastdateofmonth==31&&!(mon==2)&&!(mon==12)){
				reviewduedate=1;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==33&&lastdateofmonth==30&&!(mon==2)&&!(mon==12)){
				reviewduedate=3;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==33&&lastdateofmonth==31&&!(mon==2)&&!(mon==12)){
				reviewduedate=2;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==34&&lastdateofmonth==31&&!(mon==2)&&!(mon==12)){
				reviewduedate=3;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==34&&lastdateofmonth==30&&!(mon==2)&&!(mon==12)){
				reviewduedate=4;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==35&&lastdateofmonth==31&&!(mon==2)&&!(mon==12)){
				reviewduedate=4;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==35&&lastdateofmonth==30&&!(mon==2)&&!(mon==12)){
				reviewduedate=5;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==36&&lastdateofmonth==31&&!(mon==2)&&!(mon==12)){
				reviewduedate=5;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==36&&lastdateofmonth==30&&!(mon==2)&&!(mon==12)){
				reviewduedate=6;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==37&&lastdateofmonth==31&&!(mon==2)&&!(mon==12)){
				reviewduedate=6;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==37&&lastdateofmonth==30&&!(mon==2)&&!(mon==12)){
				reviewduedate=7;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==29&&lastdateofmonth==28){
				reviewduedate=1;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==30&&lastdateofmonth==28){
				reviewduedate=2;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==30&&lastdateofmonth==29){
				reviewduedate=1;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==31&&lastdateofmonth==28){
				reviewduedate=3;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==31&&lastdateofmonth==29){
				reviewduedate=2;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==32&&lastdateofmonth==28){
				reviewduedate=3;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==32&&lastdateofmonth==29){
				reviewduedate=4;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==33&&lastdateofmonth==29){
				reviewduedate=4;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==33&&lastdateofmonth==28){
				reviewduedate=5;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==34&&lastdateofmonth==29){
				reviewduedate=5;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==34&&lastdateofmonth==28){
				reviewduedate=6;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==35&&lastdateofmonth==29){
				reviewduedate=6;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==35&&lastdateofmonth==28){
				reviewduedate=7;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==36&&lastdateofmonth==29){
				reviewduedate=7;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==36&&lastdateofmonth==28){
				reviewduedate=8;
				reviewduemonth=reviewduemonth+1;
			}
			
			if(reviewduedate==31&&lastdateofmonth==30&&(mon==12)){
				reviewduedate=1;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==32&&lastdateofmonth==30&&(mon==12)){
				reviewduedate=2;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==32&&lastdateofmonth==31&&(mon==12)){
				reviewduedate=1;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==33&&lastdateofmonth==30&&(mon==12)){
				reviewduedate=3;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==33&&lastdateofmonth==31&&(mon==12)){
				reviewduedate=2;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==34&&lastdateofmonth==31&&(mon==12)){
				reviewduedate=3;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==34&&lastdateofmonth==30&&(mon==12)){
				reviewduedate=4;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==35&&lastdateofmonth==31&&(mon==12)){
				reviewduedate=4;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==35&&lastdateofmonth==30&&(mon==12)){
				reviewduedate=5;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==36&&lastdateofmonth==31&&(mon==12)){
				reviewduedate=5;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==36&&lastdateofmonth==30&&(mon==12)){
				reviewduedate=6;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==37&&lastdateofmonth==31&&(mon==12)){
				reviewduedate=6;
				reviewduemonth=1;
				yea=yea+1;
			}
			
			if(reviewduedate==37&&lastdateofmonth==30&&(mon==12)){
				reviewduedate=7;
				reviewduemonth=1;
				yea=yea+1;
			}
			
	
			
			String RevDueDate= reviewduemonth+"/"+reviewduedate+"/"+yea;
			System.out.println("reviewduedate with ratingreleasedate "+ratingreldate+" is "+RevDueDate);
			
			return RevDueDate;
	}

}
