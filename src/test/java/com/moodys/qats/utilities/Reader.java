package com.moodys.qats.utilities;

import java.util.ArrayList;
import java.util.List;

import com.moodys.qats.utilities.XLSX_READER;

public class Reader {
	
	static List<String> dates,years,months;
	int rowcount;
	
	XLSX_READER reader = new XLSX_READER("D:\\Users/VermaC/Documents/ui/Holiday__Calender.xlsx");
	String SHEETNAME= "ELKP_HOLIDAY";

	
	public List<String> getholidaydates() {
		dates= new ArrayList<String>();
		
		
		
		
		 rowcount= reader.getRowCount(SHEETNAME);
		System.out.println("Total number of rows in the holiday calender is "+rowcount);
		
	     for(int i= 1;i<=rowcount;i++){
	    	 String DAT = reader.getCellData(SHEETNAME, 12,i);
	    	  
	    	 dates.add(DAT);
	 		
	    	
	    	 
	     }
		//System.out.println(dates);
		
		
		return dates;
		
		
		
		// TODO Auto-generated method stub

	}
	
	public List<String> getholidaymonths() {
		
		months= new ArrayList<String>();
		
		
		
		 rowcount= reader.getRowCount(SHEETNAME);
		System.out.println("Total number of rows in the holiday calender is "+rowcount);
		
	     for(int i= 1;i<=rowcount;i++){
	    	 
	 		String MON= reader.getCellData(SHEETNAME, 13, i);
	 		
	    	 months.add(MON);
	 	
	 	
	    	 
	    	
	    	 
	     }
		//System.out.println(months);
		
		
		return months;
		
		
		
		// TODO Auto-generated method stub

	}
	
	public List<String> getholidayyears() {
		
		years= new ArrayList<String>();
		
		
		
		
		 rowcount= reader.getRowCount(SHEETNAME);
		System.out.println("Total number of rows in the holiday calender is "+rowcount);
		
	     for(int i= 1;i<=rowcount;i++){
	    	
	 		String YEA= reader.getCellData(SHEETNAME, 14, i);
	 	
	    	 years.add(YEA);
	    	 //System.out.println(DAT+" "+MON+" "+YEA);
	    	
	    	 
	     }
		//System.out.println(years);
		
		
		return years;
		
		
		
		// TODO Auto-generated method stub

	}
	
	public int getrowcount(){
		 rowcount= reader.getRowCount(SHEETNAME);
			
			return rowcount;
	}
	
	

}
