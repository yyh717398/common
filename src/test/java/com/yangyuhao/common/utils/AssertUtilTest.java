package com.yangyuhao.common.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.Test;

public class AssertUtilTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testIsTrue() {
		try {
			AssertUtil.isTrue(1>2, "1不会大于2");
		} catch (AssertException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println("程序出现异常 请联系管理员");
		}
	}

	@Test
	public void testIsFalse() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotNull() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsNull() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotEmptyCollectionOfQString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotEmptyMapOfQQString() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasText() {
		
		try {
			String username = "abc ";
			AssertUtil.hasText(username, "用户名不能为空");
		} catch (AssertException e) {
			
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("程序出现异常 请联系管理员");
		}
		
	}

	@Test
	public void testGreaterThanZero() {
		try {
			AssertUtil.greaterThanZero(new BigDecimal(-1), "值不能小于0");

		} catch (AssertException e) {
			
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("程序出现异常 请联系管理员");
		}
	}

}
