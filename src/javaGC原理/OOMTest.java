package javaGC原理;

import java.util.ArrayList;
import java.util.*;
import java.lang.*;

/**
 * -verbose:gc -Xmn5M -Xms10M -Xmx10M -XX:MaxPermSize=1M -XX:+PrintGC
 */
public class OOMTest{
 
        public static void main(String... args){
                List<String> list = new ArrayList<String>();
                while(true){
                        list.add(UUID.randomUUID().toString().intern());
                }
        }
 
}