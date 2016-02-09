package 数据结构与算法学习笔记;

/**
 * Created by Rain on 16/2/8.
 */
 class ListNode {
    public  int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        next=null;
    }
}

public class LinkedList{

    public ListNode head;
    public ListNode pre;
    public LinkedList(ListNode head){
        this.head = head;
        this.pre = head;
    }

    public void insertNode(ListNode node){
        pre.next = node;
        pre = node;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode reverseByLoop(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre= null;
        ListNode nextNode = null;
        while(head!=null){
            nextNode = head.next;
            head.next = pre;
            pre = head; //此处的多余变量,是因为函数需要返回一个头结点引用,此节点不能为空,因此需要保证pre变量不能为null),
                        //其实是为了让head去探路,确保pre变量返回时不是空.持续的移动head指针.有可能移动到null所以不能
                        //贸然返回head变量.
            head  = nextNode;
        }
        return pre;
    }
    public static void main(String[]args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        LinkedList ll = new LinkedList(n1);
        ll.insertNode(n1);
        ll.insertNode(n2);
        ll.insertNode(n3);
        System.out.println(ll);
        ll.reverseByLoop(n1);
        System.out.println(ll);

    }
}
