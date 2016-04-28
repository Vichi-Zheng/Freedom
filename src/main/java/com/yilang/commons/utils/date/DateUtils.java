package com.yilang.commons.utils.date;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;


/**
 * @category 日期时间工具类
 * @version 1.0
 * @author huijun.zheng
 * @company 
 * @Date 2011-11-10
 */
@SuppressWarnings({"rawtypes","deprecation","unchecked","unused"})
public class DateUtils {
	
	private static final String dateFormat1 = "yyyy-MM-dd HH:mm:ss";
	private static final String dateFormat2 = "yyyy-MM-dd HH:mm";
	private static final String dateFormat3 = "yyyy-MM-dd";
	private static final String dateFormat4 = "yyyyMMdd";
	private static final String dateFormat5 = "yyyy-MM";
	private static final String dateFormat6 = "HH:mm";
	private static final String dateFormat7 = "HHmm";
	private static final String dateFormat8 = "yyyy";
	private static final String dateFormat9 = "yyyyMMddHHmmss";
	private static final String dateFormat10 = "yyyyMMddHHmmssS";
	
	private static final Format shortDayformater = new SimpleDateFormat(dateFormat4);
	private static final Format longDayformater = new SimpleDateFormat(dateFormat9);
	
	/**
	 * 将字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date string2DateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat1);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return date;
	}
	
	/**
	 * 将字符串转换为字符串 MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static String str2Str(String strDate) {
		if(strDate == null)
			return "";
		if(strDate.length()<5)
			return strDate;
		return strDate.substring(5, strDate.length());
	}
	
	/**
	 * 将字符串转换为时间 HH:mm
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date string2Date1(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat6);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return date;
	}
	/**
	 * 将字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date string2Date(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat3);
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return date;
	}

	/**
	 * 将时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String date2StrLong(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat1);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 将时间转换为字符串 HHmm
	 * 
	 * @param date
	 * @return
	 */
	public static String date2String2(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat7);
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static String date2String9(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat6);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 将时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat3);
		String dateString = formatter.format(date);
		return dateString;
	}
	
	/**
	 * 将字符串转换为时间 yyyyMMdd
	 * 
	 * @param strDate
	 * @return
	 */
	public static String date2String0(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat4);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 将字符串转换为时间 yyyy-MM
	 * 
	 * @param strDate
	 * @return
	 */
	public static String date2String1(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat5);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 将字符串转换为时间 yyyy
	 * 
	 * @param strDate
	 * @return
	 */
	public static String date2String3(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat8);
		String dateString = formatter.format(date);
		return dateString;
	}
	
	/**
	 * 将字符串转换为时间 yyyyMMddHHmmssS
	 * 
	 * @param strDate
	 * @return
	 */
	public static String date2String10(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat10);
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 根据一个字符串形式的日期，返回是星期1,2,3。。。的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static int getWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return week;
	}
	
	/**
	 * 根据一个字符串形式的日期，返回是星期1,2,3。。。的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static int getCWeek(Date date) {
		int w = getWeek(date);
		if(w==1) return 7;
		w--;
		return w;
	}

	/**
	 * 根据一个字符串形式的日期，返回是星期1,2,3。。。的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间
		Date date = DateUtils.string2DateLong(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 根据一个字符串形式的日期，返回是星期一、二、三...的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeekStr(String sdate) {
		String str = "";
		str = DateUtils.getWeek(sdate);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	public static Date dateAddMinutes(Date date, int minutes) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	public static Date dateAddHours(Date date, int hours) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);
		return cal.getTime();
	}

	public static Date dateAddDays(Date date, int addDays) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, addDays);
		return cal.getTime();
	}

	public static Date dateAddMonths(Date date, int addMonths) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, addMonths);
		return cal.getTime();
	}

	public static Date dateAddMonths(Date date, double months) {
		if (date == null)
			return null;
		int addMonths = (int) Math.ceil(months);
		int addDays = (int) Math.round((months - addMonths) * 31);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, addMonths);
		cal.add(Calendar.DATE, addDays);
		return cal.getTime();
	}

	public static Date dateAddYears(Date date, int addYears) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, addYears);
		return cal.getTime();
	}

	public static boolean isDate(String strDate, String pattern) {
		if (strDate == null || strDate.trim().length() <= 0)
			return false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			sdf.parse(strDate);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static int getIntervalOfDay(Date d1, Date d2) {
		int elapsed = 0;
		boolean isAfter = false;
		Date temp;
		if (d1.after(d2)) {
			temp = d1;
			d1 = d2;
			d2 = temp;
			isAfter = true;
		}

		while (d1.before(d2)) {
			d1 = dateAddDays(d1, 1);
			elapsed++;
		}
		if (isAfter)
			elapsed = 0 - elapsed;
		return elapsed;
	}

	/**
	 * Elapsed days based on current time
	 * 
	 * @param date
	 *            Date
	 * 
	 * @return int number of days
	 */
	public static int getElapsedDays(Date date) {
		return elapsed(date, Calendar.DATE);
	}

	/**
	 * Elapsed days based on two Date objects
	 * 
	 * @param d1
	 *            Date
	 * @param d2
	 *            Date
	 * 
	 * @return int number of days
	 */
	public static int getElapsedDays(Date d1, Date d2) {
		return elapsed(d1, d2, Calendar.DATE);
	}

	/**
	 * Elapsed months based on current time
	 * 
	 * @param date
	 *            Date
	 * 
	 * @return int number of months
	 */
	public static int getElapsedMonths(Date date) {
		return elapsed(date, Calendar.MONTH);
	}

	/**
	 * Elapsed months based on two Date objects
	 * 
	 * @param d1
	 *            Date
	 * @param d2
	 *            Date
	 * 
	 * @return int number of months
	 */
	public static int getElapsedMonths(Date d1, Date d2) {
		return elapsed(d1, d2, Calendar.MONTH);
	}

	/**
	 * Elapsed years based on current time
	 * 
	 * @param date
	 *            Date
	 * 
	 * @return int number of years
	 */
	public static int getElapsedYears(Date date) {
		return elapsed(date, Calendar.YEAR);
	}

	/**
	 * Elapsed years based on two Date objects
	 * 
	 * @param d1
	 *            Date
	 * @param d2
	 *            Date
	 * 
	 * @return int number of years
	 */
	public static int getElapsedYears(Date d1, Date d2) {
		return elapsed(d1, d2, Calendar.YEAR);
	}

	/**
	 * All elaspsed types
	 * 
	 * @param g1
	 *            GregorianCalendar
	 * @param g2
	 *            GregorianCalendar
	 * @param type
	 *            int (Calendar.FIELD_NAME)
	 * 
	 * @return int number of elapsed "type"
	 */
	private static int elapsed(GregorianCalendar g1, GregorianCalendar g2,
			int type) {
		GregorianCalendar gc1, gc2;
		int elapsed = 0;
		// Create copies since we will be clearing/adding
		if (g2.after(g1)) {
			gc2 = (GregorianCalendar) g2.clone();
			gc1 = (GregorianCalendar) g1.clone();
		} else {
			gc2 = (GregorianCalendar) g1.clone();
			gc1 = (GregorianCalendar) g2.clone();
		}
		if (type == Calendar.MONTH || type == Calendar.YEAR) {
			gc1.clear(Calendar.DATE);
			gc2.clear(Calendar.DATE);
		}
		if (type == Calendar.YEAR) {
			gc1.clear(Calendar.MONTH);
			gc2.clear(Calendar.MONTH);
		}
		while (gc1.before(gc2)) {
			gc1.add(type, 1);
			elapsed++;
		}
		return elapsed;
	}

	/**
	 * All elaspsed types based on date and current Date
	 * 
	 * @param date
	 *            Date
	 * @param type
	 *            int (Calendar.FIELD_NAME)
	 * 
	 * @return int number of elapsed "type"
	 */
	private static int elapsed(Date date, int type) {
		return elapsed(date, new Date(), type);
	}

	/**
	 * All elaspsed types
	 * 
	 * @param d1
	 *            Date
	 * @param d2
	 *            Date
	 * @param type
	 *            int (Calendar.FIELD_NAME)
	 * 
	 * @return int number of elapsed "type"
	 */
	private static int elapsed(Date d1, Date d2, int type) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		GregorianCalendar g1 = new GregorianCalendar(cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		cal.setTime(d2);
		GregorianCalendar g2 = new GregorianCalendar(cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
		return elapsed(g1, g2, type);
	}

	/**
	 * 计算月的开始时间(2006-08-01 00:00:00)
	 * 
	 * @param when
	 * @return
	 */
	public static Date getStartOfMonth(Date when) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(when);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 计算月份的结束时间(2006-08-31 23:59:59)
	 * 
	 * @param when
	 * @return
	 */
	public static Date getEndOFMonth(Date when) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(when);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}

	/**
	 * 计算天的开始时间(2006-08-02 00:00:00)
	 * 
	 * @param when
	 * @return
	 */
	public static Date getStartOfDay(Date when) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(when);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 计算天的结束时间(2006-08-02 23:59:59)
	 * 
	 * @param when
	 * @return
	 */
	public static Date getEndOfDay(Date when) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getStartOfDay(when));
		cal.add(Calendar.DATE, 1);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}

	public static  String[] convertWeekByDate(Date time) {  
		         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
		           Calendar cal = Calendar.getInstance();  
		          cal.setTime(time);  
		         //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
	         int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		         if(1 == dayWeek) {  
		             cal.add(Calendar.DAY_OF_MONTH, -1);  
		         }  
		         System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期  
		          cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
		        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		         cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值   
		        String imptimeBegin = sdf.format(cal.getTime());  
		         System.out.println("所在周星期一的日期："+imptimeBegin);  
//		         List<String> stenList = new LinkedList<String>();
//		         stenList.add(imptimeBegin);
		         cal.add(Calendar.DATE, 6);  
		         String imptimeEnd = sdf.format(cal.getTime());  
		         System.out.println("所在周星期日的日期："+imptimeEnd);  
//		         stenList.add(imptimeEnd);
		         String[] result = {imptimeBegin,imptimeEnd};
		         return result;
		      }  
	
	/**
	 * 取得制定日期的月最后一天
	 * @param date
	 * @return
	 */
	
	public static String getMonthEndDate(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(GregorianCalendar.MONTH,1);
		gc.add(GregorianCalendar.DATE,-date.getDate());
		Date dateTemp = gc.getTime();
		return date2String(dateTemp);
	}
	
	private static final Map<String, DateFormat> DFS = new HashMap<String, DateFormat>();

	public static DateFormat getFormat(String pattern) {
		DateFormat format = DFS.get(pattern);
		if (format == null) {
			format = new SimpleDateFormat(pattern);
			DFS.put(pattern, format);
		}
		return format;
	}

	public static Date parse(String source, String pattern) {
		if (source == null) {
			return null;
		}
		Date date;
		try {
			date = getFormat(pattern).parse(source);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		return getFormat(pattern).format(date);
	}
	
	
	 /** 
     * 获取某年第一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getCurrYearFirstDay(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        return  calendar.getTime();  
    }  
      
    /** 
     * 获取某年最后一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getCurrYearLastDay(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        return calendar.getTime();  
    }  
    
    /**
	 * 将时间转换为字符串 yyyy
	 * 
	 * @param date
	 * @return
	 */
    public static String date2StrYear(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		String dateString = formatter.format(date);
		return dateString;
	}

    
    
   
    /**
     * 根据两个时间获得日期集合
     * @param date1
     * @param date2
     * @return
     */
	public static List<String> getAllDays(String date1, String date2) {
		
		List list = new ArrayList();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();

		try {
			startDay.setTime(format.parse(date1));
			endDay.setTime(format.parse(date2));
		} catch (ParseException e) {
		}

		// 给出的日期开始日比终了日大则不执行打印
		if (startDay.compareTo(endDay) >= 0) {
			return list;
		}
		// 现在打印中的日期
		Calendar currentPrintDay = startDay;
		while (true) {
			// 日期加一后判断是否达到终了日，达到则终止打印
			if (currentPrintDay.compareTo(endDay) == 0) {
				list.add(format.format(currentPrintDay.getTime()));
				//System.out.println(format.format(currentPrintDay.getTime()));
				break;
			}
			list.add(format.format(currentPrintDay.getTime()));
			// 日期加一
			currentPrintDay.add(Calendar.DATE, 1);
		}
		return list;
	}   

    /**
     * 根据两个时间获得周集合
     * @param start YYYY-MM
     * @param end   YYYY-MM
     * @return
     */
	public static List<String> getAllWeeks(String strStartDate, String strEndDate) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = df.parse(strStartDate);
			//不包涵本周
			//endDate = df.parse(strEndDate);
			//包涵本周
			String[] str = DateUtils.convertWeekByDate(DateUtils.string2Date(strEndDate));
			endDate = DateUtils.string2Date(str[1]);
		} catch (ParseException e) {
			System.out.println("非法的日期格式,无法进行转换");
			e.printStackTrace();
		}
		List list = new ArrayList();
		while (startDate.compareTo(endDate) <= 0) {
			if (startDate.getDay() == 0){
				list.add(DateUtils.date2String(startDate));
			}
			startDate.setDate(startDate.getDate() + 1);
		}
		return list;
	} 
	
	/**
     * 根据两个时间获得月集合
     * @param date1
     * @param date2
     * @return
     */
    public static List<String> getAllMonths(String date1, String date2) {
    	date1 = date2String1(string2Date(date1)) + "-01";
    	date2 = date2String1(string2Date(date2)) + "-01";
		List list = new ArrayList();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		try {
			startDay.setTime(format.parse(date1));
			endDay.setTime(format.parse(date2));
		} catch (ParseException e) {
		}
//		if (startDay.compareTo(endDay) >= 0) {
//			return list;
//		}
		Calendar currentPrintDay = startDay;
		while (true) {
			if (currentPrintDay.compareTo(endDay) > 0) {
				break;
			}
			list.add(format.format(currentPrintDay.getTime()));
			currentPrintDay.add(Calendar.MONTH, 1);
		}
		return list;
	}    
    
    /**
     * 根据两个时间获得年集合
     * @param date1
     * @param date2
     * @return
     */
    public static List<String> getAllYears(String date1, String date2) {
		List list = new ArrayList();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		try {
			startDay.setTime(format.parse(date1));
			endDay.setTime(format.parse(date2));
		} catch (ParseException e) {
		}
//		if (startDay.compareTo(endDay) >= 0) {
//			return list;
//		}
		Calendar currentPrintDay = startDay;
		while (true) {
			if (currentPrintDay.compareTo(endDay) > 0) {
				break;
			}
			list.add(format.format(currentPrintDay.getTime()));
			currentPrintDay.add(Calendar.YEAR, 1);
		}
		return list;
	}    

	/**
	 * 取得制定日期的月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getLastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return date2String(cal.getTime());
	}

	/**
	 * 取得制定日期的月第一天
	 * 
	 * @param date
	 * @return
	 */
	public static String getFirstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		return date2String(cal.getTime());
	}    
	
	/**
	 * 日期比较 data1 > date2 返回true
	 */
	public static boolean dateCompare(Date date1,Date date2)
	{
		 boolean dateComPareFlag = false;
		  if (date1.compareTo(date2) >=0) {
		   dateComPareFlag = true; 
		  }
		  return dateComPareFlag;
	}
	
	public static void main(String[] args) throws Exception {
		
		String s1="2008-01-25 09:12:19";
		String s2="2008-01-25 09:12:09";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date1 = df.parse(s1);
		Date date2 = df.parse(s2);
		
		System.out.println(dateCompare(date1, date2));
	}
    
    

    /**
     * 根据两个时间获得月份集合
     * @param start YYYY-MM
     * @param end   YYYY-MM
     * @return
     
    public static List<String> getAllMonths1(String start, String end){
        String splitSign="-";
        String regex="\\d{4}"+splitSign+"(([0][1-9])|([1][012]))"; //判断YYYY-MM时间格式的正则表达式
        if(!start.matches(regex) || !end.matches(regex)) return new ArrayList();
        
        List<String> list=new ArrayList<String>();
        if(start.compareTo(end)>0){
            //start大于end日期时，互换
            String temp=start;
            start=end;
            end=temp;
        }
        
        String temp=start; //从最小月份开始
        while(temp.compareTo(start)>=0 && temp.compareTo(end)<0){
            list.add(temp); //首先加上最小月份,接着计算下一个月份
            String[] arr=temp.split(splitSign);
            int year=Integer.valueOf(arr[0]);
            int month=Integer.valueOf(arr[1])+1;
            if(month>12){
                month=1;
                year++;
            }
            if(month<10){//补0操作
                temp=year+splitSign+"0"+month;
            }else{
                temp=year+splitSign+month;
            }
        }
        
        int size=list.size();
        List result=new ArrayList();
        for(int i=0;i<size;i++){
        	result.add(list.get(i));
//            System.out.println(result.get(i));
        }
        return result;
    }*/
	public static Date getDate(String pagetime, String dateformat) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
		Date date = dateFormat.parse(pagetime);
		return date;
	}

	public static Date getDate(String pagetime, String dateformat, String timezone) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		Date date = dateFormat.parse(pagetime);
		return date;
	}

	public static Date getDate(String pagetime, String dateformat, Locale locale) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(dateformat, locale);
		Date date = dateFormat.parse(pagetime);
		return date;
	}

	public static Date getDate(String pagetime, String dateformat, Locale locale, String timezone) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(dateformat, locale);
		if (timezone != null) {
			dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		}
		Date date = dateFormat.parse(pagetime);
		return date;
	}
	
	
	public static String getDateStr(Date date)
	{
		return shortDayformater.format(date);
	}
	
	public static String getLongDateStr(Date date)
	{
		return longDayformater.format(date);
	}
	
	/**
	 * 对指定的日期，进行相加几天或者相减几天
	 * To change this template use File | Settings | File Templates.<br/>
	 * User: huijun.zheng<br/>
	 * Date: 2014-9-23<br/>
	 * Time: 下午6:15:05<br/>
	 * @param date 指定日期
	 * @param amount 相加(正数)或者相减（负数)
	 * @return 20140923 <br/>
	 */
	public static String getDateSectionStr(Date date,int amount)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, amount);
		Date d = c.getTime();
		return shortDayformater.format(d);
	}
}
