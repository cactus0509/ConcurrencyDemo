package test;

import java.util.concurrent.Callable;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memorizer <A,V> implements Computable<A,V> {
	
	private final ConcurrentMap<A,Future<V>> cache = new ConcurrentHashMap<A,Future<V>>();
	
	private Memorizer <A,V> c;
	
	
	public V compute (final A arg)  throws Exception {
		while (true) {
			Future <V> f = cache.get(arg);
			if ( f == null ) {
				Callable <V> eval = new Callable<V>() {
					public V call() throws Exception {
						return c.compute(arg);
					}
				};
				FutureTask<V> ft = new FutureTask<V>(eval);
				f = cache.putIfAbsent(arg, ft);
				if ( f == null) { f = ft ; ft.run();} 
			}
			try{
				return f.get();
			}catch(Exception e) {
				throw e;
			}
		}
	}

}