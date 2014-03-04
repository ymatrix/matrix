package com.zufe.utils;
/**       
 * 这里用一句话描述这个类的作用
 *
 * @author 蒋永亮         
 * @version 1.00  2011-8-31
 * 
 */
public class ImageUtil {

	/**
	 * 根据传入的文件重命名
	 *
	 * @param fileName 待重命名文件名
	 * @return TODO
	 */
	public static String randomRename(String fileName){
		String[] split = fileName.split("\\.");// 将文件名已.的形式拆分
		String extendFile = "." + split[split.length - 1].toLowerCase(); // 获文件的有效后缀
		
		//获取当前的时间戳
		String newName = String.valueOf(System.currentTimeMillis());
		return newName+extendFile;
	}
	
	
}
