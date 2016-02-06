package bfs;


import java.util.ArrayDeque;

/**
 * 使用递归，来实现二叉树。在数的构造方法时，
 * 分别调用构建左树和右树的方法。
 * t.left= make(arr,index*2), 13，25，16 如果arr[1]=13,arr[2]=25,arr[3]=16
 * 所有 index=1 是根，index=2，是左树，index=3 是右树
 * t.right= make(arr,index*2+1) arr[3]=16 是构造左树。
 * 
 * 所以，在构造树的时候 数组中为0 代表左或右，不存在，构造方法时，是递归调用
 * public make(arr,index){
	 * t.left=make(arr,index*2)
	 * t.right=make(arr,index*2+1)
 * }
 * @author weijin
 *
 */
public class BinaryTree {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value=value;
        }
    }

    TreeNode root;

    public BinaryTree(int[] array){
        root=makeBinaryTreeByArray(array,1);
    }
    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     * {0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
     * /** 
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int value=array[index];
//        	System.out.println("index->"+index+" value->"+value);
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }       
        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        stack.push(root);

        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();
            System.out.print(node.value+"    ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }           
        }
        System.out.print("\n");
    }

    /**
     * 广度优先遍历  其实就是一层易程遍历二叉树
     * 采用非递归实现
     * 需要辅助数据结构：队列
     * 
     */
    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            TreeNode node=queue.remove();
            System.out.print(node.value+"    ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }

    /** https://github.com/gdweijin/Test.git
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr={7,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        int[] arr1={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTree tree=new BinaryTree(arr);
        tree.depthOrderTraversal();
        tree.levelOrderTraversal();
        BinaryTree tree2=new BinaryTree(arr1);
        tree2.depthOrderTraversal();
        tree2.levelOrderTraversal();
    }
}