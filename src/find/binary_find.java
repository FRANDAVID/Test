package find;

import java.util.Arrays;

public class binary_find
{
/**
 * 使用二分查找算法在有序数组中查找指定的元素，如果找到则返回对应的数组索引，否则返回-1
 * 
 * @param array 待查找的有序数组(注意，是有序数组!)
 * @param search 需要查找的元素
 * @return
 * 来源网址：http://www.365mini.com/page/binary-search.htm
 */
public static final int binarySearch(int[] array, int search) {
    int start = 0, end = array.length - 1;
    // 判断当前数组为正向排序(从小到大)还是逆向排序(从大到小)
    boolean isPositive = array[end] >= array[start];
    while (start <= end) {
        int mid = (start + end) / 2;
        if (array[mid] < search) {
            if (isPositive) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } else if (array[mid] > search) {
            if (isPositive) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            return mid;
        }
    }
    return -1;
}

// 程序主方法
public static void main(String[] args) {
    int[] array = { 81, 65, 49, 38, 25, 12, 0 };
    System.out.println(binarySearch(array, 65)); // 输出：1
    System.out.println(Arrays.binarySearch(array,65));
}
}


