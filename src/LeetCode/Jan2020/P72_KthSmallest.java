package LeetCode.Jan2020;

import LeetCode.Dec2019.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P72_KthSmallest {

    public static void main(String args[]){

    }

    //Using BFS
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0)
                return root.val;
            root = root.right;
        }
    }

    //Using In order traversal
    public static int kthSmallest2(TreeNode root, int k) {
        if(root == null)
            return -1;
        List<Integer> inOrderTraversal = new ArrayList<>();
        inOrderTraversal(root, inOrderTraversal);
        return inOrderTraversal.get(k-1);
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> list){
        if(root.left != null)
            inOrderTraversal(root.left, list);
        list.add(root.val);
        if(root.right != null)
            inOrderTraversal(root.right, list);
    }

}
