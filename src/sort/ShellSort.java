package sort;

/**
 * 希尔排序又称“缩小增量排序”，该方法的基本思想是：先将整个待排元素序列分割成若干个子序列
 * （由相隔某 个“增量”的元素组成的）分别进行直接插入排序，然后依次缩减增量再进行排序，
 * 待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插 入排序。
 * 因为直接插入排序在元素基本有序的情况下（接近最好情况），
 * 效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。
 * @author weijin
 *
 */
public class ShellSort {
    public void shellSort(int[] array, int n) {
        int i, j, gap;
        int temp;
        for (gap = n / 2; gap > 0; gap /= 2) {// 计算gap大小
            for (i = gap; i < n; i++) {// 将数据进行分组
                for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {// 对每组数据进行插入排序
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
                // 打印每趟排序结果
                for (int m = 0; m <= array.length - 1; m++) {
                    System.out.print(array[m] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        shellSort.shellSort(array, array.length);// 注意为数组的个数
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}