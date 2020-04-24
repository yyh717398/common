package com.yangyuhao.common.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

import org.junit.AfterClass;
import org.junit.Test;

public class StreamUtilTest {

	

	@Test
	public void test() {
		String path = "C:\\Users\\dell\\Desktop\\q.txt";
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(path));
			String readTextfile = StreamUtil.readTextfile(fis);
			System.out.println(readTextfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void test2(){
		String readTextFile = StreamUtil.readTextFile(new File("C:\\Users\\dell\\Desktop\\q.txt"));
		System.out.println(readTextFile);
	}

}
