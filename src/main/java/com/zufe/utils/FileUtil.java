package com.zufe.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**       
 * 这里用一句话描述这个类的作用
 *
 * @author 蒋永亮         
 * @version 1.00  2011-8-31
 * 
 */
public class FileUtil {

	
	/**
	 * 根据路径创建一系列的目录
	 * 
	 * @param path 路径
	 */
	public static void mkDirectory(String path) {
		File file;
		try {
			file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			file = null;
		}
	}
	
	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *          String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *          String
	 * @return boolean
	 */
	public static boolean delFile(String filePathAndName) {
		File myDelFile = new java.io.File(filePathAndName);
		if (!myDelFile.exists()) {
			return true;
		}
		return myDelFile.delete();
	}
	
	/**
	 * 判断文件是否存在
	 * 
	 * @param fileName
	 * @param dir
	 * @return
	 */
	public static boolean isFileExist(String file) {
		File files = new File(file);
		return (files.exists()) ? true : false;
	}
	
	/**
	 * 
	 * 根据传入的文件名随机重命名
	 *
	 * @param fileName
	 * @return TODO
	 */
	public static String randomRename(String fileName) {
		String[] split = fileName.split("\\.");// 将文件名已.的形式拆分
		String extendFile = "." + split[split.length - 1].toLowerCase(); // 获文件的有效后缀

		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmddHHmmss");
		
		Random random = new Random();
		int add = random.nextInt(10000); // 产生随机数10000以内
		String rename = sdf.format(date).toString() + add + extendFile;
		
		return rename;		
	}
}
