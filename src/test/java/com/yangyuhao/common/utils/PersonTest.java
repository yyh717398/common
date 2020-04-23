package com.yangyuhao.common.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		List<Person> list = new ArrayList<Person>();
		for (int i = 0; i < 10000; i++) {
			Person p = new Person();
			p.setName(StringUtil.generateChineseName());
			p.setAge(RandomUtil.random(1, 120));
			p.setAbout(StringUtil.randomChineseString(140));
			Calendar c = Calendar.getInstance();
			c.set(2010, 0, 1);
			Date random = DateUtil.random(c.getTime(), new Date());
			p.setCreated(random);
			list.add(p);
			System.out.println(i+1+" "+p);
		}
		
		
	}

}
