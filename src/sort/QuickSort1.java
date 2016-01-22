package sort; /**
 * 
 * @author SunnyMoon 
 */  
////////////////////////////////////////////////////////////////////////////////  
/******************************************************************************* 
 * 概念介绍： 
 * ***************************************************************************** 
 *  
 * 简单排序： 
 * 包括冒泡排序，选择排序和插入排序，是一些容易实现的，但速度比较慢的排序算法。 
 *  
 * 高级排序： 
 * 快速排序，希尔排序和快速排序比简单排序快很多。本节主要介绍快速排序。 
 *  
 * 归并排序： 
 * 在递归算法中已经介绍过，它需要的容易是原始空间的两倍，是一个严重的缺点。 
 *  
 * 希尔排序： 
 * 不需要大量的辅助空间，和归并排序一样容易实现。希尔排序是基于插入排序的一种算法， 
 * 在此算法基础之上增加了一个新的特性，提高了效率。 
 *  
 * 快速排序： 
 * 不需要大量辅助空间，并且是通用排序算法中最快的排序算法，是基于划分的思想。 
 * 快速排序算法本质上是通过把一个数组递归的划分为两个子数组。 
 * 递归的基本步骤： 
 * 1. 把数组划分成以一个元素为枢纽的左右两个子数组。 
 * 2. 调用自身的左边和右边以步骤1递归。 
 * 快速排序法的核心就是递归调用划分算法，直到基值的情况，这时数组就为有序的。 
 * 快速排序的复杂度为： 
 * O(N*logN) 
 *  
 * 影响效率的最大障碍： 
 * 对枢纽数据的选择是影响排序的效率。例如本例子选择枢纽数据为数组的最后一个元素， 
 * 这么选择只是为方便，然而却造成了特殊情况时效率极度下降,降到O(n2)。这种特情况就是当数据为逆序的时候。 
 * 如果改变特殊情况给快速排序带来的致命影响呢，这将在下一专题中详细介绍。 
 */  
////////////////////////////////////////////////////////////////////////////////  
/** 
 * 定义一个数组类，封装了对自身数据的排序。 
 */  
class ArrayIns {  
  
    private long[] theArray;//定义数组  
    private int nElems;//数组中的元素个数  
  
    /** 
     * 初始化 
     * @param max 
     */  
    public ArrayIns(int max) {  
        theArray = new long[max];  
        nElems = 0;  
    }  
  
    /** 
     * 为数组赋值 
     * @param value 
     */  
    public void insert(long value) {  
        theArray[nElems] = value;  
        nElems++;  
    }  
  
    /** 
     * 显示数组元素 
     */  
    public void display() {  
        System.out.print("A=");  
        for (int j = 0; j < nElems; j++) {  
            System.out.print(theArray[j] + " ");  
        }  
        System.out.println("");  
    }  
  
    /** 
     * 快速排序主方法 
     */  
    public void quickSort(){  
        recQuickSort(0, nElems-1);  
    }  
    /** 
     * 快速排序需递归调用的方法 
     * @param left 
     * @param right 
     */  
    public void recQuickSort(int left, int right) {  
        if (right - left <= 0) {  
            return;  
        } else {  
            long pivot = theArray[right];  
              
            int partition = partitionIt(left, right, pivot);  
            recQuickSort(left, partition - 1);  
            recQuickSort(partition + 1, right);  
        }  
    }  
  
    /** 
     * 快速排序划分的核心方法 
     * @param left 
     * @param right 
     * @param pivot 
     * @return 
     */  
    public int partitionIt(int left, int right, long pivot) {  
        int leftPtr = left-1;  
        int rightPtr = right;  
        while (true) {  
            while (theArray[++leftPtr] < pivot)  
                ;  
            while (rightPtr > 0 && theArray[--rightPtr] > pivot)  
                ;  
            if (leftPtr >= rightPtr) {  
                break;  
            } else {  
                swap(leftPtr, rightPtr);  
            }  
        }  
        swap(leftPtr,right);  
        return leftPtr;  
    }  
  
    /** 
     * 交换数据中两个位置的数据 
     * @param dex1 
     * @param dex2 
     */  
    public void swap(int dex1, int dex2) {  
        long temp = theArray[dex1];  
        theArray[dex1] = theArray[dex2];  
        theArray[dex2] = temp;  
    }  
}  
/** 
 * 执行算法的主类 
 */  
public class QuickSort1 {  
  
    public static void main(String[] args) {  
        int maxSize = 16;  
        ArrayIns arr = new ArrayIns(maxSize);  
  
        for (int j = 0; j < maxSize; j++) {  
            long n = (int) (java.lang.Math.random()*99);  
            arr.insert(n);  
        }  
        System.out.println("显示排序前数据");  
        arr.display();  
        arr.quickSort();  
        System.out.println("显示排序后数据");  
        arr.display();  
    }  
}  
/** 
 *  
 * 显示排序前数据： 
 * A=9 14 33 27 66 89 53 32 72 14 46 33 13 79 28 26   
 * 显示排序后数据：  
 * A=9 13 14 14 26 27 28 32 33 33 46 53 66 72 79 89  
 */  
  
/** 
 * 总结： 
 * 快速排序是常用排序中效率最高的一种排序方式。 
 * 但在应用中的一此特殊情况影响他的效率，这不是算法本身的问题，而是如果实现的问题。 
 * 已经有很好的实现方式改变一些特殊情况性能下降的问题。 
 */  