package threadjava;
// LongTest.java的源码
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class LongFieldTest {
    
    public static void main(String[] args) {

        // 获取Person的class对象
        Class cls = Person.class; 
        // 新建AtomicLongFieldUpdater对象，传递参数是“class对象”和“long类型在类中对应的名称”
        AtomicLongFieldUpdater mAtoLong = AtomicLongFieldUpdater.newUpdater(cls, "id");
        Person person = new Person(12345678L);

        // 比较person的"id"属性，如果id的值为12345678L，则设置为1000。CAS
        mAtoLong.compareAndSet(person, 123456789L, 1000);
        System.out.println("id="+person.getId());
    }
}


