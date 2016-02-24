package javaGC原理;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rain on 16/2/19.
 * -verbose:gc -Xmn10M -Xms20M -Xmx20M -XX:+PrintGC
 */
public class JvmArgs {
    public static void main(String... args){
        List<byte[]> buffer = new ArrayList<byte[]>();
        buffer.add(new byte[10*1024*1024]);
    }
}
