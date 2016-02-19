package 内存溢出;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
* @ClassName: HeapOOM 
*
 */
public class HeapOOM {
    static class OOMObject{
        
    }
    
    public static void main(String[] args) {
         List<OOMObject> list = new ArrayList<OOMObject>(2);
        while(true){
            list.add(new OOMObject());
        }
    }
}