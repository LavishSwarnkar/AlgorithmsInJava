package LeetCode.Dec2019;

import java.util.Queue;
import java.util.Stack;

public class P12_FlattenMultilevelLinkedList {

    public static void main(String args[]){
        Node n1 = new Node(1)
                , n2 = new Node(2)
                , n3 = new Node(3);
        n1.child = n2;
        n2.child = n3;

        flatten(n1);
    }

    private static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    private static Node lastNodeOfPreviousLevel;
    public static Node flatten(Node head) {
        Node node = head, parent = null, child = null;
        if(node == null)
            return null;

        if(node.next == null && node.child != null){
            flatten(node.child);
            node.next = node.child;
            node.child.prev = node;
            node.child = null;
        }

        while (node.next != null){
            if(node.child != null){
                flatten(node.child);
                parent = node;
                child = node.child;
                lastNodeOfPreviousLevel.next = node.next;
                node.next.prev = lastNodeOfPreviousLevel;
            }
            node = node.next;
        }
        if(parent != null){
            parent.next = child;
            child.prev = parent;
            parent.child = null;
        }
        lastNodeOfPreviousLevel = node;
        return head;
    }

}
