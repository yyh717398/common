package com.yangyuhao.common.utils;

import java.io.File;

public class FileUtil {
	/**
	 * 
	 * @Title: getExtendName 
	 * @Description: 给定一个文件，返回扩展名
	 * @param fileName
	 * @return
	 * @return: String
	 */
	public static String getExtendName(String fileName){
		if(!StringUtil.hasText(fileName) || !fileName.contains(".")){
			throw new RuntimeException("不是一个文件");
		}
		return fileName.substring(fileName.lastIndexOf("."));
	}
	/**
	 * 
	 * @Title: getTempDirectory 
	 * @Description: 返回操作系统的临时目录
	 * @return
	 * @return: File
	 */
	public static File getTempDirectory(){
		
		String path = System.getProperty("java.io.tmpdir");
		return new File(path);
	}
	/**
	 * 
	 * @Title: getUserDirectory 
	 * @Description: 返回操作系统用户目录
	 * @return
	 * @return: File
	 */
	public static File getUserDirectory(){
		String path = System.getProperty("user.home");
		return new File(path);
	}
	
	
	
}
