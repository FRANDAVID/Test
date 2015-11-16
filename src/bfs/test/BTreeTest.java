package bfs.test;


public class BTreeTest {

	public BTreeTest(int[]arr){
		root = make(arr,1);
	}
	TreeNode root ;
	
	public static TreeNode make(int[]arr,int index){
		if(index<arr.length){
			int value = arr[index];
			if(value!=0){
				TreeNode t=new TreeNode(value);
				t.left=make(arr,index*2);
				t.right=make(arr,index*2+1);
				return t;
			}
		}
		return null;
	}
}
