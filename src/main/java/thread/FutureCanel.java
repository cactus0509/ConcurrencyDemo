package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureCanel {
	
	private void run (){
		ExecutorService exec  = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	/*	Callable b = new Callable() {
			public Integer call () throws Exception {
				Thread.sleep(10000);
				return new Integer(1);
			}
		}; 
		*/
		Runnable r = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(10000);
			}
			
		};
		exec.execute(r);
		exec.submit(r);
		
	/*	Future<Integer> f = exec.submit(b);
		try{
			Integer in = f.get(1,TimeUnit.SECONDS);
			System.out.println(in.intValue());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			f.cancel(true);
		}*/
		exec.shutdown();
		
	}
	public static void main(String args[]) {
		FutureCanel fc =new FutureCanel();
		fc.run();
	}
}
