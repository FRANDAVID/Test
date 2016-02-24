package tree;

public class BinaryTree {

	// 节点的定义
	private static class TreeNode {
		Object element;
		TreeNode left;
		TreeNode right;

		public TreeNode(Object o) {
			element = o;
		}
	}

	private TreeNode root;
	private int size = 0;

	public BinaryTree() {

	}

	public BinaryTree(Object[] objects) {
		for (int i = 0; i < objects.length; i++) {
			insert(objects[i]);
		}
	}

	public boolean insert(Object o) {
		if (root == null) {
			root = new TreeNode(o);
		} else {
			TreeNode parent = null;
			TreeNode current = root;
			while (current != null) {
				if (((Comparable) o).compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (((Comparable) o).compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else {
					return false;
				}
			}
			if (((Comparable) o).compareTo(parent.element) < 0) {
				parent.left = new TreeNode(o);
			} else {
				parent.right = new TreeNode(o);
			}
		}
		size++;
		return true;
	}

	//中序遍历
	public void inorder(){
		inorder(root);
	}
	public void inorder(TreeNode root){
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.element + " ");
		inorder(root.right);
	}
	
	//后序遍历
	public void postorder(){
		postorder(root);
	}
	
	public void postorder(TreeNode root){
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.element +" ");
	}
	
	//前序遍历
	public void preorder(){
		preorder(root);
	}
	
	public void preorder(TreeNode root){
		if (root == null) {
			return;
		}
		System.out.println(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public int getSize(){
		return size;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert("a");
		tree.insert("b");
		tree.insert("c");
		tree.insert("d");
		tree.insert("e");
		tree.insert("f");
		tree.insert("g");
		System.out.println("Inorder (sorted): ");
		tree.inorder();
		System.out.println("postorder: ");
		tree.postorder();
		System.out.println("preorder: ");
		tree.preorder();
		System.out.println("the number of nodes is " + tree.getSize());
	}
}
