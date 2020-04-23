package com.yangyuhao.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testHasLength() {
		boolean hasLength = StringUtil.hasLength(" ");
		System.out.println(hasLength);
	}

	@Test
	public void testHasText() {
		boolean hasText = StringUtil.hasText(" ");
		System.out.println(hasText);
	}

	@Test
	public void testRandomChineseString() {
		String randomChineseString = StringUtil.randomChineseString();
		System.out.println(randomChineseString);
	}

	@Test
	public void testRandomChineseStringInt() {
		String randomChineseString = StringUtil.randomChineseString(100);
		System.out.println(randomChineseString);
	}

	@Test
	public void testGenerateChineseName() {
		for (int i = 0; i < 10; i++) {
			String generateChineseName = StringUtil.generateChineseName();
			System.out.println(generateChineseName);
		}
		
	}

}
