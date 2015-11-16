package generic;
/**
 * 泛型类
 * @param <K>
 */
class Test<K>{
    private K obj;
    public void setValue(K obj){
        this.obj =obj;
    }
    public K getValue(){
        System.out.println(obj.getClass().getName());
        return obj;
    }
}
/**
 * 测试泛型类
 */
public class TestOne {
    public static void main(String[] args) {
        //测试Integer泛型
        Test<Integer> t1 = new Test<Integer>();
        t1.setValue(5);
        Integer i = t1.getValue();
        System.out.println(i);
        //测试Double泛型
        Test<Double> t2 = new Test<Double>();
        t2.setValue(5.55D);
        Double d = t2.getValue();
        System.out.println(d);
        //测试String泛型
        Test<String> t3 = new Test<String>();
        t3.setValue("hello world");
        String str =t3.getValue();
        System.out.println(str);
    }
}