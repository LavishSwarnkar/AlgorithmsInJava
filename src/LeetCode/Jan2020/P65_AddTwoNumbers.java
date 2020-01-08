package LeetCode.Jan2020;

public class P65_AddTwoNumbers {

    public static void main(String args[]){

    }

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode sumList = null, node3 = null;

        int carry = 0;
        while (node1 != null || node2 != null){
            int sum = (node1 == null ? 0 : node1.val)
                    + (node2 == null ? 0 : node2.val)
                    + carry;
            carry = sum/10;

            if(node3 == null)
                node3 = sumList = new ListNode(sum%10);
            else
                node3 = node3.next = new ListNode(sum%10);

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }

        if(carry > 0)
            node3.next = new ListNode(carry);

        return sumList;
    }

}
