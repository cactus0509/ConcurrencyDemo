package test;

import java.util.ArrayList;
import java.util.List;

/*VM args:-Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 *
 * -Xms:堆的最小值；-Xmx：堆的最大值
 *
 * */
public class OOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int n = 0;
        while (true) {
           // list.add(new OOMObject());
        	list.add(String.valueOf(n++).intern()  );
        }
    }
}

