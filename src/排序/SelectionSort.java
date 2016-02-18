package 排序;

/**
 * 选择排序的第一趟处理是从数据序列所有n个数据中选择一个最小的数据作为有序序列中的第1个元素并将它定位在第一号存储位置，
 * 第二趟处理从数据序列的n-1个数据中选择一个第二小的元素作为有序序列中的第2个元素并将它定位在第二号存储位置，
 * 依此类推，当第n-1趟处理从数据序列的剩下的2个元素中选择一个较小的元素作为有序序列中的最后第2个元素
 * 并将它定位在倒数第二号存储位置，
 * 至此，整个的排序处理过程就已完成。
 * @author weijin
 *
 */
public class SelectionSort {
    public void selectionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {// 第i个和第j个比较j可以取到最后一位，所以要用j<=array.length-1
                if (array[i] > array[j]) {// 注意和冒泡排序的区别，这里是i和j比较。
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            // 打印每趟排序结果
            for (int m = 0; m <= array.length - 1; m++) {
                System.out.print(array[m] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        selectionSort.selectionSort(array);
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}