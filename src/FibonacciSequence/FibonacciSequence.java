package FibonacciSequence;

/**
 * 解斐波拉契数列问题，使用三种方法：朴素递归解法、自底向上的动态规划思想解法、线性代数矩阵连乘公式解法
 * @author wly
 * @date 2013-11-28 
 *
 */
public class FibonacciSequence {
	
	private static int TESTCASE = 43;
	
	private static int[][] matrixUnit = {{1,1},{1,0}};
	
	public static void main(String[] args) {
		
		System.out.println("测试规模:" + TESTCASE);
		
		//---朴素递归解斐波那契数列问题测试
		long startT = System.currentTimeMillis();
		System.out.println("朴素递归:" + simpleRecurrence(TESTCASE));
		System.out.println("朴素递归用时:" + (System.currentTimeMillis()-startT));
		
		//---自底向上(动态规划)解斐波那契数列问题测试
		startT = System.currentTimeMillis();
		System.out.println("自底向上(动态规划):" + downToTopReslove(TESTCASE));
		System.out.println("自底向上(动态规划)用时:" + (System.currentTimeMillis()-startT));
	
		//---线性代数矩阵解斐波那契数列问题测试
		int[][] mResult = {{1,1},{1,0}};
		startT = System.currentTimeMillis();
		int n = 1;
		while(n<TESTCASE) {
			mResult = matrixMutiple(mResult, matrixUnit);
			n ++;
		}
		System.out.println("线性代数矩阵公式:" + mResult[0][1]);
		System.out.println("线性代数矩阵公式用时:" + (System.currentTimeMillis()-startT));

		//分治法求m的n连乘测试
		System.out.println("分治法求2的23连乘:" + pow(2, 23));
	
		//两矩阵相乘方法测试
		/*
		int[][] matrix1 = {{2,3,4},{1,2,3}};
		int[][] matrix2 = {{2,4},{3,5},{4,6}};
		int[][] result = new int[matrix1.length][matrix2[0].length];
		int[][] resultS = matrixMutiple(matrix1,matrix2,result);
		System.out.println();
		*/
		
	}
	
	
	/**
	 * 朴素递归
	 * @param n 
	 * @return 第n个斐波那契数
	 */
	public static int simpleRecurrence(int n) {
		if(n == 0) {
			return 0;
		} 
		if(n == 1 || n == 2) {
			return 1;
		}
		
		return simpleRecurrence(n-1) + simpleRecurrence(n-2);
	}
	
	/**
	 * 自底向上包含"动态规划"思想的解法
	 * @param n
	 * @return 第n个斐波那契数
	 */
	public static int downToTopReslove(int n) {
		if(n == 0) {
			return 0;
		} else if(n == 1 || n == 2) {
			return 1;
		} else {
			int[] fibonacciArray = new int[n+1]; //fibonacciArray[i]表示第i个斐波那契数
			fibonacciArray[0] = 0;
			fibonacciArray[1] = 1;
			fibonacciArray[2] = 1;
			for(int i=3;i<=n;i++) { //注意由于fibonacciArray[0]表示第0个元素，这里是i<=n，而不是i<n
				fibonacciArray[i] = fibonacciArray[i-1] + fibonacciArray[i-2];
			}
			
			return fibonacciArray[fibonacciArray.length-1];
		}
	}
	
	
	/**
	 * 分治法求解factor的n次方
	 * @param factor 基数
	 * @param n 次方数
	 * @return
	 */
	public static long pow(long factor,int n) {
		if(n == 0) {
			return 1;
		} else if(n == 1){
			return factor;
		} else {
			if(n % 2 == 1) { //乘法数为奇数
				return pow(factor,(n-1)/2) * pow(factor, (n-1)/2) * factor;
			} else { //乘方数为偶数
				return pow(factor, n/2) * pow(factor, n/2);
			}
		}
	}
	
	/**
	 * 两矩阵相乘
	 * @param matrix1
	 * @param matrix2
	 * @return
	 */	
	public static int[][] matrixMutiple(int[][] matrix1,int[][] matrix2) {
		int[][] result = new int[matrix1.length][matrix2[0].length];
		for(int i=0;i<matrix1.length;i++) {
			for(int j=0;j<matrix2[i].length;j++) {
				int temp = 0;
				for(int k=0;k<matrix1[0].length;k++) {
					temp = matrix1[i][k] * matrix2[k][j] + temp;
				}
				result[i][j] = temp;
			}
		}
		return result;
	}
}
