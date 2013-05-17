/*
 * File: gov.kdrm.mygset.util.DateTimeUtil.java
 *
 * Copyright (c) 2009 PT. XYBASE INDONESIA,
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information
 * of PT. XYBASE INDONESIA ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered
 * into with PT. XYBASE INDONESIA.
 *
 * Project:	mygset2
 * Created: Sep 24, 2009 2:00:00 PM
 */
package com.tokogame.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * <p>
 * Common functions all about date and time
 * </p>
 * 
 * <p>
 * Revision Information:<br/>
 * <i> $Date: 2010-06-03 14:44:49 +0700 (Thu, 03 Jun 2010) $<br/>
 * $Revision: 33560 $ $LastChangedBy$ </i>
 * </p>
 * 
 * @author Nia
 */
public abstract class DateTimeUtil {

	private static final Log	log			= LogFactory.getLog(DateTimeUtil.class);

//	public static final String	FORMAT_DATE	= "dd/MM/yyyy";
	public static final String	FORMAT_DATE	= "dd-MMMM-yyyy";
	public static final String	FORMAT_TIME	= "HH:mm:ss";

	/**
	 * Get current date
	 * 
	 * @return current date
	 */
	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Get current time
	 * 
	 * @return current time
	 */
	public static String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat(FORMAT_TIME);
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static java.sql.Date getCurrentServerSqlDate() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	/**
	 * get Current Year
	 * @return Current Year 
	 */
	public static int getCurrentYear(){
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * get Current Month
	 * @return Current Month
	 */
	public static int getCurrentMonth(){
		return Calendar.getInstance().get(Calendar.MONTH);
	}

	/**
	 * Format a Date object into String
	 * 
	 * @param date the date
	 * @param dateFormat format pattern
	 * @return string of the formatted date
	 */
	public static String formatDateToStr(Date date, String dateFormat) {
		String formattedDate = null;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormat != null ? dateFormat: FORMAT_DATE);
			formattedDate = formatter.format(date);
		} catch (Exception e) {
			log.error("Fail to format date.", e);
		}
		return formattedDate;
	}

	/**
	 * This method to get formatted date
	 * 
	 * DatVT overload
	 * 
	 * @param date
	 * @return String with format: DD/MM/YYYY
	 */
	public static String formatDateToStr(Date date) {
		return formatDateToStr(date, FORMAT_DATE);
	}

	/**
	 * this method to get formatted time
	 * 
	 * @param time time to format
	 * @param timeFormat format pattern
	 * @return formatted time
	 */
	public static String formatTimeToStr(Time time, String timeFormat) {
		return formatTimeToStr(time, FORMAT_TIME);
	}

	/**
	 * This method converts a String into a Date
	 * 
	 * @param dtStr the date in string format
	 * @return the Date
	 */
	public static Date convertStringToDate(String dtStr) {
		if (dtStr == null) {
			return null;
		}
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATE);
		log.debug("Converting '" + dtStr + "' to date with format '" + FORMAT_DATE + "'");
		try {
			date = df.parse(dtStr);
		} catch (ParseException pe) {
			log.error("Unable to convert a string to date", pe);
		}
		return date;
	}

	/**
	 * To convert Date string (dd/mm/yyyy), time string (12hh:mi) and AM/PM to be a Timestamp.
	 * 
	 * @param dateStr Date string (dd/mm/yyyy)
	 * @param timestr time string (12hh:mi)
	 * @param ampm AM/PM
	 * @return Timestamp if all the pass in variables are valid otherwise null.
	 */
	public static Timestamp convertDateTimeToTimestamp(String dateStr, String timestr, String ampm) {

		Timestamp timestamp = null;

		try {
			String[] dateString = dateStr.split("/");
			String[] timeString = timestr.split(":");
			if ("PM".equals(ampm)) {
				timeString[0] += 12;
			}
			Calendar cal = Calendar.getInstance();
			cal.set(Integer.parseInt(dateString[2]), Integer.parseInt(dateString[1]) - 1, Integer
					.parseInt(dateString[0]), Integer.parseInt(timeString[0]), Integer.parseInt(timeString[1]));
			timestamp = new Timestamp(cal.getTimeInMillis());
		} catch (Exception e) {
			timestamp = null;
		}
		return timestamp;
	}

    public static double getInterval(Date from, Date thru) {
        return thru != null ? thru.getTime() - from.getTime() : 0;
    }

    public static long getIntervalInDays(Timestamp from, Timestamp thru) {
        return thru != null ? (thru.getTime() - from.getTime()) / (24*60*60*1000) : 0;
    }

    public static Timestamp addDaysToTimestamp(Timestamp start, int days) {
        return new Timestamp(start.getTime() + (24L*60L*60L*1000L*days));
    }

    public static Timestamp addDaysToTimestamp(Timestamp start, Double days) {
        return new Timestamp(start.getTime() + ((int) (24L*60L*60L*1000L*days)));
    }

    public static double getInterval(Timestamp from, Timestamp thru) {
        return thru != null ? thru.getTime() - from.getTime() + (thru.getNanos() - from.getNanos()) / 1000000 : 0;
    }

    /**
     * Return a Timestamp for right now
     *
     * @return Timestamp for right now
     */
    public static java.sql.Timestamp nowTimestamp() {
        return getTimestamp(System.currentTimeMillis());
    }

    /**
     * Convert a millisecond value to a Timestamp.
     * @param time millsecond value
     * @return Timestamp
     */
    public static java.sql.Timestamp getTimestamp(long time) {
        return new java.sql.Timestamp(time);
    }

    /**
     * Convert a millisecond value to a Timestamp.
     * @param milliSecs millsecond value
     * @return Timestamp
     */
    public static Timestamp getTimestamp(String milliSecs) throws NumberFormatException {
        return new Timestamp(Long.parseLong(milliSecs));
    }

    /**
     * Returns currentTimeMillis as String
     *
     * @return String(currentTimeMillis)
     */
    public static String nowAsString() {
        return Long.toString(System.currentTimeMillis());
    }

    /**
     * Return a string formatted as yyyyMMddHHmmss
     *
     * @return String formatted for right now
     */
    public static String nowDateString() {
        return nowDateString("yyyyMMddHHmmss");
    }

    /**
     * Return a string formatted as format
     *
     * @return String formatted for right now
     */
    public static String nowDateString(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * Return a Date for right now
     *
     * @return Date for right now
     */
    public static java.util.Date nowDate() {
        return new java.util.Date();
    }

    public static java.sql.Timestamp getDayStart(java.sql.Timestamp stamp) {
        return getDayStart(stamp, 0);
    }

    public static java.sql.Timestamp getDayStart(java.sql.Timestamp stamp, int daysLater) {
        return getDayStart(stamp, daysLater, TimeZone.getDefault(), Locale.getDefault());
    }

    public static java.sql.Timestamp getNextDayStart(java.sql.Timestamp stamp) {
        return getDayStart(stamp, 1);
    }

    public static java.sql.Timestamp getDayEnd(java.sql.Timestamp stamp) {
        return getDayEnd(stamp, Long.valueOf(0));
    }

    public static java.sql.Timestamp getDayEnd(java.sql.Timestamp stamp, Long daysLater) {
        return getDayEnd(stamp, daysLater, TimeZone.getDefault(), Locale.getDefault());
    }

    /**
     * Return the date for the first day of the year
     *
     * @param stamp
     * @return java.sql.Timestamp
     */
    public static java.sql.Timestamp getYearStart(java.sql.Timestamp stamp) {
        return getYearStart(stamp, 0, 0, 0);
    }

    public static java.sql.Timestamp getYearStart(java.sql.Timestamp stamp, int daysLater) {
        return getYearStart(stamp, daysLater, 0, 0);
    }

    public static java.sql.Timestamp getYearStart(java.sql.Timestamp stamp, int daysLater, int yearsLater) {
        return getYearStart(stamp, daysLater, 0, yearsLater);
    }
    public static java.sql.Timestamp getYearStart(java.sql.Timestamp stamp, int daysLater, int monthsLater, int yearsLater) {
        return getYearStart(stamp, daysLater, monthsLater, yearsLater, TimeZone.getDefault(), Locale.getDefault());
    }
    public static java.sql.Timestamp getYearStart(java.sql.Timestamp stamp, Number daysLater, Number monthsLater, Number yearsLater) {
        return getYearStart(stamp, (daysLater == null ? 0 : daysLater.intValue()),
                (monthsLater == null ? 0 : monthsLater.intValue()), (yearsLater == null ? 0 : yearsLater.intValue()));
    }

    /**
     * Return the date for the first day of the month
     *
     * @param stamp
     * @return java.sql.Timestamp
     */
    public static java.sql.Timestamp getMonthStart(java.sql.Timestamp stamp) {
        return getMonthStart(stamp, 0, 0);
    }

    public static java.sql.Timestamp getMonthStart(java.sql.Timestamp stamp, int daysLater) {
        return getMonthStart(stamp, daysLater, 0);
    }

    public static java.sql.Timestamp getMonthStart(java.sql.Timestamp stamp, int daysLater, int monthsLater) {
        return getMonthStart(stamp, daysLater, monthsLater, TimeZone.getDefault(), Locale.getDefault());
    }

    /**
     * Return the date for the first day of the week
     *
     * @param stamp
     * @return java.sql.Timestamp
     */
    public static java.sql.Timestamp getWeekStart(java.sql.Timestamp stamp) {
        return getWeekStart(stamp, 0, 0);
    }

    public static java.sql.Timestamp getWeekStart(java.sql.Timestamp stamp, int daysLater) {
        return getWeekStart(stamp, daysLater, 0);
    }

    public static java.sql.Timestamp getWeekStart(java.sql.Timestamp stamp, int daysLater, int weeksLater) {
        return getWeekStart(stamp, daysLater, weeksLater, TimeZone.getDefault(), Locale.getDefault());
    }

    public static java.sql.Timestamp getWeekEnd(java.sql.Timestamp stamp) {
        return getWeekEnd(stamp, TimeZone.getDefault(), Locale.getDefault());
    }

    public static Calendar toCalendar(java.sql.Timestamp stamp) {
        Calendar cal = Calendar.getInstance();
        if (stamp != null) {
            cal.setTimeInMillis(stamp.getTime());
        }
        return cal;
    }
    public static Calendar getCalendarInstance(TimeZone timeZone, Locale locale) {
        return Calendar.getInstance(timeZone, locale);
    }

    /**
     * Returns a Calendar object initialized to the specified date/time, time zone,
     * and locale.
     *
     * @param date date/time to use
     * @param timeZone
     * @param locale
     * @return Calendar object
     * @see java.util.Calendar
     */
    public static Calendar toCalendar(Date date, TimeZone timeZone, Locale locale) {
        Calendar cal = getCalendarInstance(timeZone, locale);
        if (date != null) {
            cal.setTime(date);
        }
        return cal;
    }

    public static Timestamp getDayStart(Timestamp stamp, TimeZone timeZone, Locale locale) {
        return getDayStart(stamp, 0, timeZone, locale);
    }

    public static Timestamp getDayStart(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
        Calendar tempCal = toCalendar(stamp, timeZone, locale);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
        retStamp.setNanos(0);
        return retStamp;
    }

    public static Timestamp getDayEnd(Timestamp stamp, TimeZone timeZone, Locale locale) {
        return getDayEnd(stamp, Long.valueOf(0), timeZone, locale);
    }

    public static Timestamp getDayEnd(Timestamp stamp, Long daysLater, TimeZone timeZone, Locale locale) {
        Calendar tempCal = toCalendar(stamp, timeZone, locale);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater.intValue());
        Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
        retStamp.setNanos(0);
        //MSSQL datetime field has accuracy of 3 milliseconds and setting the nano seconds cause the date to be rounded to next day
        //retStamp.setNanos(999999999);
        return retStamp;
    }

    public static Timestamp getWeekStart(Timestamp stamp, TimeZone timeZone, Locale locale) {
        return getWeekStart(stamp, 0, 0, timeZone, locale);
    }

    public static Timestamp getWeekStart(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
        return getWeekStart(stamp, daysLater, 0, timeZone, locale);
    }

    public static Timestamp getWeekStart(Timestamp stamp, int daysLater, int weeksLater, TimeZone timeZone, Locale locale) {
        Calendar tempCal = toCalendar(stamp, timeZone, locale);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        tempCal.set(Calendar.DAY_OF_WEEK, tempCal.getFirstDayOfWeek());
        tempCal.add(Calendar.WEEK_OF_MONTH, weeksLater);
        Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
        retStamp.setNanos(0);
        return retStamp;
    }

    public static Timestamp getWeekEnd(Timestamp stamp, TimeZone timeZone, Locale locale) {
        Timestamp weekStart = getWeekStart(stamp, timeZone, locale);
        Calendar tempCal = toCalendar(weekStart, timeZone, locale);
        tempCal.add(Calendar.DAY_OF_MONTH, 6);
        return getDayEnd(new Timestamp(tempCal.getTimeInMillis()), timeZone, locale);
    }

    public static Timestamp getMonthStart(Timestamp stamp, TimeZone timeZone, Locale locale) {
        return getMonthStart(stamp, 0, 0, timeZone, locale);
    }

    public static Timestamp getMonthStart(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
        return getMonthStart(stamp, daysLater, 0, timeZone, locale);
    }

    public static Timestamp getMonthStart(Timestamp stamp, int daysLater, int monthsLater, TimeZone timeZone, Locale locale) {
        Calendar tempCal = toCalendar(stamp, timeZone, locale);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), 1, 0, 0, 0);
        tempCal.add(Calendar.MONTH, monthsLater);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
        retStamp.setNanos(0);
        return retStamp;
    }

    public static Timestamp getMonthEnd(Timestamp stamp, TimeZone timeZone, Locale locale) {
        Calendar tempCal = toCalendar(stamp, timeZone, locale);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.get(Calendar.MONTH), tempCal.getActualMaximum(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return getDayEnd(new Timestamp(tempCal.getTimeInMillis()), timeZone, locale);
    }

    public static Timestamp getYearStart(Timestamp stamp, TimeZone timeZone, Locale locale) {
        return getYearStart(stamp, 0, 0, 0, timeZone, locale);
    }

    public static Timestamp getYearStart(Timestamp stamp, int daysLater, TimeZone timeZone, Locale locale) {
        return getYearStart(stamp, daysLater, 0, 0, timeZone, locale);
    }

    public static Timestamp getYearStart(Timestamp stamp, int daysLater, int yearsLater, TimeZone timeZone, Locale locale) {
        return getYearStart(stamp, daysLater, 0, yearsLater, timeZone, locale);
    }

    public static Timestamp getYearStart(Timestamp stamp, Number daysLater, Number monthsLater, Number yearsLater, TimeZone timeZone, Locale locale) {
        return getYearStart(stamp, (daysLater == null ? 0 : daysLater.intValue()),
                (monthsLater == null ? 0 : monthsLater.intValue()), (yearsLater == null ? 0 : yearsLater.intValue()), timeZone, locale);
    }

    public static Timestamp getYearStart(Timestamp stamp, int daysLater, int monthsLater, int yearsLater, TimeZone timeZone, Locale locale) {
        Calendar tempCal = toCalendar(stamp, timeZone, locale);
        tempCal.set(tempCal.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
        tempCal.add(Calendar.YEAR, yearsLater);
        tempCal.add(Calendar.MONTH, monthsLater);
        tempCal.add(Calendar.DAY_OF_MONTH, daysLater);
        Timestamp retStamp = new Timestamp(tempCal.getTimeInMillis());
        retStamp.setNanos(0);
        return retStamp;
    }

    public static Timestamp getYearEnd(Timestamp stamp, TimeZone timeZone, Locale locale) {
        Calendar tempCal = toCalendar(stamp, timeZone, locale);
        tempCal.set(tempCal.get(Calendar.YEAR), tempCal.getActualMaximum(Calendar.MONTH) + 1, 0, 0, 0, 0);
        return getMonthEnd(new Timestamp(tempCal.getTimeInMillis()), timeZone, locale);
    }

}
