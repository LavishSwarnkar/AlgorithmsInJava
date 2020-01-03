package LeetCode.Jan2020;

public class P41_Merge2SortedLists {

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);

        ListNode l3 = mergeTwoLists(l1, l2);
        System.out.println(l3);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, node = null, newNode = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            }

            if (head == null) {
                head = node = newNode;
            } else {
                node.next = newNode;
                node = newNode;
            }
        }

        while (l1 != null){
            newNode = new ListNode(l1.val);
            if(node == null) {
                head = node = newNode;
            } else {
                node.next = newNode;
                node = newNode;
            }
            l1 = l1.next;
        }

        while (l2 != null){
            newNode = new ListNode(l2.val);
            if(node == null) {
                head = node = newNode;
            } else {
                node.next = newNode;
                node = newNode;
            }
            l2 = l2.next;
        }
        return head;
    }

}
