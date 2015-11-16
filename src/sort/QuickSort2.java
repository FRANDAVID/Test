package sort;


/**
 * 快速排序实现
 * @author wly
 *
 */
public class QuickSort2{
	
	public void sort(int[] array,int left,int right) {
	
		if(left >= right) {
			return ;
		} else {
			int pivot = partition(array, left,right);
			sort(array,left, pivot-1); //注意-1操作，因为递归求解范围不包括pivot
			sort(array,pivot+1,right); //注意+1操作，因为递归求解范围不包括pivot
		}
	}
	
	/**
	 * 拆分数组成两个部分，并且以pivot为基准，进行划分
	 * @param array
	 */
	private int partition(int[] array,int left,int right) {
		//随机生成分割点
		int pivot = (int) (Math.random() * (right - left)) + left;
		int pValue = array[pivot];
		
		int leftPos = left;
		int rightPos = right;
		while(leftPos != rightPos) {
			while(array[leftPos] < pValue) {
				leftPos ++;
			}
			
			while(array[rightPos] > pValue) {
				rightPos --;
			}
			exchange(array,leftPos,rightPos);
		}
		return leftPos;
	}
	

	/**
	 * 交换数组中指定的两个元素
	 * @param array
	 * @param x1
	 * @param x2
	 */
	public void exchange(int[] array,int x1,int x2) {
		int temp = array[x1];
		array[x1] = array[x2];
		array[x2] = temp;
	}
	
	public static void main(String[]args){
		QuickSort2 qs = new QuickSort2();
		int[]a = {9,1,4,2,10,7,6};
		qs.sort(a, 0, a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
