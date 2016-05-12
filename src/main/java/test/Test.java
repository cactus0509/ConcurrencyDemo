package test;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.print.DocFlavor.BYTE_ARRAY;

public class Test {

	public static int getInt() {
		byte source[] = new byte[] { 0x00, 0x00, 0x00, 0x05 };
		int nIndex = 0;
		int result = (((source[nIndex + 3] & 0xff) << 24) | ((source[nIndex + 2] & 0xff) << 16)
				| ((source[nIndex + 1] & 0xff) << 8) | (source[nIndex] & 0xff));

		System.out.println(result);
		return result;
	}

	public final static int swabInt(int v) {
		return (v >>> 24) | (v << 24) | ((v << 8) & 0x00FF0000) | ((v >> 8) & 0x0000FF00);
	}

	public static int decodeInt(final byte[] source, int nIndex, int byteOrder) {
		int result = 0;

		if (byteOrder == 1) {
			result = (((source[nIndex + 3] & 0xff) << 24) | ((source[nIndex + 2] & 0xff) << 16)
					| ((source[nIndex + 1] & 0xff) << 8) | (source[nIndex] & 0xff));
		} else // ByteOrder.Big_Endian
		{
			result = (int) (((source[nIndex] & 0xff) << 24) | ((source[nIndex + 1] & 0xff) << 16)
					| ((source[nIndex + 2] & 0xff) << 8) | (source[nIndex + 3] & 0xff));
		}
		return result;
	}

	public void SystemByteCopy() {
		int[] tset1 = new int[] { 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(Arrays.toString(tset1));
		int[] test2 = new int[tset1.length];
		System.arraycopy(tset1, 0, test2, 4, 2);
		System.out.println(Arrays.toString(test2));
		test2[0] = 8;
		test2[1] = 88;
		System.out.println(Arrays.toString(test2));
	}

	public static  byte[] getByteArr(int i) {
		return new byte[] { (byte) (( i >> 24) & 0xFF), (byte) ((i >> 16) & 0xFF), (byte) ((i >> 8) & 0xFF),
				(byte) ((i & 0xFF)) };
	}
	
	public static  int byte2Int(byte[] b ) {
		int i = 0;
		i = ( b[0] >> 24 ) & 0xff 
		    | ( b[1] >> 16 ) & 0xff  
		    | ( b[2] >> 8 ) & 0xff 
		    | ( b[3]) & 0xff ;
		return  i;
	}
	
	public static void getV ( final   byte  i[] ) {
		 i[0] = 3 ;
	}
	
	public static void main(String args[]) { 
//		ExecutorService executor = Executors.newCachedThreadPool();
//		Test test = new Test();
//		MyThread t = test.new MyThread("t1");
//		MyThread t2 = test.new MyThread("t2");
//		executor.execute(t);
//		executor.execute(t2);
//		executor.shutdown();
	
//		for ( int i = 0 ;i < 100 ; i ++ ) {
//			System.out.println( "end" + i % 10 );
//		}
		System.out.println(Test.class);
		
		 List<String> stringArray = new ArrayList<String>();
         for (int i = 0; i < 1440; i++) {
             stringArray.add("{\"x\":0}");
         }
         
         String str[] = stringArray.toArray(new String[0]);
         
         for (String x : str) {
        	 System.out.println( x );
         }
		
	}
	
	
	class MyThread implements Runnable {
		
		String name = null;
		public MyThread (String name) {
			this.name = name ;
			Thread.currentThread().setName(name);
			System.out.println( Thread.currentThread().getId());
		}
		public void run(){
			int i = 0;
			try{
				while ( i < 2000)  {
					 System.out.println(  this.name + ":" + i );
					 Thread.sleep(1000); 
				}
			}catch(Exception e) {
				e.getMessage();
			}
			System.out.println("quit");
		}
	}
	
	
	public static int getNum (int arr[],int t) {
		int iRet = -1;
		int iStart = 0 ;
		int iEnd = arr.length -1;
		while ( true ) {
			if ( iStart > iEnd   ) {
				iRet = -1;
				break;
			}
			
			int iMid =  (iStart + iEnd ) / 2 ;

			System.out.println( iStart + ":" + iEnd + ":" + iMid );
			if ( arr[iMid] > t ) {
				iEnd = iMid  -1 ;
			}else if (   arr[iMid] < t  ) {
				iStart = iMid + 1 ;
			} else  {
				iRet = iMid ; 
				break;
			}
			
		}
		
		return iRet;
	}
	

	public static int getNum2 (int x[],int t) {
		int iRet = -1;
		int iStart = 0 ;
		int iEnd = x.length -1;
		
		while ( iStart + 1  < iEnd ) { 

			int iMid =  (iStart + iEnd ) / 2 ;
			System.out.println( iStart + ":" + iEnd + ":" + iMid  + ":" +  x[iMid]);
			if  ( x[iMid] < t    ) {
				iStart = iMid;
			}else {
			    iEnd = iMid ;
			}
			
		}
		
		iRet = iEnd;
		if (  iRet >= x.length  -1  || x[iRet] != t  ) {
			 iRet =  -1;
		}
		
		return iRet;
	}
	


}
