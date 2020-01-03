package LeetCode.Jan2020;

import java.util.Stack;

public class P42_PalindromeLinkedList {

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fastRunner = head, slowRunner = head;
        Stack<Integer> vals = new Stack<>();
        while (fastRunner != null && fastRunner.next != null){
            vals.push(slowRunner.val);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        if(fastRunner != null)
            slowRunner = slowRunner.next;

        while (slowRunner != null){
            int val = vals.pop();
            if(val != slowRunner.val)
                return false;
            slowRunner = slowRunner.next;
        }
        return true;
    }

}
