package sort;

/**
 * 快速排序（Quicksort）是对冒泡排序的一种改进。由C. A. R. Hoare在1962年提出。
 * 它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然 后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * @author weijin
 *
 */
public class QuickSort {
    public int partition(int[] sortArray, int low, int height) {
        int key = sortArray[low];// 刚开始以第一个数为标志数据
        while (low < height) {
            while (low < height && sortArray[height] >= key)
                height--;// 从后面开始找，找到比key值小的数为止
            sortArray[low] = sortArray[height];// 将该数放到key值的左边
            while (low < height && sortArray[low] <= key)
                low++;// 从前面开始找，找到比key值大的数为止
            sortArray[height] = sortArray[low];// 将该数放到key值的右边
        }
        sortArray[low] = key;// 把key值填充到low位置，下次重新找key值
        // 打印每次排序结果
        for (int i = 0; i <= sortArray.length - 1; i++) {
            System.out.print(sortArray[i] + "\t");
        }
        System.out.println();
        return low;
    }

    public void sort(int[] sortArray, int low, int height) {
        if (low < height) {
            int result = partition(sortArray, low, height);
            sort(sortArray, low, result - 1);
            sort(sortArray, result + 1, height);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
        quickSort.sort(array, 0, 8);
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}