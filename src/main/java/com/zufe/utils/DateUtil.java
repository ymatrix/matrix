package com.zufe.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 常用时间操作
 * 
 */
public class DateUtil {

	public static String formart1 = "yyyy/MM/dd HH/mm/ss";
	public static String formart2 = "yyyy年MM月dd日";
	public static String formart3 = "yyyy-MM-dd";
	public static String formart4 = "yyyy年MM月dd日 HH时mm分ss秒";
	public static String formart5 = "yy-MM-dd";
	public static String formart6 = "yy年MM月dd日";
	public static String formart7 = "yy/MM/dd";
	public static String formart8 = "yyMMddHHmmss";
	public static String formart9 = "yyyy-MM-dd HH:mm:ss";
	public static String formart10 = "yyMMddHHmmsssss";
	public static String formart11 = "yyyyMMddHHmmss";
	public static String formart12 = "yyyy/MM/dd HH:mm:ss";
	/**
	 * 将long值，转换成秒的除数
	 */
	public static long SECOND = 1000;
	/**
	 * 将long值，转换成分的除数
	 */
	public static long MINUTE = 60000;
	/**
	 * 将long值，转换成小时的除数
	 */
	public static long HOURE = 360000;
	/**
	 * 将long值，转换成天的除数
	 */
	public static long DAY = 8460000;

	public static long getTimeInMillis() {
		return Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * 获取Date对象
	 * 
	 * @return
	 */
	public static Date getDate() {
		return Calendar.getInstance().getTime();
	}

	public static Date getDate(long _lTimes) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(_lTimes);
		return cal.getTime();
	}

	/**
	 * 根据long值，返回两个时间相差多少分钟
	 * 
	 * @param _lFirstTimes
	 * @param _lSecondTimes
	 * @return
	 */
	public static long compareAndReturnMinute(long _lFirstTimes,
			long _lSecondTimes) {
		return compare(_lFirstTimes, _lSecondTimes, MINUTE);
	}

	/**
	 * 根据long值，返回两个时间相差多少(秒/分钟/小时/天)
	 * 
	 * @param _lFirstTimes
	 * @param _lSecondTimes
	 * @param _lDateType
	 *            ：该值取DateUtil类中的：SECOND， MINUTE...
	 * @return
	 */
	public static long compare(long _lFirstTimes, long _lSecondTimes,
			long _lDateType) {
		return (_lFirstTimes - _lSecondTimes) / _lDateType;
	}

	/**
	 * 时间格式化,输出String类型时间。
	 * 
	 * @param _date
	 * @param _formart
	 * @return
	 */
	public static String getCurrDateStr(final String _formart) {
		Date _date = getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(_formart);
		return sdf.format(_date);
	}

	/**
	 * 时间格式化,输出String类型时间。
	 * 
	 * @param _date
	 * @param _formart
	 * @return
	 */
	public static String getDateStr(Date _date, final String _formart) {
		if (_date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(_formart);
		return sdf.format(_date);
	}

	/**
	 * 字符串转日期类型
	 * 
	 * @param _DateStr
	 * @param _formart
	 * @return
	 * @throws Exception
	 */
	public static Date getDateFromStr(String _DateStr, final String _formart)
			throws Exception {
		if (_DateStr == null)
			throw new Exception("待转换的时间不能为空");

		SimpleDateFormat sdf = new SimpleDateFormat(_formart);
		return sdf.parse(_DateStr);
	}

	/**
	 * 当前年份
	 * 
	 * @return
	 */
	public static int getCurrYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * 获取传入日期的年份
	 * 
	 * @param _date
	 * @return
	 */
	public static int getYear(Date _date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 当前月份
	 * 
	 * @return
	 */
	public static int getCurrMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	/**
	 * 当前日期号
	 * 
	 * @return
	 */
	public static int getCurrDay() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取指定年，月的最末号数。
	 * 
	 * @param _nYear
	 * @param _nMonth
	 * @return
	 */
	public static int getActualMaximumDayOfMonth(int _nYear, int _nMonth) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, _nYear);
		cal.set(Calendar.MONTH, _nMonth - 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取月初日期
	 * 
	 * @param _nYear
	 * @param _nMonth
	 * @return
	 */
	public static Date getActualStartDate(int _nYear, int _nMonth) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, _nYear);
		cal.set(Calendar.MONTH, _nMonth - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 获取月初日期
	 * 
	 * @param _date
	 * @return
	 */
	public static Date getActualStartDate(Date _date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 根据给定日期，获取月末日期，且不改变给定日期的值
	 * 
	 * @param d
	 * @return
	 */
	public static Date getActualEndDate(Date d) {
		Calendar cal = Calendar.getInstance();
		Date t_d = (Date) d.clone();
		cal.setTime(t_d);
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	public static Date getDate(int _nYear, int _nMonth, int _nDay) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, _nYear);
		cal.set(Calendar.MONTH, _nMonth - 1);
		cal.set(Calendar.DAY_OF_MONTH, _nDay);
		return cal.getTime();
	}

	/**
	 * 获取月份
	 * 
	 * @param _date
	 * @return
	 */
	public static int getMonth(Date _date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(_date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 日期相减的天数差。
	 * 
	 * @param _startDate
	 * @param _endDate
	 * @return
	 */
	public static int getSubDay(Date _startDate, Date _endDate) {
		long subSecond = (_startDate.getTime() - _endDate.getTime()) / 1000;// 除以1000是为了转换成秒
		long day = subSecond / (24 * 3600);
		return new Long(day).intValue();
	}

	/**
	 * 日期相减的月份差。
	 * 
	 * @param _startDate
	 * @param _endDate
	 * @return
	 */
	public static int getSubMonth(Date _startDate, Date _endDate) {
		return getSubDay(_startDate, _endDate) / 30;
	}

	/**
	 * 两个日期比较大小
	 * 
	 * @param _fristDate
	 * @param _secondDate
	 * @return
	 */
	public static int compareTo(Date _fristDate, Date _secondDate) {
		return _fristDate.compareTo(_secondDate);
	}

	/**
	 * 获取传入月份的第一天
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getFirstDay(Date date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date theDate = calendar.getTime();

		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first).append(
				" 00:00:00");
		return df.parse(str.toString());
	}

	/**
	 * 获取传入月份的最后一天
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getLastDay(Date date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date theDate = calendar.getTime();

		calendar.add(Calendar.MONTH, 1); // 加一个月
		calendar.set(Calendar.DATE, 1); // 设置为该月第一天
		calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
		String day_last = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_last).append(
				" 23:59:59");
		return df.parse(endStr.toString());
	}

	/**
	 * 当前日期减去几天。
	 * 
	 * @param _startDate
	 *            当前日期
	 * @param days
	 *            减去的天数
	 * @return
	 */
	public static Date getDateSubDays(Date _startDate, int days) {
		return getDateAddDays(_startDate, -days);
	}

	/**
	 * 当前日期加上几天。
	 * 
	 * @param _startDate
	 *            当前日期
	 * @param days
	 *            加上的天数
	 * @return
	 */
	public static Date getDateAddDays(Date _startDate, int days) {
		long myTime = (_startDate.getTime() / 1000) + 60 * 60 * 24 * days;
		Date newDate = (Date) _startDate.clone();
		newDate.setTime(myTime * 1000);
		return newDate;
	}

}
