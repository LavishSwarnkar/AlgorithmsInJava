package LeetCode.Jan2020;

public class P66_OddEvenLinkedList {

    public static void main(String args[]){

    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        ListNode evenStart = head.next, node = head, tmp;
        while (node.next != null){
            tmp = node.next;
            node.next = node.next.next;
            node = node.next == null ? node : node.next;
            tmp.next = node.next;
        }
        node.next = evenStart;
        return head;
    }

}
