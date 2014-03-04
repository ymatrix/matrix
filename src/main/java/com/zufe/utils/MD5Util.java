package com.zufe.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;
/**
 * 
 * 将传入的字符串进行md5加密
 *
 * @author 蒋永亮         
 * @version 1.00  2011-8-31
 *
 */
public class MD5Util {
	
	public static String md5(String msg){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(msg!=null){
		byte[] b = msg.getBytes();
		byte[] b1 = md.digest(b);//
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(b1);
		} else {
			return "";
		}
	}

}
	