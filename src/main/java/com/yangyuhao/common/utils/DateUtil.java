package com.yangyuhao.common.utils;

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
	
}
