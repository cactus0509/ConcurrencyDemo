package thread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
	
	private final ExecutorService exec =Executors.newCachedThreadPool(); 
	
	private void run () {
		ServerSocket socket = null;
		try{
			 socket = new ServerSocket(9090);
		}catch(Exception e) {
			
		}
		
		while ( ! exec.isShutdown() ) {
			 
			try{
				System.out.println("start accept thread");
				 final Socket conn = socket.accept();
				 exec.execute( new Runnable() {
					 public void run() {
						System.out.println( conn.getRemoteSocketAddress().toString());
					 }
				 });
				 
				 exec.shutdown();
				 System.out.println("will shutdown");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorServiceTest t = new ExecutorServiceTest();
		t.run();
		
	}

}
