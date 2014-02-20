package com.zufe.concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor = Executors.newFixedThreadPool(2);
//		ExecutorService executor = Executors.newCachedThreadPool();
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		for(int i=0;i<10;i++){
			executor.submit(new myThread(i));
		}
	}

}

class myThread extends Thread{

	Integer i;
	
	public myThread(int num){
		i = num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread()+"-----"+i);
	}
	
}
