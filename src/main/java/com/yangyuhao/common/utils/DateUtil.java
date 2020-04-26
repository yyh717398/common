package com.yangyuhao.common.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: DateUtil 
 * @Description: 日期工具类
 * @author: dell
 * @date: 2020年4月23日 下午9:11:23
 */
public class DateUtil {
	/**
	 * 
	 * @Title: random 
	 * @Description: 随机产生一个 min 和 max 之间的日期
	 * @param min
	 * @param max
	 * @return
	 * @return: Date
	 */
	public static Date random(Date min,Date max){
		long t1 = min.getTime();
		long t2 = max.getTime();
		if(t1>=t2){
			throw new RuntimeException("时间格式不正确");
		}
		
		long t = (long)(Math.random()*(t2-t1)+t1);
		return new Date(t);
		
	}
	
	/**
	 * 
	 * @Title: getInitMonth 
	 * @Description: 根据传入的日期返回乐器的月初
	 * @return
	 * @return: Date
	 */
	public static Date getInitMonth(Date date){
		//初始化一个日历类，设置日期，加减日期，方便程序员对日期做运算
		Calendar c = Calendar.getInstance();
		//用传入日期去初始化日历类
		c.setTime(date);
		//设置这个月的月初,这个月的日期为第一天
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	/**
	 * 
	 * @Title: getEndMonth 
	 * @Description: 返回一个月的最后一天
	 * @param date
	 * @return
	 * @return: Date
	 */
	public static Date getEndMonth(Date date){
		//日历类
		Calendar c = Calendar.getInstance();
		//初始化日历类
		c.setTime(date);
		//让日历类的月份+1
		c.add(Calendar.MONTH, 1);
		//再变为月初的 0h0m0s 返回一个日期
		Date initMonth = getInitMonth(c.getTime());
		//初始化日历类
		c.setTime(initMonth);
		//让秒数-1 就是上个月的月末
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}
	
	/**
	 * 
	 * @Title: getAgeByBirthday 
	 * @Description: 根据出生日期计算年龄
	 * @param birthday
	 * @return
	 * @return: int
	 */
	public static int getAgeByBirthday(Date birthday){
		//获取当前系统时间年份
		Calendar c = Calendar.getInstance();
		
		int nowYear = c.get(Calendar.YEAR);
			//月份
		int nowMonth = c.get(Calendar.MONTH);
			//日
		int nowDate = c.get(Calendar.DAY_OF_MONTH);
		//获取传入日期的年份
		Calendar c2 = Calendar.getInstance();
		c2.setTime(birthday);
		int birthdayYear = c2.get(Calendar.YEAR);
			//月份
		int birthdayMonth = c2.get(Calendar.MONTH);
			//日
		int birthdayDate = c2.get(Calendar.DAY_OF_MONTH);
		//判断出生日期不能超过当前日期
		if(birthdayYear>nowYear){
			throw new RuntimeException("传入的日期错误");
		}
		//两个年份相减，得到年龄
		int age = nowYear-birthdayYear;
		if(birthdayMonth>nowMonth){
			age--;
		
		}
		if(birthdayMonth==nowMonth && birthdayDate>nowDate){
			age--;
		}
		return age;
	}
	
}
