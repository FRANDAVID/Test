package tree;

import java.util.Stack;


class TreeNode {
    public TreeNode left;

    public TreeNode right;

    public int value;

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}

//二叉树及其操作:

public class BinaryTree {

    public static int getTreeHeight(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return 1 + Math
                .max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

    public static void recursePreOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.value);
        if (root.left != null)
            recursePreOrder(root.left);
        if (root.right != null)
            recursePreOrder(root.right);
    }

    public static void stackPreOrder(TreeNode root) {
        Stack stack = new Stack();
        if (root == null)
            return;
        stack.push(root);
        System.out.println(root.value);
        TreeNode temp = root.left;
        while (temp != null) {
            stack.push(temp);
            System.out.println(temp.value);
            temp = temp.left;
        }
        temp = (TreeNode) stack.pop();
        while (temp != null) {
            temp = temp.right;
            while (temp != null) {
                stack.push(temp);
                System.out.println(temp.value);
                temp = temp.left;
            }
            if (stack.empty())
                break;
            temp = (TreeNode) stack.pop();
        }
    }

    public static void recurseInOrder(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            recurseInOrder(root.left);
        System.out.println(root.value);
        if (root.right != null)
            recurseInOrder(root.right);
    }

    public static void stackInOrder(TreeNode root) {
        Stack stack = new Stack();
        if (root == null)
            return;
        else
            stack.push(root);
        TreeNode temp = root.left;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        temp = (TreeNode) stack.pop();
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.right;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (stack.empty())
                break;
            temp = (TreeNode) stack.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(null, null, 1);
        TreeNode node2 = new TreeNode(null, node1, 2);
        TreeNode node3 = new TreeNode(null, null, 3);
        TreeNode node4 = new TreeNode(node2, node3, 4);
        TreeNode node5 = new TreeNode(null, null, 5);
        TreeNode root = new TreeNode(node4, node5, 0);
        System.out.println("Tree Height is " + getTreeHeight(root));
        System.out.println("Recurse In Order Traverse");
        recurseInOrder(root);
        System.out.println("Stack In Order Traverse");
        stackInOrder(root);
        System.out.println("Recurse Pre Order Traverse");
        recursePreOrder(root);
        System.out.println("Stack Pre Order Traverse");
        stackPreOrder(root);
    }
}