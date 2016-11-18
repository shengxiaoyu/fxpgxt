package com.nju.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date getTime(){
        Date date = new Date();
//      DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//      String time=format.format(date);
      return date;
  }
	public static Date FormatDate(String dateStr){
		String format="yyyy-MM-dd";
		Date date = null ;
		try {
			date = new SimpleDateFormat(format).parse(dateStr) ;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date ;
	}
	public static String FormatDate(Date date){
		 DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return format.format(date) ;
	}
}
