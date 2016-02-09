package 数据结构与算法学习笔记.链表;

/**
 * Created by Rain on 16/2/9.
 */
class DListNode {
    int val;
    DListNode prev, next;

    DListNode(int val) {
        this.val = val;
        this.prev = this.next = null;
    }
}

/**
 * 双向链表反转
 */
public class DoubleLinkedList {

    public DListNode reverse(DListNode head) {
        DListNode curr = null;
        while (head != null) {
            curr = head;
            head = curr.next;
            curr.next = curr.prev;
            curr.prev = head;
        }
        return curr;
    }
}
