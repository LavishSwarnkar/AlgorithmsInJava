package LeetCode.Jan2020;

import java.util.EmptyStackException;
import java.util.Stack;

public class P51_MinStack {

    public static void main(String args[]){
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    private static class MinStack {

        ListNode top, minTop;

        public MinStack() {
            top = null;
            minTop = null;
        }

        public void push(int x) {
            ListNode node = new ListNode(x);
            if(top == null) {
                top = minTop = node;
            } else {
                node.next = top;
                top = node;
            }
            if(x < minTop.val){
                node = new ListNode(x);
                node.next = minTop;
                minTop = node;
            }
        }

        public void pop() {
            if(top == null)
                throw new EmptyStackException();
            if(top.val == minTop.val)
                minTop = minTop.next;
            top = top.next;
        }

        public int top() {
            if(top == null)
                throw new EmptyStackException();
            return top.val;
        }

        public int getMin() {
            if(minTop == null)
                throw new EmptyStackException();
            return minTop.val;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
