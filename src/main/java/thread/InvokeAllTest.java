package thread;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class CallableTest<V> implements Callable<Integer> {
	private V v1;
	public CallableTest (V i){
		this.v1 = i;
	}
	public Integer call () {
		try{
			//Thread.sleep(1000 * 10);
		}catch(Exception e) {
			e.getMessage();
		}
		
		return  (Integer) v1 * 2 ;
	}
}

public class InvokeAllTest {
	ExecutorService exec = Executors.newCachedThreadPool();
	
	private void run () throws Exception {
		List tasks = new ArrayList();
		for ( int i =0 ; i <= 100; i ++) {
			CallableTest<Integer> t = new CallableTest<Integer>(new Integer(i)  );
			tasks.add(  t  );
		}
		
		List <Future<Integer> > listFuture = exec.invokeAll(tasks,1,TimeUnit.SECONDS);
		exec.shutdown();
		Iterator<Future<Integer>> it = listFuture.iterator();
		int i =0 ; 
		while (it.hasNext()) {
			System.out.println("loop" + i );
			Future ig = it.next();
			try{
				System.out.println(ig.get());
			}catch(Exception e) {
				e.getMessage();
			}
			i++;
		}
		System.out.println("over");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvokeAllTest test = new InvokeAllTest();
		try{
			test.run();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
