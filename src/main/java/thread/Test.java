package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum + "";
    }
}
public class Test {
	public static void main(String[] args) {
    /*    ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<String> result = executor.submit(task);
        
        executor.shutdown();
          
        System.out.println("主线程在执行任务");
         
        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        Thread b = new Thread() {
        	public void run() {
        		System.out.println("hello");
        	}
        };
        b.start(); 
        
        try {
          b.join(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    } 
}
