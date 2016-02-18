package 排序;


import java.util.Date;
import java.util.Random;    
/**
 * http://128kj.iteye.com/blog/1682613
 * 一亿条数据找出前1000 
 * @author weijin
 *
 */
public class Top10000{    
        
    public static void main(String[] args) {    
        find();    
    }    
    public static void find( ) {//    
        int number = 1000000000;// 一亿条数据    
        int maxnum = 1000000000;// 数据最大值    
        int i = 0;    
        int topnum = 10000;// 从大到小取多少条    
         
        Date startTime = new Date();    
            
        Random random = new Random();    
        int[] top = new int[topnum];    
        for (i = 0; i < topnum; i++) {    
            top[i] = Math.abs(random.nextInt(maxnum));//设置为随机数    
        }    
    
        buildHeap(top, 0, top.length);// 构建最小堆， top[0]为最小元素    
        for (i = topnum; i < number; i++) {    
    
            int currentNumber2 = Math.abs(random.nextInt(maxnum));//设置为随机数    
  
            // 大于 top[0]则交换currentNumber2  重构最小堆    
            if (top[0] < currentNumber2) {    
                top[0] = currentNumber2;    
                shift(top, 0, top.length, 0); // 构建最小堆 top[0]为最小元素    
            }    
        }    
//        System.out.println(Arrays.toString(top));    
        sort(top);    
        System.out.println("==============================");  
//        System.out.println(Arrays.toString(top));    
            
        Date endTime = new Date();    
        System.out.println("用了"+(endTime.getTime() - startTime.getTime())+"毫秒");    
     
    }    
        
       
     
    //构建最小堆    
    public static void buildHeap(int[] array, int from, int len) {    
        int pos = (len - 1) / 2;    
        for (int i = pos; i >= 0; i--) {    
            shift(array, from, len, i);    
        }    
    }    
     
    /**  
     * @param array top数组  
     * @param from 开始  
     * @param len 数组长度  
     * @param pos 当前节点index  
     * */    
     //调整堆,使成为最小堆  
    public static void shift(int[] array, int from, int len, int pos) {    
        // 保存该节点的值     
        int tmp = array[from + pos];    
    
        int index = pos * 2 + 1;// 得到当前pos节点的左节点    
        while (index < len)//  存在左节点    
        {    
            if (index + 1 < len    
                    && array[from + index] > array[from + index + 1])// 如果存在右节点    
            {    
                // 如果右边节点比左边节点小，就和右边的比较    
                index += 1;    
            }    
                 
            if (tmp > array[from + index]) {    
                array[from + pos] = array[from + index];    
                pos = index;    
                index = pos * 2 + 1;    
            } else {    
                break;    
            }    
        }    
        // 最终全部置换完毕后 ，把临时变量赋给最后的节点    
        array[from + pos] = tmp;    
    }    
  
    public static void swap(int array[],int i, int j) {    
        int temp = array[i];    
        array[i] = array[j];    
        array[j] = temp;    
    }    
  
        
    public static void sort(int[] array){  
        for (int i = array.length-1; i > 0; i--) {    
            /*把根节点跟最后一个元素交换位置，调整剩下的节点，即可排好序*/    
            swap(array,0, i);    
            shift(array,0, i - 1,0);    
        }    
  
         
    }    
    
}    