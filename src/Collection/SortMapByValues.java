package Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
//http://www.codeceo.com/article/java-hashmap-value-sort.html
//Java面试题：如何对HashMap按键值排序
public class SortMapByValues {

    public static void main(String[] args) {

        Map<String,Integer> aMap = new HashMap<String,Integer>();

        // adding keys and values
        aMap.put("Five", 5);
        aMap.put("Seven", 7);
        aMap.put("Eight", 8);
        aMap.put("One",1);
        aMap.put("Two",2);
        aMap.put("Three", 3);

        sortMapByValues(aMap);

    }

    private static void sortMapByValues(Map<String, Integer> aMap) {

        Set<Entry<String,Integer>> mapEntries = aMap.entrySet();

        System.out.println("Values and Keys before sorting ");
        for(Entry<String,Integer> entry : mapEntries) {
            System.out.println(entry.getValue() + " - "+ entry.getKey());
        }

        // used linked list to sort, because insertion of elements in linked list is faster than an array list. 
        List<Entry<String,Integer>> aList = new LinkedList<Entry<String,Integer>>(mapEntries);

        // sorting the List
        Collections.sort(aList, new Comparator<Entry<String,Integer>>() {

            @Override
            public int compare(Entry<String, Integer> ele1,
                    Entry<String, Integer> ele2) {

                return ele1.getValue().compareTo(ele2.getValue());
            }
        });

        // Storing the list into Linked HashMap to preserve the order of insertion. 
        Map<String,Integer> aMap2 = new LinkedHashMap<String, Integer>();
        for(Entry<String,Integer> entry: aList) {
            aMap2.put(entry.getKey(), entry.getValue());
        }

        // printing values after soring of map
        System.out.println("Value " + " - " + "Key");
        for(Entry<String,Integer> entry : aMap2.entrySet()) {
            System.out.println(entry.getValue() + " - " + entry.getKey());
        }

    }
}