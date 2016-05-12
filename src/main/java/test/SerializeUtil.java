package test;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SerializeUtil {
	 /**
     * 序列化
     * 
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 反序列化
     * 
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }
    
    
    public static void main(String []args) throws UnsupportedEncodingException
    { 
//    	List<String> list= new ArrayList<String>();
//    	list.add("aaaaasdfasdfasdddddddddddddddddddddddddddddddddddddddddddddddd");
//    	list.add("bbbbasdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasdf");
//    	
//    	byte[] bb=serialize(list);
//    	String recString=new String(bb,"UTF-8");
//    	System.out.println("str:"+recString);
//    	
//    	byte[] bbb=recString.getBytes();
//    	String recString1=new String(bbb,"UTF-8");
//    	System.out.println("str1:"+recString1);
//    	@SuppressWarnings("unchecked")
//		List<String> l=(List<String>)unserialize(bb);
//    	for(String sss:l)
//    	{
//    		System.out.println(sss);
//    	}
    	
    	try{ 
    	HashMap map = new HashMap();
    	HashMap map2 = new HashMap();
    	HashMap map3 = new HashMap();
    	map3.put("10001", Integer.parseInt("123"));
    	map3.put("10002", Integer.parseInt("456"));
    	
    	map2.put( "TABLE1" ,  map3 );
    	map.put( "2016-01-02"  , map2);
    	System.out.println( map.toString() );
    	
    	byte[] bb=serialize(map);
    	RedisDBPool.getRedisConn().set("2016-01-01".getBytes(),bb);
    	
    	//
    	Object obj = RedisDBPool.getRedisConn().get("2016-01-01".getBytes());
    	byte b[]  = (byte[]) obj;
    	HashMap mp =(HashMap )unserialize(b);
     	System.out.println("序列化后的数据" +  mp.toString() );
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
}