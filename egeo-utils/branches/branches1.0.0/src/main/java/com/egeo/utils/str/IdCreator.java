package com.egeo.utils.str;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class IdCreator {
	protected static Logger logger = LoggerFactory.getLogger(IdCreator.class);

	private static long ZERO_SECOND = 0;
	static {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		ZERO_SECOND = cal.getTimeInMillis() / 1000;
	}
	protected int cnt = 0;
	protected long last = 0;

	public abstract String next();

	protected long getNum() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int s = (int) ((cal.getTimeInMillis() / 1000 - ZERO_SECOND) % 86400);
		year = year % 100;
		long num = year * 100 + month + 1;
		num = num * 100 + day;
		num = num * 100000 + s;
		return num;
	}
}
