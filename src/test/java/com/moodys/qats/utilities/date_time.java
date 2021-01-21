package com.moodys.qats.utilities;

import java.util.Calendar;

public class date_time {

	public int getlastdayofmonth(int year,int month, int date) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, date);
	int day=cal.getActualMaximum(cal.DAY_OF_MONTH);
	//int dayofweek= cal.get(cal.DAY_OF_WEEK);
	//System.out.println(day);
	//System.out.println(dayofweek);
	
	return day;
		// TODO Auto-generated method stub

	}
	
public int getdayofweek(int year,int month, int date) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, date);
	//int day=cal.getActualMaximum(cal.DAY_OF_MONTH);
	int dayofweek= cal.get(cal.DAY_OF_WEEK);
	//System.out.println(day);
	//System.out.println(dayofweek);
	
	return dayofweek;
		// TODO Auto-generated method stub

	}

}
