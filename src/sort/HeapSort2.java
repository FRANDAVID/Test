package sort;

import java.util.Arrays;

// https://github.com/wangkuiwu/datastructs_and_algorithm/blob/master/source/algrightm/sort/heap_sort/java/HeapSort.java
/**
 * 堆排序：Java 来自于最牛逼的博客。
 * 1，将数组构建最大堆。从 index=(length/2-1) 开始调整。分别判断左右两个孩子的大小，进行交换。
 * 如果是数组从0号位置开始，i 节点的 左孩子:2*i+1,右孩子：2*i+2 ，父节点 floor((i-1)/2)
 *
 * @author skywang
 * @date 2014/03/11
 */

public class HeapSort2 {

	/* 
	 * (最大)堆的向下调整算法
	 *
	 * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
	 *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
	 *     
	 *     其实：就是数组下标从0开始，a[0]位置上是有数据的。
	 *
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
	 *     end   -- 截至范围(一般为数组中最后一个元素的索引)
	 */
	public static void maxHeapDown(int[] a, int start, int end) {
		int c = start;			// 当前(current)节点的位置
		int l = 2*c + 1;		// 左(left)孩子的位置
		int tmp = a[c];			// 当前(current)节点的大小

		for (; l <= end; c=l,l=2*l+1) {
			// "l"是左孩子，"l+1"是右孩子
			if ( l < end && a[l] < a[l+1])
				l++;		// 左右两孩子中选择较大者，即m_heap[l+1] 
			                // 其实：这个地方l++的意思就是 在下面else里 如果 temp比a[l]小，因为l已经++了，此时a[l]
			                        //是右边节点，因此当前节点就跟右边节点交换，
			                        // 如果l没有++，那就是当前节点与左节点交换。
			if (tmp >= a[l])
				break;		// 调整结束
			else {			// 交换值
				a[c] = a[l];
				a[l]= tmp;
			}
		}
	}

	/*
	 * 堆排序(从小到大)
	 *
	 * 参数说明：
	 *     a -- 待排序的数组,
	 *     n -- 数组的长度
	 */
	public static void heapSortAsc(int[] a, int n) {
		int i,tmp;

		// 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
		for (i = n / 2 - 1; i >= 0; i--){ // 初始位置的选定 i=length/2-1 然后递减
			maxHeapDown(a, i, n-1);
		}
		printData(a);
		System.out.println("-----第一次调整完最大堆------");

		/**
		 * 经过上面操作已经完成了数组到最大堆的转变，接下来进行黑社会算法。将最大值一一选出来，
		 * 放到数组末尾形成升序数组
		 */
		// 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
		for (i = n - 1; i > 0; i--) {
			// 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
			tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			// 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
			// 即，保证a[i-1]是a[0...i-1]中的最大值。
			maxHeapDown(a, 0, i-1);
		}
	}

	/* 
	 * (最小)堆的向下调整算法
	 *
	 * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
	 *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
	 *     end   -- 截至范围(一般为数组中最后一个元素的索引)
	 */
	public static void minHeapDown(int[] a, int start, int end) {
		int c = start;			// 当前(current)节点的位置
		int l = 2*c + 1;		// 左(left)孩子的位置
		int tmp = a[c];			// 当前(current)节点的大小

		for (; l <= end; c=l,l=2*l+1) {
			// "l"是左孩子，"l+1"是右孩子
			if ( l < end && a[l] > a[l+1])
				l++;		// 左右两孩子中选择较小者
			if (tmp <= a[l])
				break;		// 调整结束
			else {			// 交换值
				a[c] = a[l];
				a[l]= tmp;
			}
		}
	}

	/*
	 * 堆排序(从大到小)
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     n -- 数组的长度
	 */
	public static void heapSortDesc(int[] a, int n) {
		int i,tmp;

		// 从(n/2-1) --> 0逐次遍历每。遍历之后，得到的数组实际上是一个最小堆。
		for (i = n / 2 - 1; i >= 0; i--)
			minHeapDown(a, i, n-1);

		// 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
		for (i = n - 1; i > 0; i--) {
			// 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最小的。
			tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			// 调整a[0...i-1]，使得a[0...i-1]仍然是一个最小堆。
			// 即，保证a[i-1]是a[0...i-1]中的最小值。
			minHeapDown(a, 0, i-1);
		}
	}

	public static void main(String[] args) {
		int i;
		int a[] = {20,30,90,40,70,110,60,10,100,50,80};
//		int a[]= {5,6,8,7,15};

		System.out.printf("before sort:");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");

		heapSortAsc(a, a.length);			// 升序排列
//		heapSortDesc(a, a.length);		// 降序排列

		System.out.printf("after  sort:");
		for (i=0; i<a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.printf("\n");
	}
	
	/**
	 * 打印某一时刻的数组数据状态
	 * @param data
	 */
	public static void printData(int []data){
			System.out.println("当前数组状态："+Arrays.toString(data));
	}
}