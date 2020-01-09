package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

import java.util.*;

public class P68_BinaryTreeInOrderTraversal {

    public static void main(String args[]){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        System.out.println(inorderTraversal(root));
    }

    public static List <Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList <> ();
        Stack <TreeNode> stack = new Stack <> ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List < Integer > inorderTraversal3(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    //Dead-end
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> visitedNodes = new Stack<>();
        ListNode queue = new ListNode(root);
        while (queue != null) {
            TreeNode node = queue.val;
            queue = queue.next;
            if(node == null)
                continue;
            if ((!visitedNodes.isEmpty() && node == visitedNodes.peek()) || (node.left == null && node.right == null)){
                list.add(node.val);
                if(!visitedNodes.isEmpty())
                    visitedNodes.pop();
            } else {
                ListNode newHead = new ListNode(node.left);
                newHead.next = new ListNode(node);
                newHead.next.next = new ListNode(node.right);
                newHead.next.next.next = queue;
                queue = newHead;
                visitedNodes.push(node);
            }
        }
        return list;
    }

    private static class ListNode {
        TreeNode val;
        ListNode next;
        ListNode(TreeNode x) { val = x; }

        @Override
        public String toString() {
            if(val == null)
                return "NULL ";
            return val.val + " " + next;
        }
    }

}
