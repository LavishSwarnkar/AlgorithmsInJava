package LeetCode.Jan2020;

public class P40_ReverseLinkedList {

    public static void main(String args[]){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node = reverseList2(node);
        System.out.println(node);
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null){
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

}
