package Collection;

import java.util.Arrays;

/**
 * Created by Rain on 16/2/13.
 */
public class ArraysTest {
    public static void main(String[] args) {


    int []a = {1,2,3};
    int []b = {1,2,3};
    System.out.println(Arrays.equals(a,b));//如果你想要比较两个数组是否相等，应该调用这个方法而不是数组对象的 equals方法。
                                            // 加入两个数组包含相同数量的元素， 并且对应的元素的equals是true, 这个方法才返回true。 换句话说， 只有相同
    }
}
