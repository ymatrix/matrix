package com.zufe.junit.java.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jyl
 * @version 创建时间：2013-6-19 上午9:57:08
 * 类说明
 */
public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = new ArrayList();
		List<Integer> list2 = new ArrayList(1000000);
		
		Long time = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			list.add(i);
		}
		System.out.println(System.currentTimeMillis()-time);
		
		time = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			list2.add(i);
		}
		System.out.println(System.currentTimeMillis()-time);
	}

}
