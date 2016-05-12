package test; 
import java.io.BufferedInputStream;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
 

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisDBPool  { 
	
	private static JedisCluster jc  = null;
	public static String url;
	private static String user;
	private static String password;
	static Properties prop = new Properties();
	
	public static void init()
			throws Exception {
		try {
			 
	        try {  
	    		String strRedisHostList = "192.168.2.101:7001;192.168.2.101:7002;192.168.2.101:7003;";
	    		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>(); 
	    		String jcs[] = strRedisHostList.split(";");
	    		for (  int i =0 ; i <jcs.length; i++) {
	    			String jcn[] = jcs[i].split(":");
		    		jedisClusterNodes.add(new HostAndPort(jcn[0],Integer.parseInt(jcn[1].trim())));
	    		}
	    		jc = new JedisCluster(jedisClusterNodes);
	    		
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } 
		}  catch (Exception e1) { 
			e1.printStackTrace();
		}  
	}

	public static final JedisCluster getRedisConn()
			throws Exception {
		if(jc == null){
			init();
		}
		return jc; 		 
	}
} 
