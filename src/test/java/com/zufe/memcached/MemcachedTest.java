package com.zufe.memcached;
//
//import com.whalin.MemCached.MemCachedClient;
//import com.whalin.MemCached.SockIOPool;

/**
 * @author jyl
 * @version 创建时间：2013-7-16 下午4:34:16
 * 类说明
 */
public class MemcachedTest {

//	public static void main(String[] args) {
//		// memcached should be running on port 11211 but NOT on 11212
//
//		String[] servers = { "192.168.1.31:11111" };
//		SockIOPool pool = SockIOPool.getInstance();
//		pool.setServers(servers);
//		pool.setFailover(true);
//		pool.setInitConn(10);
//		pool.setMinConn(5);
//		pool.setMaxConn(250);
//		// pool.setMaintSleep( 30 );
//		pool.setNagle(false);
//		pool.setSocketTO(3000);
//		pool.setAliveCheck(true);
//		pool.initialize();
//
//		MemCachedClient mcc = new MemCachedClient();
//
//		// turn off most memcached client logging:
//		// Logger.getLogger( MemCachedClient.class.getName() ).setLevel(
//		// com.schooner.MemCached.Logger. );
//
//		for (int i = 0; i < 10; i++) {
//			boolean success = mcc.set("" + i, "Hello!");
//			String result = (String) mcc.get("" + i);
//			System.out.println(String.format("set( %d ): %s", i, success));
//			System.out.println(String.format("get( %d ): %s", i, result));
//		}
//
//		System.out.println("\n\t -- sleeping --\n");
//		try {
//			Thread.sleep(10000);
//		} catch (Exception ex) {
//		}
//
//		for (int i = 0; i < 10; i++) {
//			boolean success = mcc.set("" + i, "Hello!");
//			String result = (String) mcc.get("" + i);
//			System.out.println(String.format("set( %d ): %s", i, success));
//			System.out.println(String.format("get( %d ): %s", i, result));
//		}
//	}

}
