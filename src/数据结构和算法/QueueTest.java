package 数据结构和算法;

public class QueueTest {
    public static void main(String[] args) {
//        f：始终等于　Q 的首元素在数组中的下标，即指向下次出队元素的位置
//        r：始终等于Q 的末元素的下标加一，即指向下次入队元素的位置
        //
//        查询当前队列的规模
        int size = QueueTest.getSize(5,0,2);
        System.out.println(size);
    }
    /**
     * 队列中的ｇｅｔｓｉｚｅ方法是一宗特殊操作。
     *  capacity =5,f=0 队列中有２个元素，下次入队的元素放到Q[2]
     *               r=2 [3,1,*,*,*]
     * @param capacity
     * @param f
     * @param r
     * @return
     */
    public static int getSize(int capacity, int f, int r) {
        return (capacity - f + r) % capacity;
    }
}
