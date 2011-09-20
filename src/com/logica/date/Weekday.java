package com.logica.date;

import java.util.Calendar;

public class Weekday {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

		if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY) {
			System.out.println("Weekend");
		} else {
			System.out.println("Weekday");
		}
	}

}
