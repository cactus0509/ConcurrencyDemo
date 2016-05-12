package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

class MyThread<V extends CountDownLatch> implements Runnable {
	private String name;
	private V v1;
	private V v2;

	public MyThread(String name, V v1, V v2) {
		this.name = name;
		this.v1 = v1;
		this.v2 = v2;
	}

	public void run() {
		try {
			v1.await();
			System.out.println("thead " + this.name + "begin");
			Thread.sleep(1000);
			System.out.println("thead " + this.name + "over");
			v2.countDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class T1 {
	public long timeTasks(int iThreadCount) {

		final CountDownLatch startCount = new CountDownLatch(1); //闭锁
		final CountDownLatch endCount = new CountDownLatch(iThreadCount);
		try {
			for (int i = 0; i < iThreadCount; i++) {
				MyThread t = new MyThread("my thread" + i, startCount, endCount);
				Thread th = new Thread(t);
				th.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		long begintiem = System.nanoTime();

		try {
			startCount.countDown();
			endCount.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long costTime = System.nanoTime() - begintiem;
		return costTime;
	}

	public static void main(String args[]) {
		long beginTime = System.currentTimeMillis();
		T1 t = new T1();
		long n = t.timeTasks(10);
		//nanoseconds
		System.out.println( "countDown Time " +  n/1000000/1000  );
		System.out.println( "countDown Time " +  (System.currentTimeMillis() - beginTime )/1000  );
	}
}
