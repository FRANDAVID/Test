package AAAAAAlearnTmp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Rain on 16/2/13.
 */
public class MapTest {
    public static void main(String[] args) {
        Map linkedMap = new LinkedHashMap<Integer, Integer>();
        linkedMap.put(1, 2);
        linkedMap.put(8, 4);
        System.out.println(linkedMap);
        Map treeMap = new TreeMap<Integer, Integer>();
        treeMap.put(3, 2);
        treeMap.put(1, 3);
        treeMap.put(2, 4);
        System.out.println(treeMap);
        //language=JSON
        String json = "";

    }
}
