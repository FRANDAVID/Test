package workQueue;


public class Task implements Runnable {
	
	private static final int Matrix_size = 100;
	
	static int[][] matrix_A= null;
	static int[][] matrix_B= null;
	
	static {
		
		matrix_A = fillupMatrix();
		matrix_B = fillupMatrix();
	}

	public void run() {
		
		int[][] matrix_R = new int[Matrix_size][Matrix_size];
		
		for(int i=0; i<Matrix_size; i++)
		{
			for(int j=0; j<Matrix_size; j++)
			{
				for(int k=0; k<Matrix_size; k++)
				{
					matrix_R[i][j] = matrix_A[i][k] * matrix_B[k][j];
				}
			}
		}
	}

	private static int[][] fillupMatrix() {
		int index = 0;
		int[][] matrix = new int[Matrix_size][Matrix_size];
		
		for(int i=0;i<Matrix_size;i++) {
			for(int j=0;j<Matrix_size;j++) {
				matrix[i][j] = index++;
			}
		}
		return matrix;
	}
	
		
}