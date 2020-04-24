package com.yangyuhao.common.utils;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Test;

public class FileUtilTest {


	@Test
	public void testGetExtendName() {
		String str = "";
		String extendName = FileUtil.getExtendName(str);
		System.out.println(extendName);
	}

	@Test
	public void testGetTempDirectory() {
		File tempDirectory = FileUtil.getTempDirectory();
		System.out.println(tempDirectory.toString());
	}

	@Test
	public void testGetUserDirectory() {
		File userDirectory = FileUtil.getUserDirectory();
		System.out.println(userDirectory);
	}
	

}
