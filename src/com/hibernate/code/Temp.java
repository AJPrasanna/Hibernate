package com.hibernate.code;

import java.util.Calendar;
import java.util.Date;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		//System.out.println(d.get);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		System.out.println(d);
		System.out.println(c.getTime());
		//c.getTime();

	}

}
