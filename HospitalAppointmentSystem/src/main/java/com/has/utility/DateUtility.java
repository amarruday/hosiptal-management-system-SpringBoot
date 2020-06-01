package com.has.utility;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.WeakHashMap;

/*import org.apache.commons.lang3.time.DateUtils;*/

public class DateUtility
{

	public static Timestamp getCurrentTimeStamp()
	{
		return new Timestamp(System.currentTimeMillis());
	}

	/*
	 * public static long getCurrentTimeInMillis () { long millis = 0; TimeZone tz =
	 * TimeZone.getDefault(); long offSet = (long) tz.getRawOffset(); Calendar cal =
	 * Calendar.getInstance(); long timeIn = cal.getTimeInMillis(); millis = timeIn
	 * + offSet; return millis; }
	 * 
	 * public static String formatDateTime (Date date) { SimpleDateFormat formatter
	 * = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); return formatter.format(date);
	 * }
	 * 
	 * public static String formatDateTime (Date date, String format) {
	 * SimpleDateFormat formatter = new SimpleDateFormat(format); return
	 * formatter.format(date); }
	 * 
	 * public static Date getDateObject (String strDate) { Date dt = null; if
	 * (strDate != null && strDate.trim().length() > 0) { StringTokenizer strToken =
	 * new StringTokenizer(strDate, "/"); int[] dtArr = new int[3]; int i = 0; while
	 * (strToken.hasMoreTokens()) { dtArr[i] =
	 * Integer.parseInt(strToken.nextToken()); //log.info("Int parsing the token " +
	 * i + "| The value of the token is " + dtArr[i]); i++; } Calendar cal =
	 * Calendar.getInstance(); //log.info("Dates are as-" + dtArr[2] + "|" +
	 * dtArr[1] + "|" + dtArr[0]); cal.clear(); cal.set(dtArr[2], dtArr[1] - 1,
	 * dtArr[0]);// As date is accepted in // MM/dd/yyyy
	 * 
	 * dt = new Date(cal.getTimeInMillis());
	 * //log.info("Creating time in milis for strDate " + dt.toString()); } return
	 * dt; }
	 * 
	 * public static Date getDateObjectForSqlFormatString (String strDate) { Date dt
	 * = null; if (strDate != null && strDate.trim().length() > 0) { StringTokenizer
	 * strToken = new StringTokenizer(strDate, "-"); int[] dtArr = new int[3]; int i
	 * = 0; while (strToken.hasMoreTokens()) { dtArr[i] =
	 * Integer.parseInt(strToken.nextToken()); //log.info("Int parsing the token " +
	 * i + "| The value of the token is " + dtArr[i]); i++; } Calendar cal =
	 * Calendar.getInstance(); //log.info("Dates are as-" + dtArr[2] + "|" +
	 * dtArr[1] + "|" + dtArr[0]); cal.clear(); cal.set(dtArr[2], dtArr[1] - 1,
	 * dtArr[0]);// As date is accepted in // MM/dd/yyyy
	 * 
	 * dt = new Date(cal.getTimeInMillis());
	 * //log.info("Creating time in milis for strDate " + dt.toString()); } return
	 * dt; }
	 * 
	 * public static Date getCurrentDate () { long timeMillis =
	 * System.currentTimeMillis(); Calendar cal = Calendar.getInstance();
	 * cal.setTimeInMillis(timeMillis); cal.set(Calendar.HOUR, 0);
	 * cal.set(Calendar.HOUR_OF_DAY, 0); cal.set(Calendar.MINUTE, 0);
	 * cal.set(Calendar.SECOND, 0); cal.set(Calendar.MILLISECOND, 0); Date currDate
	 * = new Date(cal.getTimeInMillis());
	 * //log.info("Current Date from DateUtility is:" + currDate +
	 * " and time in millis is:" + currDate.getTime()); return currDate; }
	 * 
	 * public static Time getTimeFromString (String strTime) { Time time = null; if
	 * (strTime != null && strTime.trim().length() > 0) { Calendar cal =
	 * Calendar.getInstance(); String[] strArray = strTime.split(":"); if (strArray
	 * != null && strArray.length >= 2) { cal.setTimeInMillis(0);
	 * cal.set(Calendar.HOUR, Integer.parseInt(strArray[0]));
	 * cal.set(Calendar.MINUTE, Integer.parseInt(strArray[1]));
	 * cal.set(Calendar.SECOND, 0); } // Date date = new
	 * Date(cal.getTimeInMillis()); time = new Time(cal.getTimeInMillis()); } return
	 * time; }
	 * 
	 * public static Timestamp getTimeStampForTimeZone (String timeZoneName) {
	 * Calendar calendar = new GregorianCalendar(); TimeZone timeZone =
	 * TimeZone.getTimeZone(timeZoneName); Date date = new
	 * Date(calendar.getTimeInMillis()); Timestamp timestamp = new
	 * Timestamp((date.getTime() - calendar.getTimeZone().getRawOffset()) +
	 * timeZone.getRawOffset()); return timestamp; }
	 * 
	 * public static Timestamp getTimeStampForTimeZoneAndDate (String timeZoneName,
	 * Date date) { //log.info("------------Date : " + date.toString()); Calendar
	 * calendar = new GregorianCalendar(); calendar.setTime(date); TimeZone timeZone
	 * = TimeZone.getTimeZone(timeZoneName); Date newDate = new
	 * Date(calendar.getTimeInMillis()); Timestamp timestamp = new
	 * Timestamp((newDate.getTime() - calendar.getTimeZone().getRawOffset()) +
	 * timeZone.getRawOffset()); //log.info("-------------Date : " +
	 * timestamp.toString()); return timestamp; }
	 * 
	 * public static Timestamp getTimeStampFromDate (Date date) {
	 * //log.info("------------Date : " + date.toString()); Calendar calendar = new
	 * GregorianCalendar(); calendar.setTime(date); Date newDate = new
	 * Date(calendar.getTimeInMillis()); Timestamp timestamp = new
	 * Timestamp(newDate.getTime()); //log.info("-------------Date : " +
	 * timestamp.toString()); return timestamp; }
	 * 
	 * public static String getDateObjectPatern (String strDate) {
	 * //log.info("String tokenizing the date");
	 * //log.info("String tokenizing the date " + strDate); StringTokenizer strToken
	 * = new StringTokenizer(strDate, "-"); int[] dtArr = new int[3]; int i = 0;
	 * while (strToken.hasMoreTokens()) { dtArr[i] =
	 * Integer.parseInt(strToken.nextToken()); //log.info("Int parsing the token " +
	 * i + "| The value of the token is " + dtArr[i]); i++; } Calendar cal =
	 * Calendar.getInstance(); //log.info("Dates are as-" + dtArr[0] + "|" +
	 * dtArr[1] + "|" + dtArr[2]); cal.clear(); cal.set(dtArr[0], dtArr[1] - 1,
	 * dtArr[2]);// As date is accepted in // dd/MM/yyyy Date dt = new
	 * Date(cal.getTimeInMillis()); //log.info("String Date" + dt.toString());
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 * 
	 * sdf.format(dt); //log.info("Creating time in milis for strDate " +
	 * dt.toString() + "    " + sdf.format(dt)); return sdf.format(dt); }
	 * 
	 * 
	 * public static Timestamp getServerTimeStamp () { Timestamp timestamp = null;
	 * try { TimeTrackerCentralDelegate centralDelegate = new
	 * TimeTrackerCentralDelegate(); // timestamp =
	 * centralDelegate.getServerTimesrtamp(); } catch (Exception e) {
	 * log.error("Error:" + e.getMessage());
	 * log.error(LogUtility.getStringFromArray(e.getStackTrace())); } return
	 * timestamp; }
	 * 
	 * 
	 * public static Date getFirstDateOfCurrentMonth () { Date date =
	 * DateUtility.getCurrentDate(); String[] strArray = date.toString().split("-");
	 * String month = strArray[1]; String year = strArray[0]; return
	 * getDateObject("01/" + month + "/" + year); }
	 * 
	 * public static String getTimeDiffFromTimeStamp (Timestamp checkOutTime,
	 * Timestamp checkInTime) { long seconds, minutes, hours; String minStr, secStr,
	 * hourStr; long milliSeconds = checkOutTime.getTime() - checkInTime.getTime();
	 * seconds = milliSeconds / 1000; minutes = seconds / 60; seconds = seconds %
	 * 60; hours = minutes / 60; minutes = minutes % 60;
	 * 
	 * minStr = minutes + ""; secStr = seconds + ""; hourStr = hours + "";
	 * 
	 * if (minutes < 10) { minStr = "0" + minutes; } if (seconds < 10) { secStr =
	 * "0" + seconds; } if (hours < 10) { hourStr = "0" + hours; } return hours +
	 * ":" + minutes + ":" + seconds; return hourStr + ":" + minStr + ":" + secStr;
	 * }
	 * 
	 * public static String convertTimestampFormat (Timestamp timestamp) { Date date
	 * = new Date(timestamp.getTime()); java.util.Date utilDate = new
	 * java.util.Date(date.getTime()); SimpleDateFormat sdf = new
	 * SimpleDateFormat("MM/dd/yyyy hh:mm:ss"); String formattedDate =
	 * sdf.format(utilDate); return formattedDate; }
	 * 
	 * public static Date getSqlDateFormDateString (String str) throws
	 * ParseException { DateFormat formatter = null; java.util.Date convertedDate =
	 * null; formatter = new SimpleDateFormat("dd-MMMM-yy"); convertedDate =
	 * formatter.parse(str); java.sql.Date sqlDate = new
	 * java.sql.Date(convertedDate.getTime()); return sqlDate; }
	 * 
	 * public static ArrayList<Integer>
	 * getFirstAndThirdSaturdayDayValueByMonthandYear (int month, int year) {
	 * //log.info("month:" + month + " year:" + year); ArrayList<Integer>
	 * alForsaturday = new ArrayList<Integer>(); ArrayList<Integer> al = new
	 * ArrayList<Integer>(); Calendar cal = new GregorianCalendar(year, month, 1);
	 * do { int day = cal.get(Calendar.DAY_OF_WEEK); if (day == Calendar.SATURDAY) {
	 * //log.info(cal.get(Calendar.DAY_OF_MONTH)); al.add(new
	 * Integer(cal.get(Calendar.DAY_OF_MONTH))); } cal.add(Calendar.DAY_OF_YEAR, 1);
	 * } while (cal.get(Calendar.MONTH) == month);
	 * 
	 * alForsaturday.add(al.get(0)); alForsaturday.add(al.get(2));
	 * //log.info("dayFrstAndScdSatuarday:" + alForsaturday); return alForsaturday;
	 * }
	 * 
	 * public static ArrayList<Integer> getAllSundayDayListByMonthandYear (int
	 * month, int year) { //log.info("month:" + month + " year:" + year);
	 * ArrayList<Integer> al = new ArrayList<Integer>(); Calendar cal = new
	 * GregorianCalendar(year, month, 1); do { int day =
	 * cal.get(Calendar.DAY_OF_WEEK); if (day == Calendar.SUNDAY) {
	 * //log.info(cal.get(Calendar.DAY_OF_MONTH)); al.add(new
	 * Integer(cal.get(Calendar.DAY_OF_MONTH))); } cal.add(Calendar.DAY_OF_YEAR, 1);
	 * } while (cal.get(Calendar.MONTH) == month);
	 * 
	 * return al; }
	 * 
	 * public static int getDayFromDate (Date date) { int day = 0; Calendar cal =
	 * Calendar.getInstance(); cal.setTime(date); day = cal.get(Calendar.DATE);
	 * return day; }
	 * 
	 * public static int getMonthFromDate (Date date) { int month = 0; Calendar cal
	 * = Calendar.getInstance(); cal.setTime(date); month = cal.get(Calendar.MONTH)
	 * + 1; return month; }
	 * 
	 * public static int getYearFromDate (Date date) { int year = 0; Calendar cal =
	 * Calendar.getInstance(); cal.setTime(date); year = cal.get(Calendar.YEAR);
	 * return year; }
	 * 
	 * public static String getDateObjectPaternByDateAndDateFormat (String strDate,
	 * String Dateformat) { // log.info("String tokenizing the date " + strDate);
	 * StringTokenizer strToken = new StringTokenizer(strDate, "-"); int[] dtArr =
	 * new int[3]; int i = 0; while (strToken.hasMoreTokens()) { dtArr[i] =
	 * Integer.parseInt(strToken.nextToken()); // log.info("Int parsing the token "
	 * + i + "| The value of the token is " + dtArr[i]); i++; } Calendar cal =
	 * Calendar.getInstance(); // log.info("Dates are as-" + dtArr[0] + "|" +
	 * dtArr[1] + "|" + dtArr[2]); cal.clear(); cal.set(dtArr[0], dtArr[1] - 1,
	 * dtArr[2]);// As date is accepted in Date dt = new
	 * Date(cal.getTimeInMillis()); // log.info("String Date" + dt.toString()); //
	 * log.info("Date Format" + Dateformat); SimpleDateFormat sdf = new
	 * SimpleDateFormat(Dateformat); String result = sdf.format(dt); //
	 * log.info("Creating time in milis for strDate " + dt.toString() + " " +
	 * result); return result; }
	 * 
	 * 
	 * public static int compareDate1ToDate2 (Date date1, Date date2) { int result =
	 * DateUtils.truncatedCompareTo(date1, date2, Calendar.DATE); //
	 * log.info("Date compare result is: " + result); return result; }
	 * 
	 * 
	 * public static Date getDateFromTimeStamp (Timestamp strDate) { long timeMillis
	 * = strDate.getTime(); Calendar cal = Calendar.getInstance();
	 * cal.setTimeInMillis(timeMillis); cal.set(Calendar.HOUR, 0);
	 * cal.set(Calendar.MINUTE, 0); cal.set(Calendar.SECOND, 0); Date currDate = new
	 * Date(cal.getTimeInMillis()); // log.info("Current Date from DateUtility is:"
	 * + currDate + " and time in millis is:" + currDate.getTime()); return
	 * currDate; }
	 * 
	 * public static String convertTimestampFormatForEncryption (Timestamp
	 * timestamp) { Date date = new Date(timestamp.getTime()); java.util.Date
	 * utilDate = new java.util.Date(date.getTime()); SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); String formattedDate =
	 * sdf.format(utilDate); return formattedDate; }
	 * 
	 * public static int getDifferenceDays (Date d1, Date d2) { int daysdiff = 0;
	 * long diff = d2.getTime() - d1.getTime(); long diffDays = diff / (24 * 60 * 60
	 * * 1000) + 1; daysdiff = (int) diffDays; return daysdiff; }
	 * 
	 * public static ArrayList<Date> getDateListBetweenTwoDates (Date fromDate, Date
	 * toDate) { ArrayList<Date> dateList = null; if (fromDate != null && toDate !=
	 * null) { dateList = new ArrayList<Date>(); Calendar cal =
	 * Calendar.getInstance(); cal.setTime(fromDate); while
	 * (cal.getTime().before(toDate)) { cal.add(Calendar.DATE, 1); java.util.Date
	 * utilDate = cal.getTime(); Date sqlDate = new Date(utilDate.getTime());
	 * 
	 * if (compareDate1ToDate2(sqlDate, toDate) < 0) { dateList.add(sqlDate); }
	 * 
	 * } } return dateList; }
	 * 
	 * public static ArrayList<Date> getAllSundayDaysByYear (int year) {
	 * ArrayList<Date> al = new ArrayList<Date>(); Calendar cal = new
	 * GregorianCalendar(); cal.set(year, 0, 1, 0, 0); cal.getTime(); do { int day =
	 * cal.get(Calendar.DAY_OF_WEEK); if (day == Calendar.SUNDAY) {
	 * //log.info(cal.get(Calendar.DAY_OF_MONTH)); java.util.Date date = new
	 * Date(cal.getTimeInMillis()); al.add(new Date(date.getTime())); }
	 * cal.add(Calendar.DAY_OF_YEAR, 1); } while (cal.get(Calendar.YEAR) == year);
	 * 
	 * return al; }
	 * 
	 * public static ArrayList<Date> searchBetweenDates (java.util.Date startDate,
	 * java.util.Date endDate) { java.util.Date begin = new
	 * Date(startDate.getTime()); ArrayList<Date> list = new ArrayList<Date>();
	 * list.add(new Date(begin.getTime())); while (begin.compareTo(endDate) < 0) {
	 * begin = new Date(begin.getTime() + 86400000);
	 * 
	 * list.add(new Date(begin.getTime())); } return list; }
	 * 
	 * public static Date getSqlDateFromUtilDateWithOneDayMinus (java.util.Date
	 * date) { //SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); Calendar
	 * cal = Calendar.getInstance(); cal.setTime(date); cal.add(Calendar.DATE, -1);
	 * java.util.Date dateBefore30Days = cal.getTime(); Date sqlDate = new
	 * Date(dateBefore30Days.getTime()); return sqlDate; }
	 * 
	 * public static WeakHashMap<Integer, Integer> getMonthListsBetweenTwoDates
	 * (java.util.Date startDate, java.util.Date endDate) { SimpleDateFormat df =
	 * new SimpleDateFormat("yyyy"); java.util.Date begin = new
	 * Date(startDate.getTime()); WeakHashMap<Integer, Integer> list = new
	 * WeakHashMap<Integer, Integer>(); Integer temp = (new
	 * Date(begin.getTime()).getMonth()) + 1; String year = df.format(new
	 * Date(begin.getTime())); list.put(temp, Integer.parseInt(year)); while
	 * (begin.compareTo(endDate) < 0) { begin = new Date(begin.getTime() +
	 * 86400000); int val = (new Date(begin.getTime()).getMonth() + 1); String year1
	 * = df.format(new Date(begin.getTime())); if (temp != val) { list.put((new
	 * Date(begin.getTime()).getMonth() + 1), Integer.parseInt(year1)); } temp =
	 * val; } return list; }
	 * 
	 * public static Date getLastDateInNextMonth (int month, int year) { int[]
	 * daysInAMonth = { 29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; int
	 * day = daysInAMonth[month]; boolean isLeapYear = new
	 * GregorianCalendar().isLeapYear(year); if (isLeapYear && month == 2) { day++;
	 * } GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
	 * java.util.Date nextEndDate = new java.util.Date(gc.getTime().getTime()); Date
	 * sqlDate = new Date(nextEndDate.getTime()); return sqlDate; }
	 * 
	 * public static Date getFirstDateInProviousMonth (int month, int year) {
	 * GregorianCalendar gc = new GregorianCalendar(year, month - 1, 1);
	 * java.util.Date monthFirstDate = new java.util.Date(gc.getTime().getTime());
	 * Date sqlDate = new Date(monthFirstDate.getTime()); return sqlDate; }
	 * 
	 * public static String getUtilDateStrFromMySQLDate (Date date) { DateFormat df
	 * = new SimpleDateFormat("dd-MMM-yy"); int month =
	 * DateUtility.getMonthFromDate(date); int year =
	 * DateUtility.getYearFromDate(date); int day =
	 * DateUtility.getDayFromDate(date); GregorianCalendar gc = new
	 * GregorianCalendar(year, month - 1, day); java.util.Date utilDate = new
	 * java.util.Date(gc.getTime().getTime()); String strDate = df.format(utilDate);
	 * return strDate; }
	 * 
	 * public static Date getDateFromMonthAndYearAndDay (int month, int year, int
	 * day) { GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
	 * java.util.Date monthFirstDate = new java.util.Date(gc.getTime().getTime());
	 * Date sqlDate = new Date(monthFirstDate.getTime()); return sqlDate; }
	 * 
	 * public static ArrayList<Date> getFirstAndLastDateForGivenMonthAndYear (int
	 * month, int year) { ArrayList<Date> dates = new ArrayList<Date>(); Calendar c
	 * = Calendar.getInstance(); int dateDay = 1; c.set(year, month - 1, dateDay);
	 * int numOfDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH); Date
	 * firDate = new Date((new java.util.Date(c.getTime().getTime())).getTime());
	 * dates.add(firDate); c.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth - 1); Date
	 * lastDate = new Date((new java.util.Date(c.getTime().getTime())).getTime());
	 * dates.add(lastDate); return dates; }
	 * 
	 * public static int getRandomNBetweenRange (int lower, int higher) { Random
	 * random = new Random(); int randomNumber = random.nextInt(higher - lower) +
	 * lower; return randomNumber; }
	 * 
	 * public static Time createTimeObjectUsingHourAndMinAndSecond (int num, int
	 * ramdomNum, int second) { Time time = Time.valueOf(num + ":" + ramdomNum + ":"
	 * + second); return time; }
	 * 
	 * public static Time addTimeToAnotherTime (Time timeorig, int minutes, int
	 * second) { long millinSecOrig = timeorig.getTime(); millinSecOrig =
	 * millinSecOrig + (minutes * 60 * 1000) + (second * 1000); return new
	 * Time(millinSecOrig); }
	 * 
	 * public static boolean isTodayBetween (int from, int to, Date date) { from =
	 * from - 1; to = to - 1; if (from < 0 || to < 0 || from > Calendar.DECEMBER ||
	 * to > Calendar.DECEMBER) { throw new
	 * IllegalArgumentException("Invalid month provided: from = " + from + " to = "
	 * + to); } java.util.Date now = new java.util.Date(date.getTime());
	 * //log.info("now"+now); GregorianCalendar cal = new GregorianCalendar();
	 * cal.setTime(now); int thisMonth = cal.get(Calendar.MONTH); if (from > to) {
	 * to = to + Calendar.DECEMBER; thisMonth = thisMonth + Calendar.DECEMBER; } if
	 * (thisMonth >= from && thisMonth <= to) { return true; } return false; }
	 * 
	 * public static Time trim (Date date) { Calendar calendar =
	 * Calendar.getInstance(); calendar.setTime(Date.valueOf("2017-11-04"));
	 * calendar.set(Calendar.MILLISECOND, 0); calendar.set(Calendar.SECOND, 0);
	 * calendar.set(Calendar.MINUTE, 0); calendar.set(Calendar.HOUR, 0); return
	 * (Time) calendar.getTime(); }
	 * 
	 * public static void main (String args[]) throws ParseException { Date
	 * currentDate = DateUtility.getCurrentDate(); System.out.println(currentDate);
	 * Date date = DateUtility.getSqlDateFromUtilDateWithOneDayMinus(new
	 * java.util.Date()); System.out.println("date:" + date); }
	 */
}
