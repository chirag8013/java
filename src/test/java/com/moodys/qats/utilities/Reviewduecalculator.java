package com.moodys.qats.utilities;

public class Reviewduecalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reviewduecalculator cal= new Reviewduecalculator();
		cal.revduecalc("12/30/2017");
	}
	
	public String revduecalc(String ratingreldate){
		String ratingreleasedate= ratingreldate;
		
		int yea= Integer.parseInt(ratingreleasedate.split("/")[2]);
		int mon= Integer.parseInt(ratingreleasedate.split("/")[0]);
		int dat= Integer.parseInt(ratingreleasedate.split("/")[1]);

		date_time datetime= new date_time();
		int dow=datetime.getdayofweek(yea, mon, dat);
		int lastdateofmonth= datetime.getlastdayofmonth(yea, mon, dat);


			
			int reviewduedate= dat+4;
			int reviewduemonth=mon;
			
			if(dow==1){
				reviewduedate=reviewduedate+1;
			}
			
			if(dow==3||dow==4||dow==5||dow==6||dow==7){
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
			System.out.println(RevDueDate);
			
			return RevDueDate;
	}

}
