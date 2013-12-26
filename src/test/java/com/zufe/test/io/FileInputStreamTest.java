package com.zufe.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileInputStreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			FileOutputStream fos = new FileOutputStream(new File("D:\\java_test\\rrp.text"));
			Long start = System.currentTimeMillis();
			
			FileInputStream fis = new FileInputStream(new File("D:\\java_test\\rrp.log"));
			byte[] b = new byte[fis.available()];
			while(fis.read(b)!=-1){
//				System.out.println(new String(b));
				fos.write(b);
			}
			fis.close();
			System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
			
			start = System.currentTimeMillis();
			
			fis = new FileInputStream(new File("D:\\java_test\\rrp.log"));
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			while(bis.read(b)!=-1){
//				System.out.println(new String(b));
				bos.write(b);
			}
			fis.close();
			System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
			
			start = System.currentTimeMillis();
			
			fis = new FileInputStream(new File("D:\\java_test\\rrp.log"));
			FileChannel channel = fis.getChannel();
			FileChannel writeChannel = fos.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(fis.available());
			while(true){
				buffer.clear();
				int len = channel.read(buffer);
				if(len==-1){
					break;
				}
				buffer.flip();
				writeChannel.write(buffer);
			}
			channel.close();
			fis.close();
			
			System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
