package linkedList.linkedlistInterview;

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
    public  ListNode  pre;
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
            pre = head;
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
