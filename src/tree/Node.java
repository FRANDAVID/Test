package tree;
/**
 * 概念介绍： 
 * 
 * 树：树由边连接的节点构成。 
 * 多路树：节点可以多于两个。 
 * 路径：顺着连接点的边从一个节点到另一个节点，所以过的节点顺序排列就称做路径。 
 * 根：树的顶端节点称为根。 
 * 父节点：每个节点都有一条边向上连接到另一个节点，这个节点就称为父节点。 
 * 子节点：每个节点都可能有一条或多条边向下连接其它节点，下面这些节点就称为子节点。 
 * 叶节点：没有子节点的节点为叶子节点或叶节点。 
 * 子树：每个节点都可以作为子树的根，它和它所有的子节点都包含在子树中。 
 * 访问：当程序控制流程到达某个节点时，就称为“访问”这个节点。 
 * 遍历：遍历树意味着要遵循某种特定的顺序访问树中所有的节点。 
 * 层：一个节点的层数是指从根开始到这个节点有多少“代”。一般根为第0层。 
 * 关键字：对象中通常会有一个数据域被指定为关键字，通常使用这个关键字进行查询等操作。 
 * 二叉树：如果树中每个节点最多只能有两个子节点，这样的特殊的树就是二叉树。 
 * 二叉搜索树：二叉树的一个节点的左子节点的关键字值小于这个节点，右子节点的关键字值大 
 *            于或等于这个父节点。 
 * 平衡树与非平衡树：左子节点与左子节点对称的树为平衡树，否则就是非平衡树。 
 * 完全二叉树：二叉树的最后一层都是叶子结点，其它各层都有左右子树，也叫满二叉树。 
 * 
 * 为什么用二叉树：1.二叉树结合了另外两种数据结构的优点：一种是有序数组，另一种是链表。 
 *                在树中查找数据的速度和在有序数组中查找的速度一样快，同时插入的速度 
 *                和删除的速度和链表的速度一样。 
 *                2.在有序数组中插入数据项太慢：用二分查找法可以在有序数据中快速的查找 
 *                特定的值，查找所需时间复杂度为O(logN)。然而插入和删除是非常低效的。 
 *                3.在链表中查找太慢：链表的插入和删除操作都很快，时间复杂度是O(1)。 
 *                然而查找数据项是非常低效的。 
 * 二叉树的效率：时间复杂度为O(logN)。树对所有的数据存储操作都很高效。 
 * 
 * 程序介绍：对树的一些常用操作进行了封装，包括查询，插入，删除，遍历二叉树（中序，后序，前序） 
 *          以及以树的方式显示二对树的各个结点。 
 * 
 */  
/** 
 * 
 * @author SunnyMoon 
 */  
  
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
  
/** 
 * 定义树的结点类 
 */  
class Node {  
  
    public int iData;//关键字  
    public double dData;//数据项  
    public Node leftChild;//左子树  
    public Node rightChild;//右子树  
  
    public void displayNode() {//输出结点内容  
        System.out.print("【");  
        System.out.print("关键字: "+iData);  
        System.out.print(",");  
        System.out.print("值："+dData);  
        System.out.print("】");  
    }  
}  
  
/** 
 * 定义二叉树类 
 */  
class Tree {  
  
    private Node root;  
  
    public Tree() {  
        root = null;  
    }  
  
    /** 
     * 查找 
     * @param key 
     * @return 
     */  
    public Node find(int key) {  
        Node current = root;  
        while (current.iData != key) {  
            if (key < current.iData) {  
                current = current.leftChild;  
            } else {  
                current = current.rightChild;  
            }  
            if (current == null) {  
                return null;  
            }  
        }  
        return current;  
    }  
/** 
 * 插入 
 * @param id 
 * @param dd 
 */  
    public void insert(int id, double dd) {  
        Node newNode = new Node();  
        newNode.iData = id;  
        newNode.dData = dd;  
        if (root == null) {  
            root = newNode;  
        } else {  
            Node current = root;  
            Node parent;  
            while (true) {  
                parent = current;  
                if (id < current.iData) {  
                    current = current.leftChild;  
                    if (current == null) {  
                        parent.leftChild = newNode;  
                        return;  
                    }  
                } else {  
                    current = current.rightChild;  
                    if (current == null) {  
                        parent.rightChild = newNode;  
                        return;  
                    }  
                }  
            }  
        }  
    }  
  
    /** 
     * 删除 
     * @param key 
     * @return 
     */  
    public boolean delete(int key) {  
        Node current = root;  
        Node parent = root;  
        boolean isLeftChild = true;  
  
        while (current.iData != key) {  
            parent = current;  
            if (key < current.iData) {  
                isLeftChild = true;  
                current = current.leftChild;  
            } else {  
                isLeftChild = false;  
                current = current.rightChild;  
            }  
            if (current == null) {  
                return false;  
            }  
        }  
        if (current.leftChild == null && current.rightChild == null) {  
            if (current == root) {  
                root = null;  
            } else if (isLeftChild) {  
                parent.leftChild = null;  
            } else {  
                parent.rightChild = null;  
            }  
        } else if (current.rightChild == null) {  
            if (current == root) {  
                root = current.leftChild;  
  
            } else if (isLeftChild) {  
                parent.leftChild = current.leftChild;  
            } else {  
                parent.rightChild = current.leftChild;  
            }  
        } else if (current.leftChild == null) {  
            if (current == root) {  
                root = current.rightChild;  
            } else if (isLeftChild) {  
                parent.leftChild = current.rightChild;  
            } else {  
                parent.rightChild = current.rightChild;  
            }  
        } else {  
            Node successor = getSuccessor(current);  
            if (current == root) {  
                root = successor;  
            } else if (isLeftChild) {  
                parent.leftChild = successor;  
            } else {  
                parent.rightChild = successor;  
            }  
            successor.leftChild = current.leftChild;  
        }  
        return true;  
    }  
/** 
 * 遍历二叉树 
 * @param traverseType 
 */  
    public void traverse(int traverseType) {  
        switch (traverseType) {  
            case 1:  
                System.out.print("\n" + "前序遍历（Preorder traversal）: ");  
                preOrder(root);  
                break;  
            case 2:  
                System.out.print("\n" + "中序遍历（Inorder traversal）: ");  
                inOrder(root);  
                break;  
            case 3:  
                System.out.print("\n" + "后序遍历（Postorder traversal）: ");  
                postOrder(root);  
                break;  
        }  
        System.out.println();  
    }  
/** 
 * 定义定位到后序结点方法 
 * @param delNode 
 * @return 
 */  
    private Node getSuccessor(Node delNode) {  
        Node successorParent = delNode;  
        Node successor = delNode;  
        Node current = delNode.rightChild;  
        while (current != null) {  
            successorParent = successor;  
            successor = current;  
            current = current.leftChild;  
        }  
        if (successor != delNode.rightChild) {  
            successorParent.leftChild = successor.rightChild;  
            successor.rightChild = delNode.rightChild;  
        }  
        return successor;  
    }  
/** 
 * 前序遍历 
 * @param localRoot 
 */  
    private void preOrder(Node localRoot) {  
        if (localRoot != null) {  
            System.out.print(localRoot.iData + " ");  
            preOrder(localRoot.leftChild);  
            preOrder(localRoot.rightChild);  
        }  
    }  
/** 
 * 中序遍历 
 * @param localRoot 
 */  
    private void inOrder(Node localRoot) {  
        if (localRoot != null) {  
            inOrder(localRoot.leftChild);  
            System.out.print(localRoot.iData + " ");  
            inOrder(localRoot.rightChild);  
        }  
    }  
/** 
 * 后序遍历 
 * @param localRoot 
 */  
    private void postOrder(Node localRoot) {  
        if (localRoot != null) {  
            postOrder(localRoot.leftChild);  
            postOrder(localRoot.rightChild);  
            System.out.print(localRoot.iData + " ");  
        }  
    }  
/** 
 * 把关键字按树型输出 
 * ‘--’表示树中这个位置的结点不存在。 
 */  
    public void displayTree() {  
        Stack globalStack = new Stack(1000);  
        globalStack.push(root);  
        int nBlanks = 32;  
        boolean isRowEmpty = false;  
        System.out.println(  
                "-----------------------------------------------------------------------");  
        while (isRowEmpty == false) {  
            Stack localStack = new Stack(1000);  
            isRowEmpty = true;  
  
            for (int j = 0; j < nBlanks; j++) {  
                System.out.print(" ");  
            }  
            while (globalStack.isEmpty() == false) {  
                Node temp = (Node) globalStack.pop();  
                if (temp != null) {  
                    System.out.print(temp.iData);  
                    localStack.push(temp.leftChild);  
                    localStack.push(temp.rightChild);  
  
                    if (temp.leftChild != null || temp.rightChild != null) {  
                        isRowEmpty = false;  
                    }  
                } else {  
                    System.out.print("..");  
                    localStack.push(null);  
                    localStack.push(null);  
                }  
                for (int j = 0; j < nBlanks * 2 - 2; j++) {  
                    System.out.print(" ");  
                }  
            }  
            System.out.println();  
            nBlanks /= 2;  
            while (localStack.isEmpty() == false) {  
                globalStack.push(localStack.pop());  
            }  
        }  
        System.out.println(  
                "-----------------------------------------------------------------------");  
    }  
}  
  
/** 
 * 使用的栈 
 * @author Administrator 
 */  
class Stack {  
  
    private int maxSize;  
    private Object[] stackArray;  
    private int top;  
  
    public Stack(int s) {  
        maxSize = s;  
        stackArray = new Object[maxSize];  
        top = -1;  
    }  
  
    public void push(Object p) {  
        stackArray[++top] = p;  
    }  
  
    public Object pop() {  
        return stackArray[top--];  
    }  
  
    public Object peek() {  
        return stackArray[top];  
    }  
  
    boolean isEmpty() {  
        if (top == -1) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
}  
/** 
 * 主方法 
 * @author Administrator 
 */  
class TreeAaa {

    public static void main(String[] args) throws IOException {
        int value;
        Tree theTree = new Tree();
        theTree.insert(12, 1.5);
        theTree.insert(15, 2.4);
        theTree.insert(22, 5.6);
        theTree.insert(33, 7.1);
        theTree.insert(55, 3.3);
        theTree.insert(26, 8.7);
        theTree.insert(17, 2.3);
        theTree.insert(8, 6.9);
        theTree.insert(6, 8.4);
        theTree.insert(14, 7.0);
        theTree.insert(23, 1.8);
        theTree.insert(38, 2.9);

        while (true) {
            System.out.print("输入想执行的操作的英文首字母：");
            System.out.print("插入（Insert）, 查找（Find）, 删除（Delete）, 遍历（Traverse）: ");
            int choice = getChar();
            switch (choice) {
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("输入想要插入的值: ");
                    value = getInt();
                    theTree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.print(("输入想要查找的关键字: "));
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("成功查找: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else {
                        System.out.print("不存在所查询关键字");
                    }
                    System.out.print("输入的关键字：" + value + "\n");
                    break;
                case 'd':
                    System.out.print("输入想要删除的关键字: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if (didDelete) {
                        System.out.print("删除的值：" + value + "\n");
                    } else {
                        System.out.print("不能执行删除操作");
                    }
                    System.out.println(value);
                    //System.out.print(value + "\n");  
                    break;
                case 't':
                    System.out.print("输入遍历类型 1, 2 或 3:");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.println("非法输入");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
  /** 
    * 运行结果： 
    * 输入想执行的操作的英文首字母：插入（Insert）, 查找（Find）, 删除（Delete）, 遍历（Traverse）: s 
    *----------------------------------------------------------------------- 
    *                                12 
    *                8                              15 
    *        6              ..              14              22 
    *    ..      ..      ..      ..      ..      ..      17      33 
    *  ..  ..  ..  ..  ..  ..  ..  ..  ..  ..  ..  ..  ..  ..  26  55 
    * ........................................................23..38.. 
    *----------------------------------------------------------------------- 
    *输入想执行的操作的英文首字母：插入（Insert）, 查找（Find）, 删除（Delete）, 遍历（Traverse）: i 
    *输入想要插入的值: 3 
    *输入想执行的操作的英文首字母：插入（Insert）, 查找（Find）, 删除（Delete）, 遍历（Traverse）: f 
    *输入想要查找的关键字: 14 
    *成功查找: {14,7.0} 
    *输入的关键字：14 
    *输入想执行的操作的英文首字母：插入（Insert）, 查找（Find）, 删除（Delete）, 遍历（Traverse）: 
    */  
 /** 
  * 总结： 
  * 树结合了数组和链表的优点，是一种非常高效的数据结构。 
  */  