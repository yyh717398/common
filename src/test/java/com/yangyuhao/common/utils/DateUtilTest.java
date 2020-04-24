package com.yangyuhao.common.utils;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testRandom() {
		Calendar c = Calendar.getInstance();
		c.set(2010, 9, 1);

		Date date = DateUtil.random(c.getTime(), new Date());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd ");
		String format = fm.format(date);
		System.out.println(format);
	}

	@Test
	public void testGetInitMonth() {
		Calendar c = Calendar.getInstance();
		//月份 0-11
		c.set(2012, 7, 2);
		Date initMonth = DateUtil.getInitMonth(c.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(initMonth);
		System.out.println(format2);
	}
	
	@Test
	public void testGetEndMonth(){
		Calendar c = Calendar.getInstance();
		//月份 0-11
		c.set(2011, 2, 2);
		Date endMonth = DateUtil.getEndMonth(c.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format2 = format.format(endMonth);
		System.out.println(format2);
	}
	
	@Test//根据日期计算年龄
	public void testGetAgeByBirthday(){
		Calendar c = Calendar.getInstance();
		c.set(1998, 3, 23);
		int ageByBirthday = DateUtil.getAgeByBirthday(c.getTime());
		System.out.println(ageByBirthday);
	}
}
