package sort;


/**
 * 堆排序
 * 简述:
 *      首先使用建立最大堆的算法建立好最大堆，然后将堆顶元素（最大值）与最后一个值交换，同时使得堆的长度减小1 ，调用保持最大堆性质的算法调整，使得堆顶元素成为最大值，此时最后一个元素已被排除在外
 * 时间复杂度:
 *      Θ(nlgn)
 * 空间复杂度:
 *      
 * 优点:
 *      
 * 缺点:
 *      想着就挺麻烦的。。。相比其他排序，相对难理解一点点
 * 可改进:
 *      
 * @author CheN
 *
 */
public class HeapSort {
    private static int heapSize;
     
    //左孩子编号
    private static int getLeftChild(int i){
        return 2 * i;
    }
     
    //右孩子编号
    private static int getRightChild(int i){
        return 2 * i + 1;
    }
     
    /**
     * 保持最大堆的性质（孩子不分左右，均比父节点小）
     * @param array，堆中的数组元素
     * @param i，对以该元素为根元素的堆进行调整，假设前提:左右子树都是最大堆
     * 
     * 由于左右孩子都是最大堆，首先比较根元素与左右孩子，找出最大值，假如不是根元素，则调整两个元素的值；
     * 由于左孩子（右孩子）的值与根元素交换，有可能打破左子树（右子树）的最大堆性质，因此继续调用，直至叶子元素。
     */
    private static void maxHeapify( int[] array , int index ){
        int left = getLeftChild( index );
        int right = getRightChild( index );
        int largest = 0;
        if( left < heapSize && array[ index ] < array[ left ]){
            largest = left;
        }else{
            largest = index;
        }
        if( right < heapSize && array[ right ] > array[ largest ]){
            largest = right;
        }
        if( largest == index ){
            return ;
        } else {
            int temp = array[ index ];
            array[ index ] = array[ largest ];
            array[ largest ] = temp;
            maxHeapify( array, largest );
        }
    }
     
    /**
     * 建立最大堆。在数据中，array.length/2+1一直到最后的元素都是叶子元素，因此从其前一个元素开始，一直到第一个元素，重复调用maxHeapify函数，使其保持最大堆的性质
     * @param array
     */
    private static void buildMaxHeap(int[] array){
        for( int i = array.length / 2 ; i >= 1; i-- ){
            maxHeapify( array , i );
        }
    }
     
    /**
     * 堆排序:
     */
    public static void asc( int[] array ){
        // 找出最小元素,并将其置于array[0]
        int min = array[0];
        for(int i = 1 ; i < array.length ; i++ ){
            if( min > array[i] ){
                min = array[i];
                array[i] = array[0];
                array[0] = min;
            }
        }
        //调用保持最大堆性质的算法调整，似的对应元素成为最大值，此时最后一个元素已被排除在外
        heapSize = array.length;
        buildMaxHeap( array );
        for(int i = array.length - 1 ; i >= 2 ; i--){
            int temp = array[1];
            array[1] = array[i];
            array[i] = temp;
            heapSize--;
            maxHeapify( array , 1 );
        }
    }
}