
//二叉树和链表一样，首先都应该想到递归。所以本文中尽量都用递归和非递归完成每一题
//
//
//1.二叉树的遍历，前序中序后序，递归和非递归
//
//2.二叉树的层序遍历
//
//3.二叉树的高度
//
//4.二叉树的节点个数
//
//5.求二叉树的镜像
//
//6.判断两颗二叉树是否互为镜像
//
//7.判断一棵树是否本身就是镜像树
//
//8.判断两颗二叉树是不是相同的树
//
//9.判断树1是不是树2的子结构
//
//10.判断二叉树是否是平衡二叉树
//
//11.二叉树第k层的节点个数
//
//12.二叉树叶子节点的个数
//
//13.由前序遍历和中序遍历重构二叉树
//
//14.由中序遍历和后序遍历重构二叉树
//
//15.二叉树中两节点的最大距离
//
//16.二叉树中和为某一值的路径
//
//17.求二叉树中两个节点的最低公共祖先节点

package dataStructAndAlgorithm;

import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
	String value;
	TreeNode left;
	TreeNode right;

	public TreeNode(String value) {
		this.value = value;
	}

}

public class BinaryTree {
	// 2.二叉树的层序遍历
	// 思路：利用队列实现二叉树的层序遍历。
	public void cx(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			System.out.print(cur.value + " ");
			if (cur.left != null)
				queue.addLast(cur.left);
			if (cur.right != null)
				queue.addLast(cur.right);

		}
	}

	// 3.二叉树的高度 --递归--
	public int getHighRec(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(getHighRec(root.left), getHighRec(root.right)) + 1;
	}

	// 4二叉树的高度 --非 递归--
	// 思路：层序遍历，对当前层和下一层的节点数计数。
	public int getHigh(TreeNode root) {
		if (root == null)
			return 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);
		int high = 0;
		int curLevelNodes = 1, nextLevelNodes = 0;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			curLevelNodes--;
			if (cur.left != null) {
				queue.addLast(cur.left);
				nextLevelNodes++;
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
				nextLevelNodes++;
			}
			if (curLevelNodes == 0) {
				high++;
				curLevelNodes = nextLevelNodes;
				nextLevelNodes = 0;
			}
		}
		return high;
	}

	// 4.二叉树的节点个数 --递归--
	public int getNodesNumRec(TreeNode root) {
		if (root == null)
			return 0;
		return getNodesNumRec(root.left) + getNodesNumRec(root.right) + 1;
	}

	// 5二叉树的节点个数 --递归--
	// 思路:层序遍历记录个数
	public int getNodesNum(TreeNode root) {
		if (root == null)
			return 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);
		int num = 1;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			if (cur.left != null) {
				queue.addLast(cur.left);
				num++;
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
				num++;
			}
		}
		return num;
	}

	// 6.求二叉树的镜像(直接把原树变为其镜像树，即破坏原树) --递归--
	// 思路:把原树的左子树置为其右子树的镜像；把原树的右子树置为其左子树的镜像
	public TreeNode getJXRec(TreeNode root) {
		if (root == null)
			return null;
		TreeNode tleft = getJXRec(root.right);
		TreeNode tright = getJXRec(root.left);
		root.left = tleft;
		root.right = tright;
		return root;
	}

	// 7.求二叉树的镜像(直接把原树变为其镜像树，即破坏原树) --非递归--
	// 思路: 利用Stsck,让节点的子节点互相交换
	public TreeNode getJX(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			TreeNode temp = cur.right;
			cur.right = cur.left;
			cur.left = temp;
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
		return root;
	}

	// 8.求二叉树的镜像（生成一颗新树，即不改变原树结构） --递归--
	public TreeNode newJXRec(TreeNode root) {
		if (root == null)
			return null;
		TreeNode newTree = new TreeNode(root.value);
		newTree.left = newJXRec(root.right);
		newTree.right = newJXRec(root.left);
		return newTree;
	}

	// 8.求二叉树的镜像（生成一颗新树，即不改变原树结构） --非 递归--

	/*
	 * A / \ B C / \ \ D E F
	 */
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode("A");
		TreeNode n2 = new TreeNode("B");
		TreeNode n3 = new TreeNode("C");
		TreeNode n4 = new TreeNode("D");
		TreeNode n5 = new TreeNode("E");
		TreeNode n6 = new TreeNode("F");
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		TreeNode root = n1;
		BinaryTree bt = new BinaryTree();
		System.out.print("层序遍历---->");
		bt.cx(root);
		System.out.print("\n");
		System.out.println("递归高度---->" + bt.getHighRec(root));
		System.out.println("非递归高度---->" + bt.getHighRec(root));
		System.out.println("递归节点个数---->" + bt.getNodesNumRec(root));
		System.out.println("非递归节点个数---->" + bt.getNodesNum(root));

		// bt.getJXRec(root);
		// bt.cx(root);
		// System.out.print("\n");
		System.out.print("把树变为本身的镜像树后层序遍历---->");
		bt.getJX(root);
		bt.cx(root);

	}
}