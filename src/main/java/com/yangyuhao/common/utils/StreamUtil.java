package com.yangyuhao.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {
	/**
	 * 批量关闭流
	 * 
	 * @Title: closeAll
	 * @Description: TODO
	 * @param autoCloseables
	 * @return: void
	 */
	public static void closeAll(AutoCloseable... autoCloseables) {
		
		if (autoCloseables == null || autoCloseables.length == 0) {
			throw new RuntimeException("参数异常");
		}
		for (AutoCloseable autoCloseable : autoCloseables) {
			try {
				autoCloseable.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @Title: readTextfile
	 * @Description: 读取文件,返回文件内容
	 * @param src
	 * @return
	 * @return: String
	 */
	public static String readTextfile(InputStream src) {
		byte[] b = new byte[1024];
		int len;
		try {
			while((len=src.read(b))!=-1){
				return new String(b, 0, len);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	/**
	 * 
	 * @Title: readTextFile 
	 * @Description: 传入文本对象
	 * @param file
	 * @return
	 * @return: String
	 */
	public static String readTextFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			return readTextfile(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: readTextFileList
	 * @Description: 读取文件到集合
	 * @param file
	 * @return
	 * @return: List<String>
	 */
	public static List<String> readTextFileList(File file) {
		List<String> list = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String str = "";
			while ((str = reader.readLine()) != null) {
				list.add(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
}
