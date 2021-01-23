package com.moodys.qats.utilities;

import java.util.ArrayList;
import java.util.List;
import com.moodys.qats.utilities.XLSX_READER2;

public class Reader2{
	
	List<String> countryid,regionid,analystloc;
	int rowcount;
	


	XLSX_READER2 readd2 = new XLSX_READER2("D:\\Users/VermaC/Documents/ui/Analyst_Loc_Region_Country.xlsx");
	String SHEETNAME = "LKP_QATS_ANALYST_LOC";
	
	public List<String> getcountryid() {

		countryid = new ArrayList<String>();

		rowcount = readd2.getRowCount(SHEETNAME);
		//System.out.println("Total number of rows in the holiday calender is " + rowcount);

		for (int i = 2; i <= rowcount; i++) {

			String country = readd2.getCellData(SHEETNAME, 6, i);

			countryid.add(country);

		}
		 //System.out.println(countryid);

		return countryid;

		// TODO Auto-generated method stub

	}
	
	public List<String> getregionid() {

		regionid = new ArrayList<String>();

		rowcount = readd2.getRowCount(SHEETNAME);
		//System.out.println("Total number of rows in the holiday calender is " + rowcount);

		for (int i = 2; i <= rowcount; i++) {

			String region = readd2.getCellData(SHEETNAME, 7, i);

			regionid.add(region);

		}
		 //System.out.println(regionid);

		return regionid;

		// TODO Auto-generated method stub

	}
	
	public List<String> getanalystlocation() {

		analystloc = new ArrayList<String>();

		rowcount = readd2.getRowCount(SHEETNAME);
		//System.out.println("Total number of rows in the holiday calender is " + rowcount);

		for (int i = 2; i <= rowcount; i++) {

			String analyst = readd2.getCellData(SHEETNAME, 0, i);

			analystloc.add(analyst);

		}
		 //System.out.println(analystloc);
		

		return analystloc;

		// TODO Auto-generated method stub

	}
	
	public  int getrowcount() {
		rowcount = readd2.getRowCount(SHEETNAME);
//System.out.println(rowcount);
		return rowcount;
	}
	
	
	
	

	
	
	
	
	
}


