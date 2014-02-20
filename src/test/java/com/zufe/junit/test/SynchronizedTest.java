package com.zufe.junit.test;

public class SynchronizedTest {
	
	public Integer count = 0;
	public Integer countB = 0;
	
	public synchronized void dowork(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
	}
	
	public void play(){
		System.out.println(Thread.currentThread().getName()+":"+countB);
		synchronized(countB){
			for(int i=0;i<10;i++){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countB++;
				System.out.println(Thread.currentThread().getName()+":"+countB);
			}
		}
		System.out.println(Thread.currentThread().getName()+":"+count);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final SynchronizedTest syn = new SynchronizedTest();
		
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				syn.play();
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				syn.play();
			}
		}.start();
		
	}

}
