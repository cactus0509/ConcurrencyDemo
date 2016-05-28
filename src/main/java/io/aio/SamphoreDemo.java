package io.aio;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;

public class SamphoreDemo {

	public Semaphore samp = new Semaphore(5);

	public class MyCallable implements Callable {
		private String name;

		public MyCallable(String name) {
			this.name = name;
		}

		@Override
		public Object call() throws Exception {
			// TODO Auto-generated method stub
			try {
				samp.acquire();
				System.out.println(this.name + "come ");
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("samp length:" + samp.getQueueLength());
				samp.release();
				System.out.println(this.name + " go ");
			}
			return new Integer(2);
		}
	}

	public SamphoreDemo() {

	}

	public void run (){
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> list  = new ArrayList<Future<Integer>>();
		for (int i =0 ; i < 10; i ++) { 
			list.add(  exec.submit(  new MyCallable( "therad " + i  ) ));
		}
		
		exec.shutdown();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamphoreDemo demo = new SamphoreDemo();
		demo.run();
	}

}
