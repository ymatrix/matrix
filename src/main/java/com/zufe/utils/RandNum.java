package com.zufe.utils;

import java.util.Random;

public class RandNum {
	
	public static String MakePassword(int pwdLength)
	{
	   //声明要返回的字符串
	   String tmpstr = "";
	   //密码中包含的字符数组
	   String pwdchars="abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   int length=pwdchars.length();
	   //数组索引随机数
	   int iRandNum;
	   //随机数生成器
	   Random r = new Random();
	   for(int i=0;i<pwdLength;i++)
	   {
	    //Random类的Next方法生成一个指定范围的随机数
		   iRandNum = r.nextInt(length);
	    //tmpstr随机添加一个字符
		   tmpstr += pwdchars.charAt(iRandNum);
	   }
	   return tmpstr;
	}

}
