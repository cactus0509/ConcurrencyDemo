package thread;

import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MyFutureTask {
	
	
	public static void main(String[] args) {
		
		// 第一种方式
		ExecutorService executor = Executors.newCachedThreadPool();
		Task2 task = new Task2();
		Task3 task3 = new Task3();
		Task4 task4 = new Task4();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
		Integer iRet = new Integer(1);
		FutureTask<Integer> futureTaskRunaable = new FutureTask<Integer>(task3,iRet);
		Future a1 =   executor.submit(futureTaskRunaable);
		
		Callable task5 = new Callable(){
			public Integer call() throws Exception {
				return 1;
			}
		};
		
		
		Future a = executor.submit(futureTask);
		Future b = executor.submit(task3);
		Future c = executor.submit(task4);
		Future d =executor.submit(task);
		Future e =executor.submit(task5);
		
		System.out.println("主线程在执行任务0");
		
		executor.shutdown();
		try {
			//b.cancel(true);
			//boolean bret = c.cancel(true);
			//System.out.println("task运行结果" + futureTask.get()); 
			System.out.println("task b 运行结果" + b.get());
			System.out.println("task a1 运行结果" + a1.get());
			//System.out.println("task c 运行结果" + c.get()); 
			System.out.println("task d 运行结果" + d.get());
			System.out.println("task e 运行结果" + e.get()); 
			//if (bret) { 
				//System.out.println(" b.cancel ok");
			//}
			//if (b.isCancelled()) { 
				//System.out.println(" b be canceled");
			//}
			
			if (d.isDone()) {
				System.out.println(" d is done ok"); 
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		System.out.println("所有任务执行完毕1");

	}
}

class Task2 implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		System.out.println("子线程在进行计算");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}

class Task3 implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("run  runable interface");
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			System.out.println("run  runable interface InterruptedException");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class Task4 implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		try {
			System.out.println("run  Callable interface");
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			System.out.println("run  Callable interface InterruptedException");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}


