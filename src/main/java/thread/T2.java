package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class T2 {
	public static  void main(String args[]){
		ConcurrentHashMap<String,String>b = new ConcurrentHashMap<String,String>();
		
		//b.put("a", "1");
		String v = b.putIfAbsent("b", "2"); 
		v = b.putIfAbsent("b", "3");
		//如果 map 不存在key，则录入k-v. 返回null。
		//如果存在key，则直接返回旧值。
		System.out.println( v );
		System.out.println( b.toString() );
		v = b.putIfAbsent("c", "3");
		System.out.println( v );
		System.out.println( b.toString() );
	}
}
