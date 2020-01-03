package LeetCode.Jan2020;

public class P43_LinkedListCycle {

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while (fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        return fast != null;
    }

}
