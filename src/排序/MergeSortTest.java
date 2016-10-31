package 排序;

/**
 * 算法描述：

把序列分成元素尽可能相等的两半。

把两半元素分别进行排序。

把两个有序表合并成一个。


 * @author weijin
 *
 */
public class MergeSortTest {
    public void sort(int[] array, int left, int right) {
        if (left >= right)
            return;
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        sort(array, left, center);
        // 对右边数组进行递归
        sort(array, center + 1, right);
        // 合并
        merge(array, left, center, right);
        // 打印每次排序结果
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();

    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     * 
     * @param array
     *            数组对象
     * @param left
     *            左数组的第一个元素的索引
     * @param center
     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right
     *            右数组最后一个元素的索引
     */
    public void merge(int[] array, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[array.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if (array[left] <= array[mid]) {
                tmpArr[third++] = array[left++];
            } else {
                tmpArr[third++] = array[mid++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = array[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = array[left++];
        }
        // 将临时数组中的内容拷贝回原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            array[tmp] = tmpArr[tmp++];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        MergeSortTest mergeSortTest = new MergeSortTest();
        mergeSortTest.sort(array, 0, array.length - 1);
        System.out.println("排序后的数组：");
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}