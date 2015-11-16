package set;
import java.util.HashSet;
//http://www.importnew.com/15708.html
//
//一个按着Hash算法来存储集合中的元素，其元素值可以是NULL。它不能保证元素的排列顺序。
//同样，HashSet是不同步的，如果需要多线程访问它的话，可以用 Collections.synchronizedSet 方法来包装它：
//
//1
//Set s = Collections.synchronizedSet(new HashSet(...));
//同上一节一样，用迭代器的时候，也要注意 并发修改异常ConcurrentModificationException。
//要注意的地方是，HashSet集合判断两个元素相等不单单是equals方法，并且必须hashCode()方法返回值也要相等。
//看下面的例子：
class EuqalsObj
{
    public boolean equals(Object obj)
    {
        return true;
    }
}
  
class HashCodeObj
{
    public int hashCode()
    {
        return 1;
    }
}
  
class HashSetObj
{
    public int hashCode()
    {
        return 2;
    }
  
    public boolean equals(Object obj)
    {
        return true;
    }
}
  
public class HashSetTest
{
    public static void main(String[] args)
    {
        HashSet objs = new HashSet();
        objs.add(new EuqalsObj());
        objs.add(new EuqalsObj());
        objs.add(new HashCodeObj());
        objs.add(new HashCodeObj());
        objs.add(new HashSetObj());
        objs.add(new HashSetObj());
          
        System.out.println("HashSet Elements:");
        System.out.print("\t" + objs + "\n");
    }
}