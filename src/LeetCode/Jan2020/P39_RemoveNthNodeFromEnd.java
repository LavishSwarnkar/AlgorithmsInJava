package LeetCode.Jan2020;

public class P39_RemoveNthNodeFromEnd {

    public static void main(String args[]){

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy, nthNode = dummy;
        for(int i=0 ; i<n ; i++)
            nthNode = nthNode.next;
        while(nthNode.next != null){
            node = node.next;
            nthNode = nthNode.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }

}
