package com.foreseers.tj.util;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class getAge {

	public int jiuanAge(String date) {
		String dates[] = date.split("-");
		int year = Integer.parseInt(dates[0]);
		int month = Integer.parseInt(dates[1]);
		int day = Integer.parseInt(dates[2]);
//		System.out.println(year);
//		System.out.println(month);
//		System.out.println(day);
		Calendar calendar=Calendar.getInstance();
		//获得当前时间的月份，月份从0开始所以结果要加1
		int yearnow = calendar.get(Calendar.YEAR);
		int monthnow =calendar.get(Calendar.MONTH)+1;
		int daynow = calendar.get(Calendar.DATE);
	//	Date today = new Date();
//		System.out.println(yearnow);
//		System.out.println(monthnow);
//		System.out.println(daynow);
		int age = yearnow-year;
		if(monthnow < month) {
			age--;
		}else {
			if(monthnow == month) {
				if(daynow < day) {
					age--;
				}
			}
			
		}
		return age;
	}
	
	@Test
	public void testu() {
		String date = "1996-02-20";
		System.out.println(jiuanAge(date));
		
	}
	
}
