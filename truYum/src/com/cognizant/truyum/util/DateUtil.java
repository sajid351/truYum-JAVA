package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * This method is used to convert date entered in a form ‘dd/MM/yyyy’.
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertToDate(String date) {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		Date date2 = null;

		try {
			date2 = simpleDate.parse(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;

	}

	/*
	 * public static void main(String[] args) { SimpleDateFormat simpleDate = new
	 * SimpleDateFormat("dd/MM/yyyy"); Date date2 = null;
	 * 
	 * try { date2 = simpleDate.parse("05/01/2001");
	 * System.out.println(simpleDate.format(date2)); } catch (ParseException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */

}
