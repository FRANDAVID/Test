package 集合.不重复的Set和HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo1_HashSet {
    /**
     * @param args
     * Set集合,无索引,不可以重复,无序(存取不一致)
     */
    public static void main(String[] args) {
//        test1();
        HashSet<Person> hs = new HashSet<>();
        hs.add(new Person("张三", 23));
        hs.add(new Person("李四", 24));
        hs.add(new Person("张三", 23));
        hs.add(new Person("李四", 24));
        hs.add(new Person("李四", 23));
        Map<String, String> test = new HashMap<>();
        Set<String> setTest = new HashSet<>();
        setTest.add(null);
        test.put(null,null);
        System.out.println(test.size());
        System.out.println(setTest.size());
        //添加引用数据类型时,若要不重复,需要重写HashCode和equals方法
        System.out.println(hs.size());
        System.out.println(hs);
    }

    private static void test1() {
        HashSet<String> hs = new HashSet<>();
        hs.add("ce");
        boolean b1 = hs.add("a");
//        boolean b2 = hs.add("a");
        hs.add("b");
        hs.add("c");
        hs.add("d");
        //HashSet 当向set集合中存储重复元素会返回false
        //HashSet 的继承体系中有重写set方法
//        System.out.println("b1 ＝ " + b1 + " b2 = " + b2);
        System.out.println(hs);

        //可以用迭代器方法就可以使用增强for循环
        for (String string : hs) {
            System.out.println(string);
        }
    }

}
