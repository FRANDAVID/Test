//package 属性和map转换;
//
//import org.apache.commons.beanutils.BeanUtils;
//
//import java.beans.BeanInfo;
//import java.beans.Introspector;
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 当把Person类作为BeanUtilTest的内部类时，程序出错<br>
// * java.lang.NoSuchMethodException: Property '**' has no setter method<br>
// * 本质：内部类 和 单独文件中的类的区别 <br>
// * BeanUtils.populate方法的限制：<br>
// * The class must be public, and provide a public constructor that accepts no arguments. <br>
// * This allows tools and applications to dynamically create new instances of your bean, <br>
// * without necessarily knowing what Java class name will be used ahead of time
// */
//public class BeanUtilTest {
//
//    public static void main(String[] args) {
//
//        PersonBean person = new PersonBean();
//        Map<String, Object> mp = new HashMap<String, Object>();
//        mp.put("name", "Mike");
//        mp.put("age", 25);
//        mp.put("mN", "male");
//
//        // 将map转换为bean
//        transMap2Bean2(mp, person);
//
//        System.out.println("--- transMap2Bean Map Info: ");
//        for (Map.Entry<String, Object> entry : mp.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        System.out.println("--- Bean Info: ");
//        System.out.println("name: " + person.getName());
//        System.out.println("age: " + person.getAge());
//        System.out.println("mN: " + person.getmN());
//
//        // 将javaBean 转换为map
//        Map<String, Object> map = transBean2Map(person);
//
//        System.out.println("--- transBean2Map Map Info: ");
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//    }
//
//    // Map --> Bean 2: 利用org.apache.commons.beanutils 工具类实现 Map --> Bean
//    public static void transMap2Bean2(Map<String, Object> map, Object obj) {
//        if (map == null || obj == null) {
//            return;
//        }
//        try {
//            BeanUtils.populate(obj, map);
//        } catch (Exception e) {
//            System.out.println("transMap2Bean2 Error " + e);
//        }
//    }
//
//    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
//    public static void transMap2Bean(Map<String, Object> map, Object obj) {
//
//        try {
//            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
//            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//
//            for (PropertyDescriptor property : propertyDescriptors) {
//                String key = property.getName();
//
//                if (map.containsKey(key)) {
//                    Object value = map.get(key);
//                    // 得到property对应的setter方法
//                    Method setter = property.getWriteMethod();
//                    setter.invoke(obj, value);
//                }
//
//            }
//
//        } catch (Exception e) {
//            System.out.println("transMap2Bean Error " + e);
//        }
//
//        return;
//
//    }
//
//    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
//    public static Map<String, Object> transBean2Map(Object obj) {
//
//        if(obj == null){
//            return null;
//        }
//        Map<String, Object> map = new HashMap<String, Object>();
//        try {
//            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
//            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//            for (PropertyDescriptor property : propertyDescriptors) {
//                String key = property.getName();
//
//                // 过滤class属性
//                if (!key.equals("class")) {
//                    // 得到property对应的getter方法
//                    Method getter = property.getReadMethod();
//                    Object value = getter.invoke(obj);
//
//                    map.put(key, value);
//                }
//
//            }
//        } catch (Exception e) {
//            System.out.println("transBean2Map Error " + e);
//        }
//
//        return map;
//
//    }
//}