package com.moodys.qats.utilities;

import java.util.ArrayList;
import java.util.List;
import com.moodys.qats.utilities.XLSX_READER;

public class Reader{

	static List<String> years, months, dayofweek,region;
	static List<Integer> dates;
	  int rowcount;

	XLSX_READER reader = new XLSX_READER("D:\\Users/VermaC/Documents/ui/Holiday__Calender.xlsx");
	String SHEETNAME = "ELKP_HOLIDAY";

	public List<Integer> getholidaydates() {
		dates = new ArrayList<Integer>();

		rowcount = reader.getRowCount(SHEETNAME);
		System.out.println("Total number of rows in the holiday calender is " + rowcount);

		for (int i = 2; i < rowcount; i++) {
			String DATT = reader.getCellData(SHEETNAME, 12, i);
			int DAT = (int) Double.parseDouble(DATT);

			dates.add(DAT);

		}
		// System.out.println(dates);

		return dates;

		// TODO Auto-generated method stub

	}

	public List<String> getholidaymonths() {

		months = new ArrayList<String>();

		rowcount = reader.getRowCount(SHEETNAME);
		System.out.println("Total number of rows in the holiday calender is " + rowcount);

		for (int i = 2; i <= rowcount; i++) {

			String MON = reader.getCellData(SHEETNAME, 13, i);

			months.add(MON);

		}
		// System.out.println(months);

		return months;

		// TODO Auto-generated method stub

	}

	public List<String> getholidayyears() {

		years = new ArrayList<String>();

		rowcount = reader.getRowCount(SHEETNAME);
		System.out.println("Total number of rows in the holiday calender is " + rowcount);

		for (int i = 2; i <= rowcount; i++) {

			String YEA = reader.getCellData(SHEETNAME, 14, i);

			years.add(YEA);
			// System.out.println(DAT+" "+MON+" "+YEA);

		}
		// System.out.println(years);

		return years;

		// TODO Auto-generated method stub

	}

	public List<String> getholidaydayofweek() {

		dayofweek = new ArrayList<String>();

		rowcount = reader.getRowCount(SHEETNAME);
		System.out.println("Total number of rows in the holiday calender is " + rowcount);

		for (int i = 2; i <= rowcount; i++) {

			String day = reader.getCellData(SHEETNAME, 11, i);

			dayofweek.add(day);

		}
		// System.out.println(dayofweek);

		return dayofweek;

		// TODO Auto-generated method stub

	}
	
	public List<String> getregion() {

		region = new ArrayList<String>();

		rowcount = reader.getRowCount(SHEETNAME);
		System.out.println("Total number of rows in the holiday calender is " + rowcount);

		for (int i = 2; i <= rowcount; i++) {

			String reg = reader.getCellData(SHEETNAME, 7, i);

			region.add(reg);

		}
		// System.out.println(dayofweek);

		return region;

		// TODO Auto-generated method stub

	}

	public int getrowcount() {
		rowcount = reader.getRowCount(SHEETNAME);

		return rowcount;
	}
	
	
	public void readexcel(){
		
		
		List<String> dayy=getholidaydayofweek();
		List<Integer> datee = getholidaydates();
		List<String> monthh= getholidaymonths();
		List<String> yearr= getholidayyears();
		List<String> region= getregion();
		rowcount = reader.getRowCount(SHEETNAME);
		
		for(int i = 0;i<rowcount-2;i++){
			System.out.print(region.get(i)+" "+dayy.get(i)+" "+datee.get(i)+" "+monthh.get(i)+" "+yearr.get(i));
			System.out.println();
	
		}
	}
	
	
	
}


